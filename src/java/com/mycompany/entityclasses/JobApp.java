/*
 *Created by Jason You, Chris Hill, Justin Park, Shawn Zhang on 2017.04.17 
 */
package com.mycompany.entityclasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jason
 * @author Justin Park
 * Updated: April 19, 2017
 */
@Entity
@Table(name = "JobApp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobApp.findAll", query = "SELECT j FROM JobApp j")
    , @NamedQuery(name = "JobApp.findById", query = "SELECT j FROM JobApp j WHERE j.id = :id")
    , @NamedQuery(name = "JobApp.findByDate", query = "SELECT j FROM JobApp j WHERE j.jobDate = :jobDate")
    , @NamedQuery(name = "JobApp.findByCompany", query = "SELECT j FROM JobApp j WHERE j.company = :company")
    , @NamedQuery(name = "JobApp.findByPosition", query = "SELECT j FROM JobApp j WHERE j.position = :position")
    , @NamedQuery(name = "JobApp.findByLocation", query = "SELECT j FROM JobApp j WHERE j.location = :location")
    , @NamedQuery(name = "JobApp.findByTypeOfWork", query = "SELECT j FROM JobApp j WHERE j.typeOfWork = :typeOfWork")})
public class JobApp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "myDate")
    private java.sql.Date jobDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "position")
    private String position;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "type_of_work")
    private String typeOfWork;
    
    public JobApp() {
        java.util.Date today = new java.util.Date();
        this.jobDate = new java.sql.Date(today.getTime());
    }

    public JobApp(Integer id) {
        this.id = id;
        java.util.Date today = new java.util.Date();
        this.jobDate = new java.sql.Date(today.getTime());
    }

    public JobApp(Integer id, String company, String position, String location, String typeOfWork) {
        this.id = id;
        this.company = company;
        this.position = position;
        this.location = location;
        this.typeOfWork = typeOfWork;
        java.util.Date today = new java.util.Date();
        this.jobDate = new java.sql.Date(today.getTime());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public java.sql.Date getJobDate() {
        return jobDate;
    }

    public void setJobDate(java.sql.Date jobDate) {
        this.jobDate = jobDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof JobApp)) {
            return false;
        }
        JobApp other = (JobApp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Job App : [ id=" + id + " ]");
        str.append("\n[ date=" + jobDate + " ]");
        str.append("\n[ company=" + company + " ]");
        str.append("\n[ position=" + position + " ]");
        str.append("\n[ location=" + location + " ]");
        str.append("\n[ type of work=" + typeOfWork + " ]");
        return str.toString();
    }

}
