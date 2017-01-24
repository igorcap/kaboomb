//package arquivo;
//
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//
//import background.BotoesBackground;
//
//public class JogadorArquivos {
//	BotoesBackground b = new BotoesBackground();
//
//
//	private String nome;
//	private int pontuacao;
//	private String nomerecordista;
//	private int pontuacaorecordista;
//	private int menor;
//	
//	public JogadorArquivos(String nome, int pontuacao){
//		this.nome = nome;
//		this.pontuacao = pontuacao;
//		menor =99999999;
//		gravarInfo();
//	}
//	public JogadorArquivos(){}
//
//
//
//	public void gravarInfo() {
//
//		File file = new File("c:\\temp\\ranking.txt");
//		FileWriter fos = null;
//		BufferedWriter br = null;
//
//		try {
//
//			fos = new FileWriter(file, true);
//			br = new BufferedWriter(fos);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//
//
//			br.write(nome + ";");
//			br.write(pontuacao);
//			br.newLine();
//			br.close();
//
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//
//
//	public String getNomerecordista() {
//		return nomerecordista;
//	}
//	public String getPontuacaorecordista() {
//		return ""+pontuacaorecordista;
//	}
//	public void lerInfo() {
//		File file = new File("c:\\temp\\ranking.txt");
//		String s = null;
//		try {
//			FileReader fr = new FileReader(file);
//			BufferedReader br = new BufferedReader(fr);
//			String x = br.readLine();
//			if (x != null) {
//				String[] valor = x.split(";");
//				nome = valor[0];
//				pontuacao = Integer.parseInt(valor[1]);
//				
//				if(pontuacao < menor){
//					menor = pontuacao;
//					pontuacaorecordista = pontuacao;
//					nomerecordista=nome;
//				}
//
//			}
//			br.close();
//			fr.close();
//		} catch (FileNotFoundException e) {
//			System.out.println("Arquivo n�o foi encontrado");
//		} catch (IOException e) {
//			System.out.println("Erro ao acessar arquivo" + file);
//		}
//	}
//
//
//
//
//}