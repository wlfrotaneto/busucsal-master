package br.ucsal.busucsal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.busucsal.dao.RoteiroDAO;

@WebServlet("/roteiroDeletar")
public class RoteiroDeletarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RoteiroDeletarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id")); 
		RoteiroDAO dao = new RoteiroDAO();
		dao.remove(id);
		response.sendRedirect("/roteiros");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
