import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Client {
    Socket socket;
    BufferedReader in, console;
    PrintWriter out;
    String clientMsg, serverMsg;

    public Client() throws IOException {
        socket = new Socket("localhost",1127);
        in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),true);
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    void sendMsg() throws IOException {
        while (true) {
            clientMsg = console.readLine();
            if (clientMsg != null) {
                out.println(clientMsg);
                if (clientMsg.equalsIgnoreCase("/end")) close();
            }
        }
    }

    void readMsg() throws IOException {
        while (true) {
            serverMsg = in.readLine();
            if (serverMsg  != null){
                System.out.println(serverMsg);
            }
        }
    }

    void close() throws IOException {
        out.close();
        in.close();
        console.close();
        socket.close();
    }
}