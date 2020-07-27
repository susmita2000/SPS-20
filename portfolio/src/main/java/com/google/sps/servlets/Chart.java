package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/color-datax")
public class Chart extends HttpServlet {

  private Map<String, Integer> colorVotes = new HashMap<>();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/json");
    Gson gson = new Gson();
    String json = gson.toJson(colorVotes);
    response.getWriter().println(json);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String color = request.getParameter("color");
    int currentVotes = colorVotes.containsKey(color) ? colorVotes.get(color) : 0;
    colorVotes.put(color, currentVotes + 1);

    response.sendRedirect("/maps.html");
  }
}
