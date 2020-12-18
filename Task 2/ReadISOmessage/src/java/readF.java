
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;

/**
 *
 * @author dilanka_a
 */
@MultipartConfig()
public class readF extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String path = "C:\\Users\\dilanka_a\\Documents\\NetBeansProjects\\ReadISOmessage\\src\\java\\textMessage\\isomessage.txt";
        for (Part part : request.getParts()) {
            part.write(path);
        }

        try {
            try (Stream<String> lines = Files.lines(Paths.get(path))) {
                String content = lines.collect(Collectors.joining(System.lineSeparator()));
                String message = content.replaceAll("\\s", "");
                ISOPackager packager = new GenericPackager("C:\\Users\\dilanka_a\\Documents\\NetBeansProjects\\ReadISOmessage\\src\\java\\xml\\iso8583binary.xml");
                ISOMsg imMsg = new ISOMsg();
                imMsg.setPackager(packager);
                imMsg.unpack(ISOUtil.hex2byte(message));
                request.setAttribute("msg", message);
                request.setAttribute("mti", imMsg.getMTI());
                request.setAttribute("imMsg", imMsg);
                request.getRequestDispatcher("output.jsp").forward(request, response);
            }
        } catch (ISOException e) {

        }
        if (request.getParameter("file") == null) {
            response.sendRedirect("homePage.jsp");
        }
    }

}
