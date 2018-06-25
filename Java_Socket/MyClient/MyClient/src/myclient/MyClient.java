
package myclient;

import java.io.*;
import java.net.*;
import java.io.FileWriter;
 //  Connects to a MyServer which is listening on port 1334
public class MyClient{
 
  String server = "127.0.0.1";
  int port = 1334;

  //Instantiates an instance of the MyClient class and initilaizes it.
  public static void main(String[] args){
    MyClient simpleclient = new MyClient();
    simpleclient.init();
  }
/**  Connects to the MyServer on port 1334 and sends a few strings
  *  to the server, and reads, displays the server reply,
  *  then issues a Bye command signaling the server to quit.
  */
  public void init(){
    Socket socket = null;    
    try{
      System.out.println("Connecting to " + server + " on port " + port);
      socket = new Socket(server,port);

      System.out.println("Connected.");
      
      InputStreamReader inputstreamreader = new InputStreamReader(socket.getInputStream());
      BufferedWriter buf=new BufferedWriter(new FileWriter("myfile_client.txt"));
      buf.write("Hey!");
      buf.newLine();
      buf.write("This is some test.");
      buf.newLine();
      buf.write("Let's try!");
      buf.newLine();
      buf.write("Can you hear  me?");
      buf.newLine();
      buf.write("Do you understand me?!");
      buf.newLine();
      buf.write("Let's try!");
      buf.newLine();
      buf.write("Super!");
      buf.newLine();
      buf.write("Let's try!");
      buf.newLine();
      buf.write("Oh well, I've had enough.");
      buf.newLine();
      buf.write("Bye!");
      buf.newLine();
      buf.close();
      inputstreamreader.close();
      socket.close();
      System.exit(0);
    }catch(IOException ioe){
      System.out.println("IOException: " + ioe.getMessage());
    }finally{
      try{
        socket.close();
      }catch(IOException ioe){
        System.out.println("IOException: " + ioe.getMessage());
      }
    }
  }
}