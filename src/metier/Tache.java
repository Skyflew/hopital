/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "TACHE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tache.findAll", query = "SELECT t FROM Tache t")
    , @NamedQuery(name = "Tache.findById", query = "SELECT t FROM Tache t WHERE t.id = :id")
    , @NamedQuery(name = "Tache.findByTempsprod", query = "SELECT t FROM Tache t WHERE t.tempsprod = :tempsprod")
    , @NamedQuery(name = "Tache.findByDatedebut", query = "SELECT t FROM Tache t WHERE t.datedebut = :datedebut")
    , @NamedQuery(name = "Tache.findByDatelimite", query = "SELECT t FROM Tache t WHERE t.datelimite = :datelimite")
    , @NamedQuery(name = "Tache.findByPenaliteretard", query = "SELECT t FROM Tache t WHERE t.penaliteretard = :penaliteretard")})
public class Tache implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TEMPSPROD")
    private int tempsprod;
    @Column(name = "DATEDEBUT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebut;
    @Basic(optional = false)
    @Column(name = "DATELIMITE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelimite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PENALITERETARD")
    private Double penaliteretard;
    @JoinColumn(name = "NMACHINE", referencedColumnName = "ID")
    @ManyToOne
    private Machine nmachine;

    public Tache() {
        this.id = hashCode();
    }

    public Tache(Integer id) {
        this.id = id;
    }

    public Tache(Integer id, int tempsprod, Date datelimite) {
        this.id = id;
        this.tempsprod = tempsprod;
        this.datelimite = datelimite;
    }
    
    public Tache(int tempsprod,Date datelimite,Double penaliteretard) {
        this.tempsprod = tempsprod;
        this.datelimite = datelimite;
        this.penaliteretard =penaliteretard;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTempsprod() {
        return tempsprod;
    }

    public void setTempsprod(int tempsprod) {
        this.tempsprod = tempsprod;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatelimite() {
        return datelimite;
    }

    public void setDatelimite(Date datelimite) {
        this.datelimite = datelimite;
    }

    public Double getPenaliteretard() {
        return penaliteretard;
    }

    public void setPenaliteretard(Double penaliteretard) {
        this.penaliteretard = penaliteretard;
    }

    public Machine getNmachine() {
        return nmachine;
    }

    public void setNmachine(Machine nmachine) {
        this.nmachine = nmachine;
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
        if (!(object instanceof Tache)) {
            return false;
        }
        Tache other = (Tache) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tache{" + "id=" + id + ", tempsprod=" + tempsprod + ", datedebut=" + datedebut + ", datelimite=" + datelimite + ", penaliteretard=" + penaliteretard + ", nmachine=" + nmachine + '}';
    }

   
    
}
