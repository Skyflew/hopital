/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "MACHINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Machine.findAll", query = "SELECT m FROM Machine m")
    , @NamedQuery(name = "Machine.findById", query = "SELECT m FROM Machine m WHERE m.id = :id")
    , @NamedQuery(name = "Machine.findByDatedispo", query = "SELECT m FROM Machine m WHERE m.datedispo = :datedispo")
    , @NamedQuery(name = "Machine.findByPenalitetotale", query = "SELECT m FROM Machine m WHERE m.penalitetotale = :penalitetotale")})
public class Machine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DATEDISPO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedispo;
    @Basic(optional = false)
    @Column(name = "PENALITETOTALE")
    private double penalitetotale;
    @JoinColumn(name = "NATELIER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Atelier natelier;
    @OneToMany(mappedBy = "nmachine")
    private Collection<Tache> tacheCollection;

    public Machine() {
        datedispo = new Date();
        this.tacheCollection = new ArrayList<>();
        this.id = hashCode();
    }

    public Machine(Integer id) {
        this.id = id;
    }

    public Machine(Integer id, Date datedispo, double penalitetotale) {
        this.id = id;
        this.datedispo = datedispo;
        this.penalitetotale = penalitetotale;
    }
    
    public boolean addTache(Tache t){
        t.setNmachine(this);
        t.setDatedebut(datedispo);
        this.datedispo = (new Date(datedispo.getTime() + t.getTempsprod()*60000));
        if(t.getDatelimite().getTime()<this.getDatedispo().getTime()){
            this.setPenalitetotale(((this.getDatedispo().getTime()/60000)-(t.getDatelimite().getTime()/60000))*t.getPenaliteretard());
        }
        return getTacheCollection().add(t);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatedispo() {
        return datedispo;
    }

    public void setDatedispo(Date datedispo) {
        this.datedispo = datedispo;
    }

    public double getPenalitetotale() {
        return penalitetotale;
    }

    public void setPenalitetotale(double penalitetotale) {
        this.penalitetotale = penalitetotale;
    }

    public Atelier getNatelier() {
        return natelier;
    }

    public void setNatelier(Atelier natelier) {
        this.natelier = natelier;
    }

    @XmlTransient
    public Collection<Tache> getTacheCollection() {
        return tacheCollection;
    }

    public void setTacheCollection(Collection<Tache> tacheCollection) {
        this.tacheCollection = tacheCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Machine)) {
            return false;
        }
        Machine other = (Machine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Machine{" + "id=" + id + ", datedispo=" + datedispo + ", penalitetotale=" + penalitetotale + ", natelier=" + natelier + ", tacheCollection=" + tacheCollection + '}';
    }

    
}
