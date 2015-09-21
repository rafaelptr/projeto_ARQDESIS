package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import languages.Idioma;
import model.Usuario;
import utils.DadosSessao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		String acao = (String)(req.getParameter("acao")== null ? "" : req.getParameter("acao"));
		boolean logado = DadosSessao.logado(req);
		if(acao.toLowerCase().equals("logoff")){
			req.getSession().setAttribute("logado", false);
			req.getSession().setAttribute("usuarioLogado", null);
			rd = req.getRequestDispatcher("views/login/login.jsp");
		}else if (!logado){
			rd = req.getRequestDispatcher("views/login/login.jsp");
		}else{
			rd = req.getRequestDispatcher("./");
		}

		rd.forward(req, resp);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		String u = (String)(request.getParameter("usuario") != null?request.getParameter("usuario"):"");
		String s = (String)(request.getParameter("senha") != null?request.getParameter("senha"):"");
		usuario.setUsuario(u);
		usuario.setSenha(s);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuario = usuarioDAO.buscar(usuario);
		RequestDispatcher rd = null;
		if(usuario.getId() > 0){
			request.getSession().setAttribute("logado", true);
			request.getSession().setAttribute("usuarioLogado", usuario);
			rd = request.getRequestDispatcher("./");
			
		}else{
			request.getSession().setAttribute("logado", false);
			request.getSession().setAttribute("usuarioLogado", null);
			request.setAttribute("ErrorMsg",Idioma.para(request, "usuario_senha_invalidos"));
			rd = request.getRequestDispatcher("views/login/login.jsp");
		}
		rd.forward(request, response);
	}

}
