package br.ucsal.busucsal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.busucsal.dao.RoteiroDAO;
import br.ucsal.busucsal.model.Roteiro;

@WebServlet("/roteiros")
public class RoteirosController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public RoteirosController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoteiroDAO dao =  new RoteiroDAO();
		List<Roteiro> horarios  = dao.getLista();
		request.setAttribute("roteiros", horarios);	
		RequestDispatcher requestDispatcher =   request.getRequestDispatcher("/WEB-INF/roteiros.jsp");
		requestDispatcher.forward(request, response);		
	}

}
