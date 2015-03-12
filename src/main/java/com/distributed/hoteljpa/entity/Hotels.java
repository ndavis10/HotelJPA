/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distributed.hoteljpa.entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author viewt_000
 */
@Entity
@Table(name = "hotels")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotels.findAll", query = "SELECT h FROM Hotels h"),
    @NamedQuery(name = "Hotels.findByHotelId", query = "SELECT h FROM Hotels h WHERE h.hotelId = :hotelId"),
    @NamedQuery(name = "Hotels.findByHotelName", query = "SELECT h FROM Hotels h WHERE h.hotelName = :hotelName"),
    @NamedQuery(name = "Hotels.findByStreetAddress", query = "SELECT h FROM Hotels h WHERE h.streetAddress = :streetAddress"),
    @NamedQuery(name = "Hotels.findByCity", query = "SELECT h FROM Hotels h WHERE h.city = :city"),
    @NamedQuery(name = "Hotels.findByState", query = "SELECT h FROM Hotels h WHERE h.stateName = :stateName"),
    @NamedQuery(name = "Hotels.findByPostalCode", query = "SELECT h FROM Hotels h WHERE h.postalCode = :postalCode"),
    @NamedQuery(name = "Hotels.findByNotes", query = "SELECT h FROM Hotels h WHERE h.notes = :notes")})
public class Hotels implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hotel_id")
    private Integer hotelId;
    @Basic(optional = false)
    @Column(name = "hotel_name")
    private String hotelName;
    @Basic(optional = false)
    @Column(name = "street_address")
    private String streetAddress;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "state")
    private String stateName;
    @Basic(optional = false)
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "notes")
    private String notes;

    public Hotels() {
    }

    public Hotels(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Hotels(Integer hotelId, String hotelName, String streetAddress, String city, String stateName, String postalCode) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.stateName = stateName;
        this.postalCode = postalCode;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelId != null ? hotelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotels)) {
            return false;
        }
        Hotels other = (Hotels) object;
        if ((this.hotelId == null && other.hotelId != null) || (this.hotelId != null && !this.hotelId.equals(other.hotelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityreverseengineer.Hotels[ hotelId=" + hotelId + " ]";
    }
    
}
