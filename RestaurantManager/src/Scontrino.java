import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Scontrino {

    private String scontrino;

    public Scontrino(String scontr) {
        scontrino = scontr;
    }

    public void aggiungiRiga(String piattoStr) {
    	scontrino += piattoStr;
    }
    
    public String formattaRiga(Piatto piatto) {
    	String stringa = String.format("%-25s %5.2f", piatto.getNome(), piatto.getPrezzo());
    	stringa += "\n";
    	return stringa;
    }
    
    public void stampa(String fileName){
    	try {
    		File file = new File(fileName);
    		PrintWriter fileOutput = new PrintWriter(fileName);
    		fileOutput.println(scontrino);
    		fileOutput.close();
    	}
    	catch(IOException e) {
    		System.out.println("Errore di Sistema.");
    	}
    	
    }

}
