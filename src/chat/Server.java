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
public class Server{
    //Modifica fatta
    //Ciaoo
    private ServerSocket serverSocket;
    /*private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;*/
    
    
    
    /*public void run(){
        /*try{
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }
        catch(IOException e){
            System.out.println("Eccezione catturata");
        }
        
        String inputLine="";
        try{
            while((inputLine = in.readLine()) != null){
                if(inputLine.equals("/exit")){
                    //out.println("Buona giornata!");
                    System.out.println("Connessione terminata");
                    //this.stop();                    
                    this.stopServer();
                    break;
                }
                System.out.println("Messaggio ricevuto: " + inputLine);                
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }*/
    
    public void startServer(int port){
        try{
            serverSocket=new ServerSocket(port);
            while(true)
                new ClientHandler(serverSocket.accept()).start();
        }
        catch(Exception e){
            
        }
        
        /*String messaggio;
        try{
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }
        catch(IOException e){
            System.out.println("Eccezione catturata");
        }
        System.out.println("Inserisci il messaggio da inviare(inserisci '/exit' per terminare la conversazione): ");        
        start();
        while(this.isAlive()){
            //System.out.print("Risposta: ");
            messaggio=Input.readLine();
            out.println(messaggio);
            if(messaggio.equalsIgnoreCase("/exit")){
                //this.stop();                
                this.stopServer();
                System.out.println("Connessione terminata");
                //return;
            }
        }*/
        

    }


    
    
    public void stopServer(){
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        Server server=new Server();
        System.out.println("Bevenuto nella chat");
        System.out.println("Server startato");
        server.startServer(9042);
    }
    
}
