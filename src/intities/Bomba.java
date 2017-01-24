package intities;

public class Bomba {
	private int cod;
	private int x;
	private int y;
	private Jogo j;

	public Bomba (Jogo j, int x, int y){
		this.j = j;
		this.x = x;
		this.y = y;
	}
	
	public Bomba (int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Jogo getJ() {
		return j;
	}

	public void setJ(Jogo j) {
		this.j = j;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

}
