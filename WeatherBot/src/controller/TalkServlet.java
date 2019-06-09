package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

/**
 * Servlet implementation class TalkServlet
 */
@WebServlet("/TalkServlet")
public class TalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TalkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = null;
        dispatch = request.getRequestDispatcher("Login.jsp");
        dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String talk = request.getParameter("talk");
        String submit = request.getParameter("submit");
        String sessionTalk = request.getParameter("session_talk");

        try {
            UserDao dao = new UserDao();

            if(submit.equals("送信")) {
                HttpSession session = request.getSession();
                request.setAttribute("talk", talk);
                session.setAttribute("session_talk", sessionTalk);

                RequestDispatcher dispatch = null;
                if (talk != null) {
                    dispatch = request.getRequestDispatcher("Talk.jsp");
                    dispatch.forward(request, response);
                } else {
                    dispatch = request.getRequestDispatcher("Login.jsp");
                    dispatch.forward(request, response);
                }
            }
        } catch(SQLException e_sql) {
            e_sql.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {

        }
	}

}
