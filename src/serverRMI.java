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
        try{
            iRMIImpl test=new iRMIImpl();
            interfaceRMI stub=(interfaceRMI) UnicastRemoteObject.exportObject
                    (test, 0);
            Registry reg=LocateRegistry.createRegistry(6000);
            reg.rebind("server", stub);
            System.out.println("Server is online....");
            
            }
        catch (Exception e){
            System.err.println("Server problem: "+ e.toString());
            e.printStackTrace();
            }
        }
    }
