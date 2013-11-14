
import java.net.*;
import java.io.*;
import java.rmi.RemoteException;
/**
 *
 * @author Chris Koivu
 */
public class ThreadClient extends Thread {
   private interfaceRMI stub=null;
   //private String line;
   private PrintWriter outData = null;
   private BufferedReader inData = null;
   //private Boolean active;
   private int UserNum;
   Menu mnu = new Menu();    
  
           
   ThreadClient(interfaceRMI stubin, int userChoice) {
     stub=stubin;
     UserNum=userChoice;
   }
   
    public void run() {
        try {
            String output;
            Long Start, Stop, time;
            Start=System.currentTimeMillis();
            output=stub.doCommand(UserNum);
            Stop=System.currentTimeMillis();
            time=Stop-Start;
            System.out.println(output);
            System.out.println("Time: "+time);
            //active = true;
        } catch (RemoteException e) {
            System.err.println("Don't know about stub");
            System.exit(1);
        }
    }
}
