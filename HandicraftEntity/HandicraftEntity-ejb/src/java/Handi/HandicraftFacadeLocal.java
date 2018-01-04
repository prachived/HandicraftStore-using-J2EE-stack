/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handi;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Prachi
 */
@Local
public interface HandicraftFacadeLocal {

    void create(Handicraft handicraft);

    void edit(Handicraft handicraft);

    void remove(Handicraft handicraft);

    Handicraft find(Object id);

    List<Handicraft> findAll();

    List<Handicraft> findRange(int[] range);

    int count();
    
    

    public void findAll(String name_customer);
}
