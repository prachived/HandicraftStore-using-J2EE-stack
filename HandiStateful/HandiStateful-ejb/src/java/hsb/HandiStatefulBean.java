/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsb;

import javax.ejb.Stateful;

/**
 *
 * @author Prachi
 */
@Stateful
public class HandiStatefulBean implements HandiStatefulBeanLocal {
    String products[]={"MiniatureCat","MatchstickFigure","BambooElephants","WovenCoil","BambooBaskets"};
    int quan[]={5,10,15,20,25};
    int cost[]={199,299,399,149,140};
    int cost1[]={0,0,0,0,0};
   int cost2[]={0,0,0,0,0};
    int i;

    
    
    @Override
    public int buy(String prod,int quant)
    {
        for(i=0;i<products.length;i++)
        {
            if(prod.equalsIgnoreCase(products[i]))
            {
                if(quant<quan[i])
                {     
                    quan[i]-=quant;
                    if(quan[i]<1)
                        break;
                    cost1[i]=cost[i]*quant;
                    if(cost2[i]==0)
                        cost2[i]=cost1[i];
                    else
                        cost2[i]=cost2[i]+cost1[i];
                    return cost1[i];
                }
            }
            
        }
        
        return -1;
    }
   
    /**
     *
     * @return
     */
    @Override
    public int bill()
    {
        int sum=0;
        for(i=0;i<products.length;i++)
        {
            sum=sum+cost2[i];
        }
        return sum;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
