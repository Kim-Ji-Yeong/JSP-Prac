package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail3")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String iboard = request.getParameter("iboard");

		System.out.println("detail3 iboard : " + iboard);

		int intIboard = Integer.parseInt(iboard);

		BoardVO3 vo = new BoardVO3();
		vo.setIboard(intIboard);
		
		BoardVO3 data = BoardDAO.detail(vo);

		request.setAttribute("data", data);

		String jsp = "/WEB-INF/view/detail.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
