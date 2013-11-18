/*
This interface describes the doCommand method that should take in a command integer
and returns a string which is the response to the command.
*/
import java.rmi.*;

public interface interfaceRMI extends Remote{
    public String doCommand(int cin) throws RemoteException;
    }
