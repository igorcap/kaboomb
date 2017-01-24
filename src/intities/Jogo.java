package intities;

import java.util.Date;

public class Jogo {
	private int cod;
	private Date data;
	private boolean flag;
	private int linhas;
	private int colunas;
	
	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public Jogo(){}
	
	public Jogo (int id, int x, int y){
		cod = id;
		this.linhas = x;
		this.colunas = y;
	}
	
	public Jogo (Date d, int x, int y){
		this.data = d;
		this.flag = true;
		this.linhas = x;
		this.colunas = y;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

}
