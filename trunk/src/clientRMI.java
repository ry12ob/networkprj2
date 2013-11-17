
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.*;
import java.net.*;
import java.rmi.RMISecurityManager;
import java.security.AccessControlException;

public class clientRMI{
    private static interfaceRMI stub=null;
    static timeAvg times;
    static Menu mnu = new Menu();
    static int ThreadNum = 0;
    public static String ipAddress=null;
    public static int port=0;
   
    public static void main(String[] args)throws IOException{
    if(args.length != 2){
        System.out.println("Program needs to have two command arguments to run"
                + " the ipAddress of the server machine and the port "
                + "number the stub is using.");
        System.exit(1);
        }
    ipAddress = args[0];
    String portnumber=args[1];
    port=Integer.parseInt(portnumber);
    BufferedReader stdIn = new BufferedReader(
        new InputStreamReader(System.in));
    try{
        Registry reg=LocateRegistry.getRegistry(ipAddress,port);
        stub=(interfaceRMI) reg.lookup("server");
        }
    catch (AccessControlException s){
        System.out.println("Unable to establish connection."
                + " Program will now terminate....");
        System.exit(1);
        }
    catch (Exception e){
        System.err.println("Client problem: "+e.toString()+"\n Program will"
                + " now terminate....");
        System.exit(1);
        }
    String userInput;
    mnu.displayMenu();
    while ((userInput = stdIn.readLine()) != null) {
        if (mnu.validChoice(mnu.getReqNumber(userInput))) {
            if(userInput.equals("7")){
                System.out.println("Exit command invoked. Program will"
                        + " now exit...");
                break;
                }
            ThreadNum = mnu.getThreadNum();
             times=new timeAvg(ThreadNum);
             if(ThreadNum!=0){
                for (int x = 0; x < ThreadNum; x++) {
                    System.out.println("Creating Threads");
                    ThreadClient clientStub=new ThreadClient(stub,
                        mnu.getReqNumber(userInput));
                    clientStub.start();
                    }
                }
             if (ThreadNum != 0){
               while(times.getFull());
               times.display();
               }
             }
        mnu.displayMenu();
        }
    }
}
