/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author James
 */
public class serverRMI{
    public static void main(String args[]){
    String portnumber=args[0];
    int port=Integer.parseInt(portnumber);
        try{
            System.setSecurityManager(new RMISecurityManager());
            iRMIImpl test=new iRMIImpl();
            interfaceRMI stub=(interfaceRMI) UnicastRemoteObject.exportObject
                    (test, 0);
            Registry reg=LocateRegistry.createRegistry(port);
            reg.rebind("server", stub);
            System.out.println("Server is online....");
            }
        catch (Exception e){
            System.err.println("Server problem: "+ e.toString());
            e.printStackTrace();
            }
        }
    }
