/*
 * Created by Jisu You on 2017.04.12  * 
 * Copyright © 2017 Jisu You. All rights reserved. * 
 */
package com.mycompany.sessionbeans;

import com.mycompany.entityclasses.JobApp;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jason
 */
@Stateless
public class JobAppFacade extends AbstractFacade<JobApp> {

    @PersistenceContext(unitName = "CS3704PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JobAppFacade() {
        super(JobApp.class);
    }
    
}
