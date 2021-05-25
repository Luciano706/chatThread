/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Toyfr
 */
public class ClientHandler extends Thread{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    //private Server server = e;
    
    public ClientHandler(Socket socket){
        this.clientSocket=socket;
    }
    
    public void run(){
        try{
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        }
        catch(IOException e){
            System.out.println("Eccezione catturata");
        }
        startHandler();
        String inputLine="";
        try{
            System.out.println("Prima del while");
            while((inputLine = in.readLine()) != null){
                System.out.println("dopo il while");
                if(inputLine.equals("/exit")){
                    //out.println("Buona giornata!");
                    System.out.println("Connessione terminata");
                    //this.stop();                    
                    in.close();
                    out.close();
                    clientSocket.close();
                    break;
                }
                System.out.println("Messaggio ricevuto: " + inputLine);                
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void startHandler(){
        String messaggio;
        //System.out.println("prima ancora");
        //start();
        //System.out.println("un po' prima");
        while(this.isAlive()){
            System.out.println("Ciclo fatto");
            //System.out.print("Risposta: ");
            messaggio=Input.readLine();
            out.println(messaggio);
            if(messaggio.equalsIgnoreCase("/exit")){
                //this.stop(); 
                try{
                    in.close();
                    out.close();
                    clientSocket.close();
                }
                catch(Exception e){
                    
                }
                System.out.println("Connessione terminata");
                //return;
            }
        }
    }
}
