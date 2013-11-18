/*
This program is the Server main for the RMI project. It creates an object of an 
implementation of a interface. This implementation has a method that takes a number as a command
and returns the info from the server to the client that asked. The server makes this object a remote object (the skeleton)
called stub and binds it to a registry on a given port (given in the run arguments). This stub is the basis of RMI and creates 
threads in the background whenever a client invokes a method.
*/
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class serverRMI{
    public static void main(String args[]){
        if(args.length!=1){
            System.out.println("Program needs one command argument to run:"
                    + " the port number for the server to run on/be identified"
                    + " with");
        }
        String portnumber=args[0];
        int port=Integer.parseInt(portnumber);
            try{
                System.out.println("Server is online...");
                iRMIImpl test=new iRMIImpl();
                interfaceRMI stub=(interfaceRMI) UnicastRemoteObject.exportObject
                        (test, 0);
                Registry reg=LocateRegistry.createRegistry(port);
                reg.rebind("server", stub);
                System.out.println("Skeleton created on port "+port+"....");
                }
            catch (Exception e){
                System.err.println("Server problem: "+ e.toString());
                e.printStackTrace();
                System.exit(1);
                }
        }
    }
