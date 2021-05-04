package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod3")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String iboard = request.getParameter("iboard");
		
		System.out.println("mod iboard : " + iboard);
		
		int intIboard = Integer.parseInt(iboard);
		
//		Board3 a = new BoardVO3();
//		BoardVO3 data = BoardDAD.updBoard(a);
		
		BoardVO3 a = new BoardVO3();
		a.setIboard(intIboard);
		BoardVO3 data = BoardDAO.selBoard(a);
		request.setAttribute("data", data);
		
		String jsp = "/WEB-INF/view/mod3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		System.out.println("iboard : " + iboard);
		System.out.println("title : " + title);
		System.out.println("ctnt : " + ctnt);
		
		int intIboard = Integer.parseInt(iboard);
		
		BoardVO3 vo = new BoardVO3();
		vo.setIboard(intIboard);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		int result = BoardDAO.updBoard(vo);
		
		System.out.println(result);
		
		response.sendRedirect("/detail3?iboard="+ iboard);
		
		
		
		
		
		
	}

}
