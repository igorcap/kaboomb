package pst;

import intities.BotaoClicado;
import intities.Jogo;

import java.util.ArrayList;
import java.util.List;

public interface JogoDao {

	public void inserir(Jogo d);

	public void excluir(int codigo);

	public Jogo buscar(int codigo);

	public ArrayList<Jogo> buscar();
}
