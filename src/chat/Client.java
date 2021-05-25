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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Toyfr
 */
public class Client extends Thread{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    
    
    
    public void run(){
        String inputLine="";
        try{
            while((inputLine = in.readLine()) != null){
                if(inputLine.equals("/exit")){
                    //out.println("Buona giornata!");
                    System.out.println("Connessione terminata");                                       
                    this.stopConnection();
                    //this.stop();
                    break;
                }
                System.out.println("Messaggio ricevuto: " + inputLine);                
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
    
    
    public void startConnection(String ip, int port){
        try {
            clientSocket = new Socket(ip,port);
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }
    
    public void sendMessage(String msg){
        out.println(msg);
        String risposta = "";         
        /*try {
            //risposta = in.readLine();
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        //return risposta;*/
    }
    
    public void stopConnection(){
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String risposta;
        Client client = new Client();
        client.startConnection("127.0.0.1", 9042);
        if(client.in == null){
            System.out.println("Impossibile collegarsi al server");
            return;
        }
        String messaggio;
        boolean continua=true;
        System.out.println("Benvenuto nella chat");
        System.out.println("Client startato");
        System.out.println("Inserisci il messaggio da inviare(inserisci '/exit' per terminare la conversazione): ");
        client.start();
        while(client.isAlive()){
            //System.out.print("Messaggio: ");
            messaggio=Input.readLine();
            client.sendMessage(messaggio);
            if(messaggio.equalsIgnoreCase("/exit")){
                //client.stop();                
                client.stopConnection();
                System.out.println("Connessione terminata");
                //return;
            }            
        }
        //client.sendMessage(".");
        //System.out.println("Prova");
    }
    
    
}
