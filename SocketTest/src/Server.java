import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket(6666);
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";

            while (!str.equals("stop")) {

                str = dataInputStream.readUTF();
                System.out.println("DClient says : " + str);
                str2 = bufferedReader.readLine();
                dataOutputStream.writeUTF(str2);
                dataOutputStream.flush();

            }

            dataInputStream.close();
            socket.close();
            serverSocket.close();

        } catch (Exception e) {

        }
    }
}
