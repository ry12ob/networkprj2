import java.io.*;
import java.lang.StringBuilder;


/**
 * This class presents a user menu for input
 * @author Chris Koivu
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
                "Enter Selection:   ";
        StringBuilder builderS=new StringBuilder(menuS);
        System.out.println(builderS);
      }// end displayMenu
     
      /**
       * this method reads user entry from the keyboard
       * @return integer representing the menu option
       */
       public void getEntry() throws IOException
       {
         String s = getString();
         reqNumber = Integer.parseInt(s);
       }// end getEntry method
     
      /**
       * this method is an accessor method for the
       * reqNumber variable
       * @return integer
       */
      public int getReqNumber(String s) throws NumberFormatException{  
          int reqNum = 0;
          try{
             reqNum = Integer.parseInt(s);
          }
          catch(NumberFormatException e){
             System.out.println("## INVALID MENU SELECTION ##");            
          }
          return reqNum;        
      }// end getreqNumber method
     
      public boolean validChoice (int selNumber){            
          if (selNumber > 0 && selNumber < 8)
             return true;
          System.out.println("## INVALID ENTRY. PLEASE TRY AGAIN ##");
          return false;
      }// end validChoice method  
       
     
      public String getString() throws IOException
      {
         InputStreamReader isr = new InputStreamReader(System.in);
         BufferedReader br2 = new BufferedReader(isr);
         String s = br2.readLine();
         return s;
      }
     
      public int getThreadNum() throws IOException{
        System.out.println("Enter the number of threads for this action:\n");
        String s=getString();
        int x=Integer.parseInt(s);
        while(x<=0&&x>=50){
            System.out.println("Please enter a number between 0 and 50. 0"
                    + "to stop.");
            s=getString();
            x=Integer.parseInt(s);
            }
        return x;
        }  
    }//end Menu class

