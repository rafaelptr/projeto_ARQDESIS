package controllers;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aeroporto;
import model.Bilhete;
import model.Pagamento;
import model.Voo;
import to.BilheteTO;
import to.ListagemAeroportoTO;
import to.ListagemVooTO;
import to.PagamentoTO;

/**
 * Servlet implementation class BilheteController
 */
@WebServlet("/ComprarBilhete")
public class ComprarBilhete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprarBilhete() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Voo voo = new Voo();
    	ListagemVooTO listagem = voo.listagem();
    	request.setAttribute("voos", listagem);
    	
    	Aeroporto aero = new Aeroporto();
    	ListagemAeroportoTO aeroListagem = aero.listagem();
    	request.setAttribute("aeroportos", aeroListagem);
    	
    	request.getRequestDispatcher("views/bilhete/comprar.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Voo voo = new Voo();
    	ListagemVooTO listagem = voo.listagem();
    	request.setAttribute("voos", listagem);
    	
    	Aeroporto aero = new Aeroporto();
    	ListagemAeroportoTO aeroListagem = aero.listagem();
    	request.setAttribute("aeroportos", aeroListagem);
    	
    	 Bilhete bilhete = new Bilhete();
    	 BilheteTO bilheteTo = new BilheteTO();			 
	 	 String view = "views/bilhete/comprar.jsp";
	 	
	 	 String vooid = (request.getParameter("VooId") != null ? request.getParameter("VooId") : "0");
	 	 String cartao_numero = (request.getParameter("cartao_numero") != null ? request.getParameter("cartao_numero") : "");
	 	 String cartao_cod_seguranca = (request.getParameter("cartao_cod_seguranca") != null ? request.getParameter("cartao_cod_seguranca") : "");
	 	 
	 	 PagamentoTO pag  = new PagamentoTO();
	 	 Pagamento pagamento = new Pagamento();
	 	 
		 BilheteTO resultado = bilhete.incluir(bilheteTo);
		 if(resultado.id > 0){
			 request.setAttribute("succMsg", "compra_successo");
			 view = "./ImprimirBilhete?id="+resultado.id;
		 }else{
			 request.setAttribute("erroMsg", "erro_ao_comprar_bilhete");
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
