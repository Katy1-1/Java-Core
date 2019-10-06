import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
    Socket socket;
    BufferedReader in, console;
    PrintWriter out;
    ServerSocket serverSocket;
    String input;

    void start() {
        try {
            serverSocket = new ServerSocket(1127);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Сервер запущен. ");
    }

    void clientConnect() throws IOException {
        try {
            socket = serverSocket.accept();
            System.out.println("Клиент подключился. ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),true);
    }

    void sendMsg(String msg) throws IOException {
        if (msg.equalsIgnoreCase("/end")) close();
        out.println("Echo " + msg);
        System.out.println(msg);
    }

    void close() throws IOException {
        socket.close();
        serverSocket.close();
        out.close();
        in.close();
    }

    void writeToConsole() throws IOException {
        while (true) {
            console = new BufferedReader(new InputStreamReader(System.in));
            String txt = console.readLine();
            sendMsg(txt);
        }
    }
}
