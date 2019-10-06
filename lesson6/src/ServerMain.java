import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
        server.clientConnect();
        new Thread() {
            public void run() {
                while (true) {
                    String str = null;
                    try {
                        str = server.in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (str != null) {
                        try {
                            server.sendMsg(str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    server.writeToConsole();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}