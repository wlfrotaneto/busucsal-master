package br.ucsal.busucsal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.busucsal.dao.RoteiroDAO;
import br.ucsal.busucsal.model.Roteiro;

@WebServlet("/roteiro")
public class RoteiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RoteiroServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		RoteiroDAO dao = new RoteiroDAO();		
		Roteiro roteiro = null;
		if(id != null && !id.trim().isEmpty()){
			Long pk = Long.parseLong(id);
			roteiro = dao.obter(pk);
		}
		request.setAttribute("roteiro", roteiro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/roteiro.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		RoteiroDAO dao = new RoteiroDAO();	
		Roteiro roteiro = new Roteiro();
		roteiro.setTitulo(titulo);
		roteiro.setDescricao(descricao);		
		if(id != null && !id.trim().isEmpty()){
			Long pk = Long.parseLong(id);
			roteiro.setId(pk);
			dao.altera(roteiro);
		}else {
			dao.inserir(roteiro);
		}
		response.sendRedirect("/roteiros");
	}

}
