/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author James
 */
public class clientRMI{
    private static interfaceRMI stub=null;
    
    public static void main(String[] args){
        System.out.println("Blah");
        try{
            Registry reg=LocateRegistry.getRegistry("localhost");
            stub=(interfaceRMI) reg.lookup("server");
            }
        catch (Exception e){
            System.err.println("Client problem: "+e.toString());
            e.printStackTrace();
            }
        tryget(2);
        String response="";
        response=getResponse();
        System.out.println(response);
        }
    
    public static void tryget(int c){
        try{
            stub.setCommand(c);
            System.out.println("Command is: "+c);
            }
        catch (Exception e){
            
            }
        }
    
    public static String getResponse(){
        try{
            String blah="";
            while((blah=(stub.getResponse()))=="|");
            return blah;
            }
        catch (Exception e){
            return "|";
            }
        }
    }
