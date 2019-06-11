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
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/")
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
                HttpSession session = request.getSession(false);
        		session.invalidate();
        		session = request.getSession(true);
                session.setAttribute("login_user", loginUser);

                RequestDispatcher dispatch = null;
                if (loginUser != null) {
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
