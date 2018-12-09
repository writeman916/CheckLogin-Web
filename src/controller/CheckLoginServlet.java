package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.bo.CheckLoginBO;

/**
 * Servlet implementation class CheckLoginServlet
 */
@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String destination = null;

		String userName = request.getParameter("userName").trim();
		String password = request.getParameter("password").trim();
		CheckLoginBO checkLoginBO = new CheckLoginBO();
		User user = null;
		
		if (checkLoginBO.isValidUser(userName, password)) {
			user = checkLoginBO.getUser(userName);
			System.out.println(user);
			request.setAttribute("userInfo", user);
			destination = "/welcome.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					destination);
			rd.forward(request, response);

		} else {
			destination = "/login.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					destination);
			rd.forward(request, response);

		}
	}

}
