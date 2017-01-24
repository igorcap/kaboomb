package pst;

import intities.Bomba;
import intities.BotaoClicado;
import intities.Jogo;

import java.util.Date;






public class Teste {

	public static void main(String[] args) {

		/*JogadorDao bomb = new JogadorMySQLDao();

		Jogador d = new Jogador("a",2);
		bomb.inserir(d);

		d = new Jogador("b",3);
		bomb.inserir(d);

		d = new Jogador("c",3);
		bomb.inserir(d);/*/
		
		Jogo j = new Jogo();
		j.setLinhas(10);
		j.setColunas(20);
		j.setData(new Date());
		
		JogoDao jg = new JogoMySQLDao();
		
		jg.inserir(j);
		
		
		
		BombaDao d = new BombaMySQLDao();
		
		Bomba bb = new Bomba(j,4,1);
		
		d.inserir(bb);
		
		BotaoClicadoDao b = new BotaoClicadoMySQLDao();
		
		BotaoClicado bomb = new BotaoClicado(j, 10, 5);
		
		//b.inserir(bomb);
		
		

	}
}
