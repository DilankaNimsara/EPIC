import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6666);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream((socket.getInputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (!str.equals("stop")) {
                str = bufferedReader.readLine();
                dataOutputStream.writeUTF(str);
                dataOutputStream.flush();
                str2 = dataInputStream.readUTF();
                System.out.printf("Server says : " + str2);

            }

            dataOutputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
