/*
This class describes the creation and run of the threads used by 
clientRMI. The thread recrods the start time, calls the doCommand using 
provided remote object and user choice recording the response from the command
in the output string, records the end time after the info has come back, 
calculates the total time in milliseconds that has elapsed, prints the output,
and then adds the time calculated to the times object in clientRMI
*/
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

