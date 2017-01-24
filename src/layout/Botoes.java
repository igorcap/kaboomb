
package layout;

import intities.Bomba;
import intities.BotaoClicado;
import intities.Jogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pst.BombaDao;
import pst.BombaMySQLDao;
import pst.BotaoClicadoDao;
import pst.BotaoClicadoMySQLDao;
import pst.JogoDao;
import pst.JogoMySQLDao;
import background.DificuldadeBack;

public class Botoes extends JPanel implements ActionListener {


	private int[][] minas;
	private int x=20,y=20;
	private int linha, coluna;
	private boolean acabou=false;;
	private int dificuldade;
	private int ganhou;
	private int contador;
	private JButton[][] Botoes = new JButton[x][y];
	private JPanel grid = new JPanel();
	private Jogo j;

	private boolean acessada[][] = new boolean[x][y];



	boolean clicked = false;
	void setDificuldade (int i){
		this.dificuldade = i;
	}

	Random random = new Random();

	public Botoes() {
		
		//j = new Jogo(new Date(),x,y);
		//JogoDao jdao = new JogoMySQLDao();
		//j.setCod(jdao.buscar().get(0).getCod()+1);
		//jdao.inserir(j);

		x = new DificuldadeBack().getLinha();
		y = new DificuldadeBack().getColuna();
		
		setBackground(new java.awt.Color(153, 153, 153));
		setMinimumSize(new java.awt.Dimension(380, 284));
		setPreferredSize(new java.awt.Dimension(380, 300));
		setLayout(new java.awt.GridLayout(x, y));
		ganhou = 0;
		contador = 0;

		minas = new int[x][y];
		dificuldade = DificuldadeBack.getDif();
		sorteiaMinas(dificuldade);
		preencheDicas();


		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				Botoes[i][j] = new JButton("");
				Botoes[i][j].addActionListener(this);
				Botoes[i][j].setFocusable(false);
				this.add(Botoes[i][j]);
				Botoes[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						MouseClicked(evt);
					}
				});
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				if(Botoes[i][j]==e.getSource()){
					//BotaoClicado bc = new BotaoClicado(this.j, i,j);
					//BotaoClicadoDao bdao = new BotaoClicadoMySQLDao();
					//bdao.inserir(bc);
					checarBotao(i, j, Botoes[i][j]);					
				}
			}
		}
	}

	private void MouseClicked(MouseEvent evt) {
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				if(evt.getSource() == Botoes[i][j]){

					if(evt.getButton()== MouseEvent.BUTTON3 && clicked==false && Botoes[i][j].getIcon()==null){
						Botoes[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botaobandeira.jpg")));
						clicked=true;

					}else{
						if (evt.getButton()== MouseEvent.BUTTON3 && clicked==true){
							Botoes[i][j].setIcon(null);
							clicked = false;

						}
					}
				}
			}
		}
	}


	public void Confere(int a, int b){
		if (minas[a][b] != -1){
			minas[a][b]++;
		}
	}
	public void preencheDicas(){
		for(int line = 0 ; line < x ; line++){
			for(int column = 0 ; column < y ; column++){
				if (minas[line][column] == -1){
					if ((line != 0) && (line != x-1) && (column != y-1) && (column != 0)){
						if (minas[line][column] == -1){
							Confere(line-1, column-1);
							Confere(line-1, column);
							Confere(line-1, column+1);
							Confere(line, column-1);
							Confere(line, column+1);
							Confere(line+1, column-1);
							Confere(line+1, column);
							Confere(line+1, column+1);
						}   
					}
					if ((line == 0) && (column==0)){
						Confere(line, column+1);
						Confere(line+1, column);
						Confere(line+1, column+1);
					}

					if ((line == x-1) && (column==y-1)){
						Confere(line-1, column-1);
						Confere(line-1, column);
						Confere(line, column-1);                                               
					}

					if ((line == 0) && (column == y-1)){
						Confere(line, column-1);
						Confere(line+1, column-1);
						Confere(line+1, column);
					}

					if ((line == x-1) && (column == 0)){
						Confere(line-1, column);
						Confere(line-1, column+1);
						Confere(line, column+1);
					}

					if ((line == 0) && ((column != 0) && (column != y-1))){
						Confere(line, column-1);
						Confere(line, column+1);
						Confere(line+1, column-1);
						Confere(line+1, column);
						Confere(line+1, column+1);
					}

					if (column == 0&& ((line != 0) && (line != x-1))){
						Confere(line-1, column);
						Confere(line-1, column+1);
						Confere(line, column+1);
						Confere(line+1, column);
						Confere(line+1, column+1);
					} 
					if (line == x-1 && ((column != 0) && (column != y-1))){
						Confere(line-1, column-1);
						Confere(line-1, column);
						Confere(line-1, column+1);
						Confere(line, column-1);
						Confere(line, column+1);                            
					}

					if (column == y-1 && ((line != 0) && (line != x-1))){
						Confere(line-1, column-1);
						Confere(line-1, column);
						Confere(line, column-1);
						Confere(line+1, column-1);
						Confere(line+1, column);
					} 
				}
			}
		}
	}  
	public void sorteiaMinas(int dificuldade){
		for(int line = 0 ; line < x; line++){
			for(int column = 0 ; column < y ; column++){
				minas[line][column] = 0;
			}
		}

		for(int i=1 ; i<=dificuldade ; i++){

			linha = random.nextInt(x-1);
			coluna = random.nextInt(y-1);
			if(minas[linha][coluna]==-1){
				i--;
			}else{
				//Bomba b = new Bomba(j,linha,coluna);
				//BombaDao bdao = new BombaMySQLDao();
				//bdao.inserir(b);
			}
			minas[linha][coluna] = -1;
		}

		for(int line = 0 ; line < x; line++){
			for(int column = 0 ; column < y ; column++){
				if ((minas[line][column]) == 0){
					ganhou++;
				}
			}
		}
	}
	
	public void checarLados(int linha, int coluna) {
		if ((linha != 0) && (coluna != 0) && (linha != 9) && (coluna != 9)) {

			checarValor(linha - 1, coluna - 1);
			checarValor(linha - 1, coluna);
			checarValor(linha - 1, coluna + 1);
			checarValor(linha, coluna - 1);
			checarValor(linha, coluna + 1);
			checarValor(linha + 1, coluna - 1);
			checarValor(linha + 1, coluna);
			checarValor(linha + 1, coluna + 1);

		} else {
			if ((linha == 0) && (coluna == 0)) {
				checarValor(linha, coluna + 1);
				checarValor(linha + 1, coluna);
				checarValor(linha + 1, coluna + 1);
			}

			if ((linha == 0) && (coluna == 9)) {
				checarValor(linha, coluna - 1);
				checarValor(linha + 1, coluna - 1);
				checarValor(linha + 1, coluna);
			}

			if ((linha == 9) && (coluna == 0)) {
				checarValor(linha - 1, coluna);
				checarValor(linha - 1, coluna + 1);
				checarValor(linha, coluna + 1);

			}
			if ((linha == 9) && (coluna == 9)) {
				checarValor(linha - 1, coluna - 1);
				checarValor(linha - 1, coluna);
				checarValor(linha, coluna - 1);
			}

			if ((linha == 0) && (coluna != 0) && (coluna != 9)) {
				checarValor(linha, coluna - 1);
				checarValor(linha, coluna + 1);
				checarValor(linha + 1, coluna - 1);
				checarValor(linha + 1, coluna);
				checarValor(linha + 1, coluna + 1);
			}

			if ((linha == 9) && (coluna != 0) && (coluna != 9)) {
				checarValor(linha - 1, coluna - 1);
				checarValor(linha - 1, coluna);
				checarValor(linha - 1, coluna + 1);
				checarValor(linha, coluna - 1);
				checarValor(linha, coluna + 1);
			}

			if ((coluna == 0) && (linha != 0) && (linha != 9)) {
				checarValor(linha - 1, coluna);
				checarValor(linha - 1, coluna + 1);
				checarValor(linha, coluna + 1);
				checarValor(linha + 1, coluna);
				checarValor(linha + 1, coluna + 1);
			}

			if ((coluna == 9) && (linha != 0) && (linha != 9)) {
				checarValor(linha - 1, coluna - 1);
				checarValor(linha - 1, coluna);
				checarValor(linha, coluna - 1);
				checarValor(linha + 1, coluna - 1);
				checarValor(linha + 1, coluna);
			}
		}

	}
	
	public void checarValor(int linha, int coluna) {
		if (acessada[linha][coluna] == false) {
			if (minas[linha][coluna] == 0) {
				Botoes[linha][coluna]
						.setIcon(new javax.swing.ImageIcon(getClass()
								.getResource("/resources/botaoapertado.jpg")));
			} else {
				if (minas[linha][coluna] == 1) {
					Botoes[linha][coluna].setIcon(new javax.swing.ImageIcon(
							getClass().getResource(
									"/resources/botaoapertado1.jpg")));
				} else {

					if (minas[linha][coluna] == 2) {
						Botoes[linha][coluna]
								.setIcon(new javax.swing.ImageIcon(
										getClass()
												.getResource(
														"/resources/botaoapertado2.jpg")));
					} else {
						if (minas[linha][coluna] == 3) {
							Botoes[linha][coluna]
									.setIcon(new javax.swing.ImageIcon(
											getClass()
													.getResource(
															"/resources/botaoapertado3.jpg")));
						} else {
							if (minas[linha][coluna] == 4) {
								Botoes[linha][coluna]
										.setIcon(new javax.swing.ImageIcon(
												getClass()
														.getResource(
																"/resources/botaoapertado4.jpg")));
							} else {
								if (minas[linha][coluna] == 5) {
									Botoes[linha][coluna]
											.setIcon(new javax.swing.ImageIcon(
													getClass()
															.getResource(
																	"/resources/botaoapertado5.jpg")));
								} else {
									if (minas[linha][coluna] == 6) {
										Botoes[linha][coluna]
												.setIcon(new javax.swing.ImageIcon(
														getClass()
																.getResource(
																		"/resources/botaoapertado6.jpg")));
									} else {
										if (minas[linha][coluna] == 7) {
											Botoes[linha][coluna]
													.setIcon(new javax.swing.ImageIcon(
															getClass()
																	.getResource(
																			"/resources/botaoapertado7.jpg")));
										} else {
											if (minas[linha][coluna] == 8) {
												Botoes[linha][coluna]
														.setIcon(new javax.swing.ImageIcon(
																getClass()
																		.getResource(
																				"/resources/botaoapertado8.jpg")));
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		acessada[linha][coluna] = true;
	}


	public void checarBotao (int linha, int coluna, JButton c){


		if(minas[linha][coluna]==-1){
			c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botaobomba.jpg")));
			acabou = true;
			String msg = "Você perdeu!";
			JOptionPane.showMessageDialog(null, msg);
			System.exit(0);
		}

		if(minas[linha][coluna] == 0){
			Botoes[linha][coluna]
					.setIcon(new javax.swing.ImageIcon(getClass()
							.getResource("/resources/botaoapertado.jpg")));
			acessada[linha][coluna] = true;

			checarLados(linha, coluna);
		} else {
			if (minas[linha][coluna] == 1) {
				Botoes[linha][coluna].setIcon(new javax.swing.ImageIcon(
						getClass().getResource(
								"/resources/botaoapertado1.jpg")));
			} else {

				if (minas[linha][coluna] == 2) {
					Botoes[linha][coluna]
							.setIcon(new javax.swing.ImageIcon(
									getClass()
									.getResource(
											"/resources/botaoapertado2.jpg")));
				} else {
					if (minas[linha][coluna] == 3) {
						Botoes[linha][coluna]
								.setIcon(new javax.swing.ImageIcon(
										getClass()
										.getResource(
												"/resources/botaoapertado3.jpg")));
					} else {
						if (minas[linha][coluna] == 4) {
							Botoes[linha][coluna]
									.setIcon(new javax.swing.ImageIcon(
											getClass()
											.getResource(
													"/resources/botaoapertado4.jpg")));
						} else {
							if (minas[linha][coluna] == 5) {
								Botoes[linha][coluna]
										.setIcon(new javax.swing.ImageIcon(
												getClass()
												.getResource(
														"/resources/botaoapertado5.jpg")));
							} else {
								if (minas[linha][coluna] == 6) {
									Botoes[linha][coluna]
											.setIcon(new javax.swing.ImageIcon(
													getClass()
													.getResource(
															"/resources/botaoapertado6.jpg")));
								} else {
									if (minas[linha][coluna] == 7) {
										Botoes[linha][coluna]
												.setIcon(new javax.swing.ImageIcon(
														getClass()
														.getResource(
																"/resources/botaoapertado7.jpg")));
									} else {
										if (minas[linha][coluna] == 8) {
											Botoes[linha][coluna]
													.setIcon(new javax.swing.ImageIcon(
															getClass()
															.getResource(
																	"/resources/botaoapertado8.jpg")));
										}
									}
								}
							}
						}
					}
				}
			}
		}

		if(minas[linha][coluna]==1){
			c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botaoapertado1.jpg")));
		} 

		if(minas[linha][coluna]==2){
			c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botaoapertado2.jpg")));
			//mapa[linha][coluna].setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botaoapertado2.jpg")));
		}
		if(minas[linha][coluna]==3){
			c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botaoapertado3.jpg")));
		}
		if(minas[linha][coluna]==4){ 
			c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botaoapertado4.jpg")));
		}
		if(minas[linha][coluna]==5){
			//c.setText("5");
			c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botaoapertado5.jpg")));
		}
		if(minas[linha][coluna]==6){
			c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botaoapertado6.jpg")));
		}
		if(minas[linha][coluna]==7){         
			c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botaoapertado7.jpg")));
		}
		if(minas[linha][coluna]==8){
			c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/botaoapertado8.jpg")));
		}
		contador++;
		if (contador == ganhou){
			JOptionPane.showMessageDialog(null, "Parab�ns! Voc� ganhou!");
			String nome = JOptionPane.showInputDialog("Nome:");
			//new JogadorArquivos(nome,new BotoesBackground().getTempo()+"");
			System.exit(0);
		}

	}
	public boolean getAcabou(){
		return acabou;
	}


}
