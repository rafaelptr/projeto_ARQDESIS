package controllers;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bilhete;
import to.BilheteTO;

/**
 * Servlet implementation class PassageiroController
 */
@WebServlet("/CancelarBilhete")
public class CancelarBilhete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarBilhete() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String view = "views/bilhete/cancelar.jsp";
		BilheteTO bilhete = new BilheteTO();
		request.setAttribute("bilhete", bilhete);
    	request.getRequestDispatcher(view).forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Bilhete bilhete = new Bilhete();
    	BilheteTO bilheteTo = new BilheteTO();			 
    	String view = "views/bilhete/cancelar.jsp";
	 	String codigo = (request.getParameter("codigo") != null ? request.getParameter("codigo") : "");
	 	 if(codigo != ""){ 
	 		BilheteTO resultado = bilhete.checkin(codigo);
			 if(resultado != null){
				 if(bilhete.remover(resultado.id)){
					 request.setAttribute("succMsg", "checkin_successo");
					 request.setAttribute("bilhete", bilheteTo);
				 }else{
					 request.setAttribute("erroMsg", "erro_ao_cancelar");
					 request.setAttribute("bilhete", bilheteTo);
				 }
			 }else{
				 request.setAttribute("erroMsg", "nao_existe");
				 request.setAttribute("bilhete", bilheteTo);
			 }
	 	 }else{
			 request.setAttribute("erroMsg", "bilhete_invalido");
			 request.setAttribute("bilhete", bilheteTo);
	 	 }
		request.getRequestDispatcher(view).forward(request, response);
		
	}
	
    @Override
	public void init(ServletConfig config){
		//todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}
	
}
