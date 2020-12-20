package com.dilanka_a.ReadISOmessage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "unpacktext", value = "/unpacktext")
public class unpacktext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String msg = request.getParameter("message");
        String message = msg.replaceAll("\\s", "");

        if (message.isEmpty()) {
            response.sendRedirect("homepage.jsp");
        }

        try {
            out.println("Message : " + message);
            ISOPackager packager = new GenericPackager("C:\\Users\\ASUS\\IdeaProjects\\ReadISOmessage\\src\\main\\java\\XmlFiles\\iso8583binary.xml");
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
