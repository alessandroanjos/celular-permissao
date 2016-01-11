package helpers.Seguranca;


import java.util.Iterator;
import java.util.List;

import play.mvc.Controller;
import models.Usuario;


public class InformacoesUsuarioHelper extends Controller {

	
	public static Usuario getUsuarioLogado(){
		try {
		Long idUsuario = Long.parseLong(session("usuarioLogadoID"));
		
		return Usuario.find.byId(idUsuario);
		
		} catch (Exception e) {
			e.printStackTrace();
			internalServerError("Comportamento Inesperado..");
		}
		return null;
		
	}

	public static Boolean isLogado() {
		return session().get("usuarioLogadoID") == null ? false : true;
	}
}
