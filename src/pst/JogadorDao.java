package pst;

import intities.Jogador;

import java.util.List;

public interface JogadorDao {

	public void inserir(Jogador d);
	
	public void alterar (Jogador d);

	public List<Jogador> buscar(String nome);
}
