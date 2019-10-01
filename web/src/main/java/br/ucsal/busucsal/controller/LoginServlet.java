package br.ucsal.busucsal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.busucsal.dao.UsuarioDAO;
import br.ucsal.busucsal.model.Usuario;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuarios = dao.getLista();
		Boolean autenticacao = false;
		String username = request.getParameter("usuario");
		String password = request.getParameter("senha");
		for(Usuario usuario : usuarios) {
			if(usuario.getUsuario().equals(username) || usuario.getSenha().equals(password)) {
				System.out.println("Senha correta!");
				autenticacao = true;
				HttpSession session = request.getSession();
				session.setAttribute("usuario", usuario.getUsuario());
				session.setMaxInactiveInterval(30*60);
				Cookie userName = new Cookie("usuario", usuario.getUsuario());
				response.addCookie(userName);
			}
		}
		if(autenticacao == false) {
			System.out.println("Informações inválidas!");
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Usuário ou senha incorretos.</font>");
		} else {
			request.getRequestDispatcher("index.html").forward(request, response);
		}
	}

}
