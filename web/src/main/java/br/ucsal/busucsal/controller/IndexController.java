package br.ucsal.busucsal.controller;

import java.io.IOException;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.busucsal.dao.RoteiroDAO;
import br.ucsal.busucsal.model.Roteiro;

@WebServlet(urlPatterns = {"/Index"})
public class IndexController  extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    public IndexController() {
        super();   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoteiroDAO dao =  new RoteiroDAO();
		List<Roteiro> roteiros  = dao.getLista();
		request.setAttribute("roteiros", roteiros);
		RequestDispatcher requestDispatcher =   request.getRequestDispatcher("/WEB-INF/index.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

