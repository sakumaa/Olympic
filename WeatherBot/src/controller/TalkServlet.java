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
import model.Talk;
import service.TalkService;

/**
 * Servlet implementation class TalkServlet
 */
@WebServlet("/TalkServlet")
public class TalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		TalkService ts = new TalkService();
		request.setCharacterEncoding("UTF-8");
		String talk = request.getParameter("talk");
        String submit = request.getParameter("submit");
        HttpSession session = request.getSession();

        try {
            UserDao dao = new UserDao();

            if(submit.equals("送信")) {
                String sessionTalk = (String)session.getAttribute("session_talk");

                RequestDispatcher dispatch = null;
                if (talk != null) {
                	Talk t_submit = new Talk("user", talk);

                	if(sessionTalk == null) {
                		sessionTalk = "";
                	}
                	sessionTalk += ts.TalkToHtml(t_submit);
                    session.setAttribute("session_talk", sessionTalk);

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
