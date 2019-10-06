import java.io.BufferedReader;
import java.io.IOException;


public class ClientMain {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        System.out.println("Клиент запущен");

        new Thread() {
            public void run() {
                try {
                    client.readMsg();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    client.sendMsg();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
