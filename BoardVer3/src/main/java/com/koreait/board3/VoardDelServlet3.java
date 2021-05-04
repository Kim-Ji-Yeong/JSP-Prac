package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/del3")
public class VoardDelServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String iBoard = request.getParameter("iboard");
	int intIboard =Integer.parseInt(iBoard);
	
	BoardVO3 param = new BoardVO3();
	param.setIboard(intIboard);
	BoardDAO.delBoard(param); // 그릇을 쓰면 선언부를 안고쳐도 된다.
	
//	BoardDAO.delBoard(intIboard);    ↑
	// 메소드는 수정안해주는게 좋다
	
	
	response.sendRedirect("/list3");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
