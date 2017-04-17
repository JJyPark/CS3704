/*
 *Created by Jason You, Chris Hill, Justin Park, Shawn Zhang on 2017.04.17 
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
