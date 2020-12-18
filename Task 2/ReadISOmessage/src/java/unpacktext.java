/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dilanka_a
 */
@WebServlet(urlPatterns = {"/unpacktext"})
public class unpacktext extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        String msg = request.getParameter("message");
        String message = msg.replaceAll("\\s", "");

        if (message.isEmpty()) {
            response.sendRedirect("homePage.jsp");
        }

        try {
            out.println("Message : " + message);
            ISOPackager packager = new GenericPackager("C:\\Users\\dilanka_a\\Documents\\NetBeansProjects\\ReadISOmessage\\src\\java\\xml\\iso8583binary.xml");
            ISOMsg imMsg = new ISOMsg();
            imMsg.setPackager(packager);
            imMsg.unpack(ISOUtil.hex2byte(message));
            request.setAttribute("msg", message);
            request.setAttribute("mti", imMsg.getMTI());
            request.setAttribute("imMsg", imMsg);
            request.getRequestDispatcher("output.jsp").forward(request, response);
        } catch (ISOException e) {
        }

    }

}
