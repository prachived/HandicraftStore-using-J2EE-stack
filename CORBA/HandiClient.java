import java.util.*;

import HandiApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class HandiClient
{
  static Handi handiImpl;

  public static void main(String args[])
    {
      
	  Scanner sc=new Scanner(System.in);
	  
	  try{
        // create and initialize the ORB
	ORB orb = ORB.init(args, null);

        // get the root naming context
        org.omg.CORBA.Object objRef = 
	    orb.resolve_initial_references("NameService");
        // Use NamingContextExt instead of NamingContext. This is 
        // part of the Interoperable naming Service.  
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
 
        // resolve the Object Reference in Naming
        String name = "Hello";
        handiImpl = HandiHelper.narrow(ncRef.resolve_str(name));

        //System.out.println("Obtained a handle on server object: " + handiImpl);
        
		while(true)
		{
			String s=handiImpl.display("0");
			String menu[]=s.split("--");
			for(int i=0;i<menu.length;i++)
			{
				System.out.println(" "+(i+1)+"  "+menu[i]);
				
			}
			System.out.println("Enter Your Choice ( 0 to exit) ");
			int ch=sc.nextInt();
			
			if(ch==0)
				break;
			s=ch+"";
			ch--;
			String s1=handiImpl.display(s);
			String menu1[]=s1.split("--");
			for(int i=0;i<menu1.length;i++)
			{
				System.out.println(" "+(i+1)+"  "+menu1[i] +"    ......      "+handiImpl.getprice(ch+"",i+"")+"  per item");
				
			}
			System.out.println("Enter Your Choice ( 0 to go back) ");
			int ch1=sc.nextInt();
			if(ch1==0)
				continue;
			System.out.println("Enter Qty");
			int kg=sc.nextInt();
			
			ch1--;
			int price=kg*Integer.parseInt(handiImpl.getprice(ch+"",ch1+""));
			System.out.println("Price is   "+ price);
			System.out.println("Current Total is   "+ handiImpl.tot(price+""));
			
			
			
		}
		
		System.out.println("Final Bill is  "+ handiImpl.tot("0")+"\n  Thank you for Shopping");
		
		
		
		
		
		
        handiImpl.shutdown();

	} catch (Exception e) {
          System.out.println("ERROR : " + e) ;
	  e.printStackTrace(System.out);
	  }
    }

}
