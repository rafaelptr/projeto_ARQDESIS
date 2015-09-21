package controllers;

import java.io.IOException;
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
@WebServlet("/ListagemAeronave")
public class ListagemAeronaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListagemAeronaveController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AeronaveDAO aeronaveDAO = new AeronaveDAO();
		request.setAttribute("lista", aeronaveDAO.listagem());
		request.getRequestDispatcher("views/aeronave/listagem.jsp").forward(request, response);
	}
}
