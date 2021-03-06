package br.com.gabrielbobrov.beyondwork.domain.prestador;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "categoria_prestador")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true )
public class CategoriaPrestador  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	
	@NotNull
	@Size(max = 20)
	private String nome;
	
	@NotNull
	@Size(max = 250)
	private String imagem;
	
	@ManyToMany(mappedBy = "servicosOferecidos")
	private Set<Prestador> prestadores = new HashSet<>(0);
	

}
