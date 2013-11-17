import java.net.*;
import java.io.*;
import java.rmi.RemoteException;

public class ThreadClient extends Thread {
    private interfaceRMI stub=null;
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
            System.out.println("Connection established to"+
                    clientRMI.ipAddress+" on port "+
                    clientRMI.port);
            Start=System.currentTimeMillis();
            output=stub.doCommand(UserNum);
            Stop=System.currentTimeMillis();
            time=Stop-Start;
            System.out.println(output);
            clientRMI.times.addTime(time);
       } catch (RemoteException e) {
            System.err.println("Don't know about stub");
            e.printStackTrace();
            System.exit(1);
        }
    }
}

