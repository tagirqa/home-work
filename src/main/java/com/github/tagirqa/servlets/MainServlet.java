package com.github.tagirqa.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/hello")
public class MainServlet extends HttpServlet {
    private final AtomicInteger counter = new AtomicInteger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        HttpSession session = req.getSession();

        counter.incrementAndGet();
        session.setAttribute("visitCounter", counter.get());
        String username = req.getParameter("username");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        if (username == null) {
            printWriter.write("Привет незнакомец" + "<br>");
        } else {
            printWriter.write("Привет " + username + "<br>");
        }
        printWriter.write("Страницу посетили " + counter.get() + " раз.");
        printWriter.close();
    }
}
