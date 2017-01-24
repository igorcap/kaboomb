package pst;

import intities.BotaoClicado;
import intities.Jogo;

import java.util.ArrayList;
import java.util.List;

public interface BotaoClicadoDao {

	public void inserir(BotaoClicado d);

	public void excluir();

	public List<BotaoClicado> listar();

	public BotaoClicado buscar(int codigo);

	public List<BotaoClicado> buscar(String nome);

	public ArrayList<BotaoClicado> listar(Jogo j);
}
