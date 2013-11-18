/*
This is the implementation of the interface class and describes the do command
that the server's skeleton contains. The client threads call the remote object's version of this command.
*/
import java.rmi.*;
import java.io.*;
import java.net.*;

public class iRMIImpl  implements interfaceRMI{
    public String doCommand(int cin) throws RemoteException{
        System.out.println("Skeleton spawning new thread to do"
                + " clients command...");
        try{
        String com=cin+"";
        String inputString=null;
        String outputString="";
        if(com.equals("1"))
                com="date";
        if(com.equals("2"))
                com="uptime";
        if(com.equals("3"))
                com="free";
        if(com.equals("4"))
                com="netstat";
        if(com.equals("5"))
                com="who";
        if(com.equals("6"))
                com="ps-de";
                        Process process=Runtime.getRuntime().exec(com);
                        BufferedReader bufferedReader = new
                BufferedReader(new InputStreamReader(process.getInputStream()));
                        while((inputString = bufferedReader.readLine()) != null)
                                {
                                outputString=outputString+inputString;
                                }
                        try
                {
                process.waitFor();
            }
         catch (InterruptedException e)
            {
                e.printStackTrace();
            }
                        return outputString;
                        }
                catch(IOException e){
                        e.printStackTrace();
                        return "Error";
                        }      
                }
        }

