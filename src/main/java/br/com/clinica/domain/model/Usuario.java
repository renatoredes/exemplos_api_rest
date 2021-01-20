package br.com.clinica.domain.model;


import javax.persistence.*;
import lombok.*;

/**
 * 
 * @author Renato Ferreira
 * https://www.linkedin.com/in/renatoredes/
 * https://github.com/renatoredes
 */

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Usuario {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "nome_login_usuario",length=50)
	private String nomeLoginUsuario;
	
	@Column(name = "senha_login_usuario",length=50)
	private String senhaLoginUsuario;
	
	@Column(length=50)
	private boolean UsuarioBloqueado;
	
}
