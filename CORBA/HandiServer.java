import HandiApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;
class HandiImpl extends HandiPOA 
{
	private ORB orb;
	
	
	String st[]={"Wall Hangings--Baskets--Sculptures","MatchStick Figure--Miniature Cat--","Woven Bamboo Basket--Coil Basket--","Bamboo Elephant--Wooden Buddha"};
	String mat[][]={{"100","200"},{"50","600"},{"1200","2100"}};
	int amt=0,ctr=0;
	
	public void setORB(ORB orb_val) 
	{
		orb = orb_val; 
	}
	public String display(String s) 
	{
		
		int x=Integer.parseInt(s);
		
		return st[x];
	}
	public String getprice(String x1,String y1) 
	{
		int x=Integer.parseInt(x1);
		int y=Integer.parseInt(y1);
		return mat[x][y];
		
	}
	public String tot(String x1)
	{

			int x=Integer.parseInt(x1);
			
			amt+=x;
			
			return amt+"";
	}
	
	public void shutdown() 
	{
		orb.shutdown(true);
	}
}
public class HandiServer 
{
	public static void main(String args[]) 
	{
		try
		{
			ORB orb = ORB.init(args, null);
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			HandiImpl handiImpl = new HandiImpl();
			handiImpl.setORB(orb); 
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(handiImpl);
			Handi href = HandiHelper.narrow(ref);
			org.omg.CORBA.Object objRef =orb.resolve_initial_references("NameService");
	      // Use NamingContextExt which is part of the Interoperable
	      // Naming Service (INS) specification.
	      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	
	      // bind the Object Reference in Naming
	      String name = "Hello";
	      NameComponent path[] = ncRef.to_name( name );
	      ncRef.rebind(path, href);

	      System.out.println("HelloServer ready and waiting ...");

	      // wait for invocations from clients
	      orb.run();
	    } 
		
	      catch (Exception e) {
	        System.err.println("ERROR: " + e);
	        e.printStackTrace(System.out);
	      }
		  
     System.out.println("HelloServer Exiting ...");
	  }
	}
