/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.*;
import java.net.*;
import java.rmi.RMISecurityManager;
import java.security.AccessControlException;
/**
 *
 * @author James
 */
public class clientRMI{
    private static interfaceRMI stub=null;
    static timeAvg times;
    static Menu mnu = new Menu();
    static int ThreadNum = 0;
    public static String ipAddress=null;
    public static int port=0;
   
    public static void main(String[] args)throws IOException{
    ipAddress = args[0];
    String portnumber=args[1];
    port=Integer.parseInt(portnumber);
    BufferedReader stdIn = new BufferedReader(
        new InputStreamReader(System.in));
        try{
            //System.setSecurityManager(new RMISecurityManager());
            Registry reg=LocateRegistry.getRegistry(ipAddress,port);
            stub=(interfaceRMI) reg.lookup("server");
            }
        catch (AccessControlException s){
            System.out.println(s.getPermission());
            s.printStackTrace();
            }
        catch (Exception e){
            System.err.println("Client problem: "+e.toString());
            e.printStackTrace();
            }
        String userInput;
        mnu.displayMenu();
        while ((userInput = stdIn.readLine()) != null) {
            if (mnu.validChoice(mnu.getReqNumber(userInput))) {
                ThreadNum = mnu.getThreadNum();
                times=new timeAvg(ThreadNum);
               
                //Spawn threads
                for (int x = 0; x < ThreadNum; x++) {
                    ThreadClient clientStub=new ThreadClient(stub,
                            mnu.getReqNumber(userInput));
                    clientStub.start();
                    }
                while(times.getFull())
                    ;
                times.display();
                }
                mnu.displayMenu();
            }
        }
    }
