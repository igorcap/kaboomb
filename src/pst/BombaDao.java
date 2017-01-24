package pst;

import intities.Bomba;
import intities.BotaoClicado;
import intities.Jogo;

import java.util.ArrayList;
import java.util.List;

public interface BombaDao {

	public void inserir(Bomba d);

	public void excluir();

	public List<Bomba> listar();

	public Bomba buscar(int codigo);

	public List<Bomba> buscar(String nome);

	public ArrayList<Bomba> listar(Jogo j);
}
