import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {

            System.out.println("Enter username: ");
            String username = new Scanner(System.in).nextLine();
            byte [] usernameData = username.getBytes();

            Socket socket = new Socket(
                    InetAddress.getLocalHost(),
                    2003
            );
            socket.getOutputStream().write(usernameData);
            System.out.println("Connected to server....");
            //socket.close();
            new Reader("Client", socket.getInputStream()).start();
            new Writer(username, socket.getOutputStream()).start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
