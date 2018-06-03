package servlet;

import socket.Server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date 2018/5/27 14:19.
 * @Comment
 */
@WebServlet("/index")
public class SocketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LLL");
        Server server = null;
        try {
            server = new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Thread.sleep(60000*10);
         //server.service();
       // resp.sendRedirect("index.jsp");
    }
}
