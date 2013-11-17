
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
