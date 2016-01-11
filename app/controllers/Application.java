package controllers;

import helpers.Seguranca.Permissao;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Você não tem permissão para acessar este conteúdo!"));
    }

    @Permissao("Administrador")
    public static Result index2() {
    	  return ok(index.render("Your new application is ready."));
    }
    
}
