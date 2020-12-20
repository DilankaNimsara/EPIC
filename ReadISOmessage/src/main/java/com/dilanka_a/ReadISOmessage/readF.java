package com.dilanka_a.ReadISOmessage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet(name = "readF", value = "/readF")
@MultipartConfig
public class readF extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = "C:\\Users\\ASUS\\IdeaProjects\\ReadISOmessage\\src\\main\\java\\message\\isomessage.txt";
        for (Part part : request.getParts()) {
            part.write(path);
        }

        try {
            try (Stream<String> lines = Files.lines(Paths.get(path))) {
                String content = lines.collect(Collectors.joining(System.lineSeparator()));
                String message = content.replaceAll("\\s", "");
                ISOPackager packager = new GenericPackager("C:\\Users\\ASUS\\IdeaProjects\\ReadISOmessage\\src\\main\\java\\XmlFiles\\iso8583binary.xml");
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
            response.sendRedirect("homepage.jsp");
        }
    }

}
