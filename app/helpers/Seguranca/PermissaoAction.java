package helpers.Seguranca;

import models.Usuario;
import play.*;
import play.libs.F;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Http.Context;
import play.mvc.SimpleResult;

import java.lang.reflect.Method;

import controllers.routes;

public class PermissaoAction extends Action<Permissao> {
	
/*	public Promise<SimpleResult> call(Context ctx) throws Throwable {
		Usuario usuario;
		
		try {
			usuario = Usuario.find.byId(Long.valueOf(ctx.session().get("usuarioLogadoID")));
		} catch (NumberFormatException e) {
			usuario = null;
		}
		
		if (usuario == null) {
			ctx.flash().put("url", "GET".equals(ctx.request().method()) ? ctx.request().uri() : "/");
			return redirect(controllers.routes.Sessions.login());
		} else if (configuration.value().equalsIgnoreCase("Administrador") && !usuario.isAdministrador) {
			ctx.flash().put("error", "Você não tem permissão para acessar este conteúdo!");
			return redirect(controllers.routes.Application.index());
		}
		
		return delegate.call(ctx);
	}*/

	@Override
	public Promise<SimpleResult> call(Context ctx) throws Throwable {
		Usuario usuario = new Usuario();
		usuario.isAdministrador = true;
		
		 if (configuration.value().equalsIgnoreCase("Administrador") && !usuario.isAdministrador) {
			ctx.flash().put("error", "Você não tem permissão para acessar este conteúdo!");
			return F.Promise.pure(redirect(controllers.routes.Application.index()));
		}

		return delegate.call(ctx);
	}
	
	/*
	 * 
	 * 	@Override
	public Promise<SimpleResult> call(Context ctx) throws Throwable {
		Usuario usuario;
		
		try {
			usuario = Usuario.find.byId(Long.valueOf(ctx.session().get("usuarioLogadoID")));
		} catch (NumberFormatException e) {
			usuario = null;
		}
		
		if (usuario == null) {
			ctx.flash().put("url", "GET".equals(ctx.request().method()) ? ctx.request().uri() : "/");
			return F.Promise.pure(redirect(routes.Sessions.login()));
		} else if (configuration.value().equalsIgnoreCase("Administrador") && !usuario.isAdministrador) {
			ctx.flash().put("error", "Você não tem permissão para acessar este conteúdo!");
			return F.Promise.pure(redirect(controllers.routes.Application.index()));
		}

		return delegate.call(ctx);
	}
	 */
}