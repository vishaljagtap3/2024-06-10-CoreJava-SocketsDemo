import java.io.IOException;
import java.io.InputStream;

public class Reader extends Thread{

    private String hostName;
    private InputStream in;
    private boolean flag = true;

    public Reader(String hostName, InputStream in) {
        this.hostName = hostName;
        this.in = in;
    }

    @Override
    public void run() {
        System.out.println("**** " + hostName + " ****");
        byte [] data = new byte[1024 * 1];
        int count;
        while(flag) {
            try {
                if(in.available() > 0) {
                    count = in.read(data);
                    String [] msgParts = new String(data, 0, count).split(":");
                    System.out.println(msgParts[0] + ":"  + msgParts[2]);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
