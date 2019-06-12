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
import model.User;
import service.TalkService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
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
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("user_id");
        String password = request.getParameter("password");
        String submit = request.getParameter("submit");

        try {
            UserDao dao = new UserDao();
            User loginUser = dao.getLoginUser(userId, password);

            if(submit.equals("ログイン")) {
            	TalkService ts = new TalkService();
                HttpSession session = request.getSession();
                if(session != null){
            		session.invalidate();
                }
        		session = request.getSession();
                session.setAttribute("login_user", loginUser);

                RequestDispatcher dispatch = null;
                if (loginUser != null) {
                	String sessionTalk = (String)session.getAttribute("session_talk");
                	Talk t_submit = new Talk("kumozou", "こんにちは " + loginUser.getName() + "さん！<br>今日の東京の天気は曇り。夕方から小雨が降りそうだよ。");

                	if(sessionTalk == null) {
                		sessionTalk = "";
                	}
                	sessionTalk += ts.TalkToHtml(t_submit);
                    session.setAttribute("session_talk", sessionTalk);

                    dispatch = request.getRequestDispatcher("Talk.jsp");
                    dispatch.forward(request, response);
                } else {
                    dispatch = request.getRequestDispatcher("LoginNG.jsp");
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
