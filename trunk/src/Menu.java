import java.io.*;
import java.lang.StringBuilder;


/**
 * This class handels an object that has methods to display a menu.
 */
public class Menu {
 
   /** request number for function desired */
   private int reqNumber = 0;    
   /** Buffered reader br */
   BufferedReader br;  
   
   /** empty class constructor */
   public void Menu(){
       
   }
     
      /**
       * this method displays a user menu
       * @return none
       */
      public void displayMenu(){
        String menuS=String.format("\n%50s","Please make a selection:\n")+
                String.format("%35s","1. Host current Date and Time\n")+
                String.format("%20s","2. Host uptime\n")+
                String.format("%24s","3. Host memory use\n")+
                String.format("%21s","4. Host Netstat\n")+
                String.format("%27s","5. Host current users\n")+
                String.format("%31s","6. Host running processes\n")+
                String.format("%13s","7. Quit\n")+
                "\nEnter Selection: ";
        StringBuilder builderS=new StringBuilder(menuS);
        System.out.print(builderS);
       
      }// end displayMenu
     
      /*
       * this method converts a strign which should be the user's choice 
       * and catches number format exception if the string cannot be parsed
       * which shoud meen that it has a string in it.
       */
      public int getReqNumber(String s) throws NumberFormatException{  
          int reqNum = 0;
          try{
             reqNum = Integer.parseInt(s);
             reqNumber = reqNum;
          }
          catch(NumberFormatException e){
             System.out.println("## INVALID MENU SELECTION ##");            
          }
          return reqNum;        
      }// end getreqNumber method
     
      /*
       * This method tests to see if the user's choice in the range of possible
       * choices for the menu
       */
      public boolean validChoice (int selNumber){            
          if (selNumber > 0 && selNumber < 8)
             return true;
          System.out.println("## INVALID ENTRY. PLEASE TRY AGAIN ##");
          return false;
      }// end validChoice method  
       
      /*
       * This method reads the user's choice off the System.
       */
      public String getString() throws IOException
      {
         InputStreamReader isr = new InputStreamReader(System.in);
         BufferedReader br2 = new BufferedReader(isr);
         String s = br2.readLine();
         return s;
      }
      
      /*
       * This method returns 0 if the user chose to exit with 7. If not then
       * it gets the number of threads the user wants, tests to see if it is
       * one of the choices if not then it tells the user that they put in 
       * a bad selection, asks them to try again, and then redisplays the 
       * message for number of threads.
       */
      public int getThreadNum() throws IOException{
      int x = 0;
        if (reqNumber != 7){
        System.out.print("Enter the number of threads for this action: ");
        String s=getString();
        try{
        x = Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            System.out.println("## INVALID THREAD NUMBER SELECTION ##\n "
                    + "PLEASE TRY AGAIN");
            x=getThreadNum();
        }
        System.out.println();
        while(x<0||x>50){
            System.out.print("Please enter a number between 0 and 50. 0 "
                    + "to stop: ");
            s=getString();
            try{
                x = Integer.parseInt(s);
                }
            catch (NumberFormatException e){
            System.out.println("## INVALID THREAD NUMBER SELECTION ##\n "
                    + "PLEASE TRY AGAIN");
            }
            }
        }
        return x;
      }
    }//end Menu class

