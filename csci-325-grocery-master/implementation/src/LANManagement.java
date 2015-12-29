
import javax.swing.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by merrellblack on 11/24/15.
 */
public class LANManagement {
    static final int timeout = 200;
    static int subnet = 50;
    static int port = 13001;
    static int numServers = 0;
    static LANServers[] serverArray = new LANServers[subnet];

    public LANManagement(){}
    /**** Starts Local Server (Listening services)****/
    public static void startServer(int myPort){
        ServerSocket serverSocket = null;
        int filesize = 1022386;
        int bytesRead;
        int currentTot;
        byte[] bytearray = new byte[filesize];
       try {
            serverSocket = new ServerSocket(myPort);
            System.out.println("Server started -- listening on port: " + myPort);
       }catch (IOException e) {
            System.err.println("Could not listen on port: "+myPort);
       }

        Socket clientSocket = null;
        System.out.println("Server waiting for connection........");

        if(serverSocket != null) {
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Accepted connection : " + clientSocket);
                System.out.println("Waiting for file");
                InputStream is = clientSocket.getInputStream();
                FileOutputStream fos = new FileOutputStream("./sentFile/"+clientSocket.getRemoteSocketAddress()+".txt");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                bytesRead = is.read(bytearray, 0, bytearray.length);
                currentTot = bytesRead;
                do{
                    bytesRead = is.read(bytearray, currentTot, (bytearray.length-currentTot));
                    if(bytesRead >= 0){
                        currentTot += bytesRead;
                    }
                } while(bytesRead > -1);

                bos.write(bytearray, 0, currentTot);
                bos.flush();
                bos.close();
                clientSocket.close();
                JFrame parent = new JFrame();
                JOptionPane.showMessageDialog(parent, "You were sent a list!! ");
            } catch (IOException e) {
                System.err.println("Could not connect to " + clientSocket);
            }


        } else {
            System.err.println("Unable to accept clients: "+serverSocket+" not started");
        }
    }



    /****Search for listening servers ****/
    public static String[] searchServers(String hostnet){
        Socket searchSocket;
        String[] aServers;
        System.out.println("Searching for servers....");
        for (int i = 0; i <= subnet; i++) {
            String hosting = hostnet+"."+i;
            try {
                searchSocket = checkSocket(hosting);
                if (searchSocket != null) {
                    serverArray[i] = new LANServers(searchSocket);
                    numServers++;
                    System.out.println("Host: "+ serverArray[i].getName()+" server slot: "+ i);
                }
            }catch (Exception e){
                   // System.err.println( "Host: "+hosting+" NOT AVAILABLE");
            }
        }
        aServers = availableServers();
        return aServers;
    }

    /**** Disconnects all servers ****/
    public void disconnectServers(){
        for(LANServers server:serverArray){
            server.closeServer();
        }
    }

    /**** Displays available servers: we can use
     * this method to return a list/(object)
     * of listening servers to the UI****/
    public static String[] availableServers(){
        System.out.println(numServers + "of" + serverArray.length + "available");
        String[] serverList = new String[numServers+1];
        int sTracker = 1;
        serverList[0] = "Select Recipient";
        if(numServers>0) {
            for (int i = 0; i < serverArray.length; i++) {
                if (serverArray[i] != null) {
                    serverList[sTracker] = serverArray[i].getName();
                    sTracker++;
                }
            }
            return serverList;
        }
        return null;
    }

    /**** Check to see if server is listening ****/
    public static Socket checkSocket(String hostServer)throws Exception{
        Socket socket = new Socket();
        InetSocketAddress host = new InetSocketAddress(hostServer, port);
        socket.connect(host, timeout);
        return(socket);
    }

    public static LANServers selectServer(String servername){
        for(int i= 0; i < serverArray.length; i++){
            if(serverArray[i] != null) {
                System.out.println("checking: " + servername + " against " + serverArray[i].getName());
                if (serverArray[i].getName().equals(servername)) {
                    return serverArray[i];
                }
            }
        }
        return null;
    }

    /**** Getters & Setters ****/
    public void setPort(int port){

        this.port = port;
    }

    public void setSubnet(int subnet){

        this.subnet = subnet;
    }

}
