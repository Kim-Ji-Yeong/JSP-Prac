package practice2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod")
public class modSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int Iboard = Integer.parseInt(iboard);
		BoardVO a = new BoardVO();
		a.setIboard(Iboard);
		BoardVO data = BoardDAO.selBoard(a);
		request.setAttribute("data", data);

		String jsp = "/WEB-INF/view/mod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
