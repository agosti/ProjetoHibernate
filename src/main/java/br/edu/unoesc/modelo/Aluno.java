package br.edu.unoesc.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "nome")
@ToString(of = { "codigo", "nome" })

@Entity
// @Table(name="CAD_ALUNO")
@NamedQueries({ @NamedQuery(name = Aluno.FILTRA_POR_NOME, query = "select a from Aluno a where upper(a.nome) like ?1 "),
		@NamedQuery(name = Aluno.FILTRA_POR_DATA, query = "select a from Aluno a where a.data between ?1 and ?2 ") })
public class Aluno implements MinhaEntidade {

	public static final String FILTRA_POR_NOME = "FILTRA_POR_NOME";
	public static final String FILTRA_POR_DATA = "FILTRA_POR_DATA";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	// @Column(name = "NM_ALUNO", nullable = false, length = 60, unique = true)
	@Column(nullable = false, length = 60)
	private String nome;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	// Associacao com Formacao
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private Formacao formacao;

	@OneToMany(mappedBy = "aluno", targetEntity = Endereco.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();

	public void adicionar(Endereco endereco) {
		this.enderecos.add(endereco);
	}

}
