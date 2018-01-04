/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handi;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Prachi
 */
@Stateless
public class HandicraftFacade extends AbstractFacade<Handicraft> implements HandicraftFacadeLocal {
    @PersistenceContext(unitName = "HandicraftEntity-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HandicraftFacade() {
        super(Handicraft.class);
    }

    /**
     *
     * @param name_customer
     */
    @Override
    public void findAll(String name_customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
