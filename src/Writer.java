import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Writer extends Thread {
    private OutputStream out;
    private boolean flag = true;
    private String username;

    public Writer(String username, OutputStream out) {
        this.out = out;
        this.username = username;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            try {
                out.write((username + ":" + scanner.nextLine()).getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
