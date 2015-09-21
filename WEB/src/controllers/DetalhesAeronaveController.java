package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AeronaveDAO;
import model.Aeronave;

/**
 * Servlet implementation class AeronaveController
 */
@WebServlet("/DetalhesAeronave")
public class DetalhesAeronaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalhesAeronaveController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 AeronaveDAO aeronaveDAO = new AeronaveDAO();
	 	 Aeronave aeronave = new Aeronave();
		 
	 	 int id = Integer.parseInt((request.getParameter("id") != null ? request.getParameter("id") : "0"));
			
		 aeronave.setId(id);
		 
		 RequestDispatcher rd = null;
		 aeronave = aeronaveDAO.buscar(aeronave);
		 if(aeronave.getId() > 0){
			 request.setAttribute("aeronave", aeronave);
			 rd = request.getRequestDispatcher("views/aeronave/detalhes.jsp");		 
		 }else{
			 rd = request.getRequestDispatcher("./ListagemAeronave");
		 }
		 rd.forward(request, response);
	}
	
}
