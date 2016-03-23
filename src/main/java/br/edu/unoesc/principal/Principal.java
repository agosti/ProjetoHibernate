package br.edu.unoesc.principal;

import java.time.LocalDate;
import java.util.List;

import br.edu.unoesc.dao.AlunoDAO;
import br.edu.unoesc.dao.FormacaoDAO;
import br.edu.unoesc.exception.DAOException;
import br.edu.unoesc.modelo.Aluno;
import br.edu.unoesc.modelo.Endereco;
import br.edu.unoesc.modelo.Formacao;
import br.edu.unoesc.modelo.TipoEndereco;

public class Principal {

	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		aluno.setCodigo(1l);
		//aluno.setNome("joao horacio");
		// aluno.setData(new Date());
		
		AlunoDAO<Aluno> alunoDao = new AlunoDAO<Aluno>();
		/*try {
			alunoDao.salvar(aluno);
			System.out.println("salvo");
		} catch (DAOException e) {
			System.out.println(e.getMensagem() + "  " + e.getMensagemTratada());
		}*/
		
		/*try {
			alunoDao.excluir(aluno);
		} catch (DAOException e) {
			System.out.println(e.getMensagem() + "  " + e.getMensagemTratada());
		}*/
		
		/*
		Aluno aluno2 = alunoDao.buscar(Aluno.class, 2l);
		if (aluno2 != null) {
			System.out.println(aluno2.getNome());
		} else {
			System.out.println("Aluno nao encontrado");
		}
		
		List<Aluno> turma = alunoDao.buscar(Aluno.class, "joao");
		for (Aluno aluno3 : turma) {
			System.out.println(aluno3);
		}*/
		
		LocalDate inicio = LocalDate.of(2000, 03, 20);
		LocalDate fim = LocalDate.of(2016, 03, 17);
		List<Aluno> alunos = alunoDao.buscarPorData(inicio, fim);
		alunos.forEach(s->System.out.println(s.getData()));
		
		FormacaoDAO<Formacao> formacaoDao = new FormacaoDAO<>();
		Formacao formacao = new Formacao();
		formacao.setDescricao("pos");
		try {
			formacaoDao.salvar(formacao);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		Aluno aluno1 = alunos.get(0);
		Endereco endereco = new Endereco();
		endereco.setLogradouro("rua xxx");
		endereco.setNumero("100");
		endereco.setTipo(TipoEndereco.COMERCIAL);
		endereco.setAluno(aluno1);
		
		aluno1.setFormacao(formacaoDao.buscar(Formacao.class, 1l));
		aluno1.adicionar(endereco);
		try {
			alunoDao.salvar(aluno1);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}

}




