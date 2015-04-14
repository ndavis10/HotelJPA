/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distributed.hoteljpa.ejb;

import com.distributed.hoteljpa.entity.Authorities;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author viewt_000
 */
@Stateless
public class AuthoritiesFacade extends AbstractFacade<Authorities> {
    @PersistenceContext(unitName = "hotelPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuthoritiesFacade() {
        super(Authorities.class);
    }
    
}
