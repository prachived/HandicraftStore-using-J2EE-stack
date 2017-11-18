/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsb;

import javax.ejb.Local;

/**
 *
 * @author Prachi
 */
@Local
public interface HandiStatefulBeanLocal {
    public int buy(String prod,int quant);
    public int bill();
    
    
    
}
