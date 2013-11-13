/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;
import java.io.*;
import java.net.*;
/**
 *
 * @author James
 */
public class iRMIImpl  implements interfaceRMI{
	public String doCommand(int cin) throws RemoteException{
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
