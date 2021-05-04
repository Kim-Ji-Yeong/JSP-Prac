package com.koreait.board3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board3.BoardVO3;

@WebServlet("/list3")
public class BoardLIstServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVO3> list =  BoardDAO.selBoardList();    //무조건 dao한테서 얻어옴
		request.setAttribute("list",list);
		
		String jsp = "/WEB-INF/view/list3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}
