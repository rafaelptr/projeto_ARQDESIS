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
@WebServlet("/CadastrarAeronave")
public class CadastrarAeronaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarAeronaveController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/aeronave/cadastrar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	 AeronaveDAO aeronaveDAO = new AeronaveDAO();
 	 Aeronave aeronave = new Aeronave();
	 
 	 String codigo = (request.getParameter("codigo") != null ? request.getParameter("codigo") : "");
	 
	 String nome = (request.getParameter("nome") != null ? request.getParameter("nome") : "");
	 
	 int qtd_assentos_A = Integer.parseInt((request.getParameter("qtd_assentos_A") != null ? request.getParameter("qtd_assentos_A") : "0"));
	 
	 int qtd_assentos_B = Integer.parseInt((request.getParameter("qtd_assentos_B") != null ? request.getParameter("qtd_assentos_B") : "0"));
	 
	 int qtd_assentos_C = Integer.parseInt((request.getParameter("qtd_assentos_C") != null ? request.getParameter("qtd_assentos_C") : "0"));
	 
	 int qtd_assentos_horizontais = Integer.parseInt((request.getParameter("qtd_assentos_horizontais") != null ? request.getParameter("qtd_assentos_horizontais") : "0"));
	 
	 int qtd_assentos_verticais = Integer.parseInt((request.getParameter("qtd_assentos_verticais") != null ? request.getParameter("qtd_assentos_verticais") : "0"));
	 
	 aeronave.setCodigo(codigo);
	 aeronave.setNome(nome);
	 aeronave.setQtd_assentos_A(qtd_assentos_A);
	 aeronave.setQtd_assentos_B(qtd_assentos_B);
	 aeronave.setQtd_assentos_C(qtd_assentos_C);
	 aeronave.setQtd_assentos_horizontais(qtd_assentos_horizontais);
	 aeronave.setQtd_assentos_verticais(qtd_assentos_verticais);
	 
	 RequestDispatcher rd = null;
	 request.setAttribute("aeronave", aeronave);
	 if(aeronaveDAO.incluir(aeronave)){
		 request.setAttribute("id", aeronave.getId());
		 rd = request.getRequestDispatcher("./DetalhesAeronave");		 
	 }else{
		 rd = request.getRequestDispatcher("views/aeronave/cadastrar.jsp");
	 }
	 rd.forward(request, response);
	
	}
	
}
