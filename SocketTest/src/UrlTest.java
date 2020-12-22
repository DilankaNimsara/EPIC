import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.javatpoint.com/java-tutoria");

            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            int i;
            while ((i=inputStream.read())!=-1){
                System.out.print((char) i);
            }
//            System.out.println(url.getProtocol());
//            System.out.println(url.getPort());
//            System.out.println(url.getHost());
        }catch (Exception e){

        }
    }
}
