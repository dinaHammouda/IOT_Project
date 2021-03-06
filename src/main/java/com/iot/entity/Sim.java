/**
 * 
 */
package com.iot.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author dina.hammouda
 */
@Entity
@Table(name = "sim")

public class Sim implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "operator_code")
    private Integer operatorCode;
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne
    private SimStatus status;
    @JoinColumn(name = "country", referencedColumnName = "id")
    @OneToOne
    private Country country;
    @OneToMany(mappedBy = "simId")
    private List<Device> deviceList;

    public Sim() {
    }

    public Sim(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(Integer operatorCode) {
        this.operatorCode = operatorCode;
    }

    public SimStatus getStatus() {
        return status;
    }

    public void setStatus(SimStatus statusId) {
        this.status = statusId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country countryId) {
        this.country= countryId;
    }


    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
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
        if (!(object instanceof Sim)) {
            return false;
        }
        Sim other = (Sim) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication5.Sim[ id=" + id + " ]";
    }
    
}
