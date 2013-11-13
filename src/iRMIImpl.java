/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;
/**
 *
 * @author James
 */
public class iRMIImpl  implements interfaceRMI{
    public static int command=20;
    public static String response="|";
    
    public void setCommand(int cin) throws RemoteException{
        command=cin;
        }
    
    public int getCommand() throws RemoteException{
        return command;
        }
    
    public String getResponse() throws RemoteException{
        return response;
        } 
    
    public void setResponse(String rin) throws RemoteException{
        response=rin;
        }
    }
