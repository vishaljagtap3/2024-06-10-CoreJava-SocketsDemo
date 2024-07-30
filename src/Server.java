import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    public static void main(String[] args) {
        try {
            //ServerSocket serverSocket = new ServerSocket(2001, 30, InetAddress.getLocalHost());
            //ServerSocket serverSocket = new ServerSocket(2001, 30);
            ServerSocket serverSocket = new ServerSocket(2001);
            System.out.println("Server listening on port: 2001");
            Socket socket = serverSocket.accept();
            System.out.println("Got the connection req and connected...");

            new Reader("Server", socket.getInputStream()).start();
            new Writer("", socket.getOutputStream()).start();

            //socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*try {
            InetAddress inetAddress = InetAddress.getByName("bitcode.in");
            System.out.println(inetAddress.getHostAddress());
            inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress.getHostAddress());

            InetAddress [] addresses = InetAddress.getAllByName("google.com");
            for(InetAddress adr : addresses) {
                System.out.println(adr.getHostAddress());
            }


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }*/


    }
}
