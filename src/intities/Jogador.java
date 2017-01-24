package intities;

public class Jogador {
	private int cod;
	private String nome;
	private int pontuacao;

	public Jogador (String n, int p){
		this.nome = n;
		this.pontuacao = p;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
