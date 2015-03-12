/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distributed.hoteljpa.ejb;

import com.distributed.hoteljpa.entity.Hotels;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author viewt_000
 */
@Stateless
public class HotelsFacade extends AbstractFacade<Hotels> {
    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HotelsFacade() {
        super(Hotels.class);
    }
    
    public List<Hotels> findByState(String stateName)
    {
        Query q = this.getEntityManager().createNamedQuery("Hotels.findByState");
        q.setParameter(1, stateName);
        return q.getResultList();
    }
    
    public List<Hotels> findByCity(String city)
    {
        Query q = this.getEntityManager().createNamedQuery("Hotels.findByCity");
        q.setParameter(1, city);
        return q.getResultList();
    }
    
}
