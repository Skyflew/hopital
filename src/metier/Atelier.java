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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ATELIER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atelier.findAll", query = "SELECT a FROM Atelier a")
    , @NamedQuery(name = "Atelier.findById", query = "SELECT a FROM Atelier a WHERE a.id = :id")
    , @NamedQuery(name = "Atelier.findByDatedispo", query = "SELECT a FROM Atelier a WHERE a.datedispo = :datedispo")})
public class Atelier implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "natelier")
    private Collection<Machine> machineCollection;

    public Atelier() {
        setMachineCollection(new ArrayList<Machine>());
        this.id = hashCode();
    }

    public boolean addMachine(Machine m){
        m.setNatelier(this);
        return getMachineCollection().add(m);
    }
    
    public Atelier(Integer id) {
        this.id = id;
    }

    public Atelier(Integer id, Date datedispo) {
        this.id = id;
        this.datedispo = datedispo;
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

    @XmlTransient
    public Collection<Machine> getMachineCollection() {
        return machineCollection;
    }

    public void setMachineCollection(Collection<Machine> machineCollection) {
        this.machineCollection = machineCollection;
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
        if (!(object instanceof Atelier)) {
            return false;
        }
        Atelier other = (Atelier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Atelier{" + "id=" + id + ", datedispo=" + datedispo + ", machineCollection=" + machineCollection + '}';
    }

    
    
}
