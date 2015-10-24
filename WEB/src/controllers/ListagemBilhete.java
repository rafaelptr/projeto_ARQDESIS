package controllers;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bilhete;
import to.ListagemBilheteTO;

/**
 * Servlet implementation class BilheteController
 */
@WebServlet("/ListagemBilhete")
public class ListagemBilhete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListagemBilhete() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Bilhete bilhete = new Bilhete();
    	ListagemBilheteTO listagem = bilhete.listagem();
    	request.setAttribute("listagem", listagem);
    	request.getRequestDispatcher("views/bilhete/listagem.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
	}

    @Override
	public void init(ServletConfig config){
		//todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}
	
}
