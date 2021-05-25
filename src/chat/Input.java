package chat;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Input {
   static InputStreamReader input = new InputStreamReader(System.in);
   static BufferedReader keyboard = new BufferedReader(input);

   public static String readLine(){
       String s = "";
       try{
           s=keyboard.readLine();
           return s;
       }
       catch(Exception e){
           System.out.println("Errore nel legger cio' che e' stato inserito da tastiera");
           return s;
       }
   }

   
   public static int readInt(){
       String s;
       int n;
       try{
           s=keyboard.readLine();
           n= Integer.valueOf(s).intValue();
           //n=Integer.parseInt(s); in alternativa si può utilizzare pure questo metodo
           return n;
       }
       catch(NumberFormatException e){
           System.out.println("Errore di formato");
           return -1;
       }
       catch(IOException e){
           System.out.println("Errore nel leggere il numero inserito");
           return -2;
       }
   }
   
   public static double readDouble()
    {
        String arg="";

        try
        {
            arg= keyboard.readLine();
            return Double.valueOf(arg).doubleValue();
        }
        catch (Exception e){
            System.out.println("Errore nel leggere il numero inserito");
            return -1;
        }
    }
}
