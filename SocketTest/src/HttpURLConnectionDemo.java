import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

public class HttpURLConnectionDemo {
    public static void main(String[] args) {

        try {
            URL url = new URL("http://www.javatpoint.com/java-tutorial");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            for (int i = 1; i <= 8; i++) {
                System.out.println(httpURLConnection.getHeaderFieldKey(i) + " = " + httpURLConnection.getHeaderField(i));
            }
            httpURLConnection.disconnect();

            InetAddress inetAddress = InetAddress.getByName("www.javatpoint.com");
            System.out.println(inetAddress.getHostName());
            System.out.println(inetAddress.getHostAddress());


        } catch (Exception e) {

        }


    }
}
