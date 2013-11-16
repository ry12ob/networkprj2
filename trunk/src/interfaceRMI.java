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
    /*public String getDate();
         public String getuptime();
         public String getfree();
         public String getnetstat();
         public String getwho();
         public String getpsde();*/
         public String doCommand(int cin) throws RemoteException;
    }
