package br.ucsal.busucsal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.busucsal.dao.UsuarioDAO;
import br.ucsal.busucsal.model.Usuario;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Usuario usuario = null;
		if(id !=null && !id.trim().isEmpty()){
			Long pk = Long.parseLong(id);
			usuario = new UsuarioDAO().get(pk);
		}
		request.setAttribute("user", usuario);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/usuario.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String senha = request.getParameter("senha");
		String user = request.getParameter("usuario");
		Usuario usuario = new Usuario();
		usuario.setSenha(senha);
		usuario.setUsuario(user);		
		UsuarioDAO dao = new UsuarioDAO();		
		if(id !=null && !id.trim().isEmpty()){
			Long pk = Long.parseLong(id);
			usuario.setId(pk);
			dao.altera(usuario);
		}else {
			dao.inserir(usuario);
		}		
		response.sendRedirect("/usuarios");
	}

}
