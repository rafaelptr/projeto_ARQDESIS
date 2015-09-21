package utils;

import javax.servlet.http.HttpServletRequest;

import model.Usuario;

public class DadosSessao {
	
	public static String usuarioLogado(HttpServletRequest request){
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioLogado");
		if(usuario != null){
			return usuario.getUsuario();
		}
		return "";
	}
	
	public static String usuarioPefil(HttpServletRequest request){
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioLogado");
		if(usuario != null){
			return usuario.getPerfil();
		}
		return "";
	}
	
	public static boolean logado(HttpServletRequest request){
		return (boolean) (request.getSession().getAttribute("logado") == null ? false : request.getSession().getAttribute("logado"));
	}
}
