import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DayTimeServer {

    public static final int PORT = 13;

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Daytime server stated on port "+PORT);

            for(;;){
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
                Date currentDate = new Date();
                out.println(currentDate);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}

