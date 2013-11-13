/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author James
 */
public class clientRMI{
    private static interfaceRMI stub=null;
    
    public static void main(String[] args){
        try{
		  		String out="blah";
            Registry reg=LocateRegistry.getRegistry("localhost");
            stub=(interfaceRMI) reg.lookup("server");
				out=stub.doCommand(1);
            }
        catch (Exception e){
            System.err.println("Client problem: "+e.toString());
            e.printStackTrace();
            }
        }
    }
