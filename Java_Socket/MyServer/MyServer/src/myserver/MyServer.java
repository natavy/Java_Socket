
package myserver;

import java.io.*;
import java.net.*;
import java.util.*;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**  When started allows one client to connect. It listens on port 1334.
 It returns whatever a connected client sends.**/

public class MyServer{
 //Instantiates an instance of the MyServer class and initilaizes it.
  public static void main(String[] args){
    MyServer myserver = new MyServer();
    myserver.init();
  }
 //Sets up a ServerSocket and listens on port 1334.
  public void init(){
    ServerSocket serversocket = null;
    Socket socket = null;
    try{
     //establish a server socket monitoring port 1334 
      //port 1334 is not used by any services
      serversocket = new ServerSocket(1334);
      System.out.println("Listening at 127.0.0.1 on port 1334");
      //wait indefinitely until a client connects to the socket
      socket = serversocket.accept();
      InputStreamReader inputstreamreader = new InputStreamReader(socket.getInputStream());
      BufferedWriter buf1=new BufferedWriter(new FileWriter("myfile_server.txt"));
      buf1.write("Hi from me!");
      buf1.newLine();
      buf1.write("Yes I hear you!");
      buf1.newLine();
      buf1.write("What do you want to do?");
      buf1.newLine();
      buf1.write("Some test?");
      buf1.newLine();
      buf1.write("Are you sure?");
      buf1.newLine();
      buf1.write("Ok. Let's try!");
      buf1.newLine();
      buf1.write("I saw ok!");
      buf1.newLine();
      buf1.write("It's Ok?");
      buf1.newLine();
      buf1.write("Bravo!");
      buf1.newLine();
      buf1.close();
      inputstreamreader.close();
      socket.close();
      }catch(UnknownHostException unhe){
      System.out.println("UnknownHostException: " + unhe.getMessage());
    }catch(InterruptedIOException intioe){
      System.out.println("Timeout while attempting to establish socket connection.");
    }catch(IOException ioe){
      System.out.println("IOException: " + ioe.getMessage());
    }finally{
      try{
        socket.close();
        serversocket.close();
      }catch(IOException ioe){
        System.out.println("IOException: " + ioe.getMessage());
      }
    }
  }
} 
