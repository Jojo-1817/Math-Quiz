package com.algonquin.capstone.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.algonquin.capstone.dao.ApplicationDao;

public class ScoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Correct answers for the 3 sample questions
        String[] correct = {"8", "6", "21"};
        String[] params  = {"q1", "q2", "q3"};
        int score = 0;
        for (int i = 0; i < correct.length; i++) {
            String answer = request.getParameter(params[i]);
            if (correct[i].equals(answer)) score++;
        }

        // Calculate reward
        double pct = (double) score / correct.length * 100;
        String reward = pct == 100 ? "Gold Badge"
                      : pct >= 60  ? "Silver Badge"
                      :              "Bronze Badge";

        // Build response page
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body style='font-family:Arial'>");
        out.println("<h2 style='color:green'>Quiz Submitted!</h2>");
        out.println("<p>Your score: <b>" + score + " / " + correct.length + "</b></p>");
        out.println("<p>Reward: <b>" + reward + "</b></p>");
        out.println("<a href='index.html'>Back to Login</a>");
        out.println("</body></html>");
    }
}