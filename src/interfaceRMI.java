/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;
/**
 *
 * @author James
 */
public interface interfaceRMI extends Remote{
    public int getCommand() throws RemoteException;
    public String getResponse() throws RemoteException;
    public void setCommand(int cin) throws RemoteException;
    public void setResponse(String rin) throws RemoteException;
    }
