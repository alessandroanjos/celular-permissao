package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Usuario extends Model {

	@Id
	public Long id;
	
	public String nome;
	
	public boolean isAdministrador;
	
	public Usuario(){
		
	}
	
	public static Finder<Long, Usuario> find = new Finder<Long, Usuario>(Long.class, Usuario.class);
	
}
