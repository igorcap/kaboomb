package layout;
import java.io.*;  
import java.applet.*;  
import java.net.MalformedURLException;  
  
public class Som extends Thread {  
      
    private AudioClip   musica;  //musica pra tocar  
    private String      caminho; //caminho da musica  
      
    public Som(String base) {  
          
        caminho = base; //atribui caminho  
    }  
      
    public void run() {  
          
        try {  
              
            musica  = Applet.newAudioClip(new File(caminho).toURL());   //instancia o obj e...  
            musica.loop();                                              // .... toca sem parar (extremamente irritante)  
        }  
        catch (MalformedURLException e) {  
              
            System.out.println("Erro. Verifique o diretorio de sons"); //erro no arquivo  
        } finally {
		}  
    }  
      
    public AudioClip getMusica() { //retorna a musica  
          
        return musica;  
    }  
}  