import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe rappresentante uno scontrino
 * @author Samuele Bella & Francesco De Persio
 *
 */
public class Scontrino {

	/**
	 * Stringa da trascrivere sullo scontrino
	 */
    private String scontrino;

    public Scontrino(String scontr) {
        scontrino = scontr;
    }

    /**
     * Metodo che aggiunge alla stringa "scontrino" una riga relativo alle informazioni di un piatto
     * @param piattoStr Riga relativo alle informazioni di un piatto
     */
    public void aggiungiRiga(String piattoStr) {
    	scontrino += piattoStr;
    }
    
    /**
     * Metodo che formatta la stringa da aggiungere a "scontrino"
     * @param piatto Piatto da cui prendere le informazioni per la stringa da scrivere
     * @return Stringa formattata da trascrivere
     */
    public String formattaRiga(Piatto piatto) {
    	String stringa = String.format("%-25s %5.2f", piatto.getNome(), piatto.getPrezzo());
    	stringa += "\n";
    	return stringa;
    }
    
    /**
     * Crea il file .txt dello scontrino
     * @param fileName Nome da dare al file .txt
     */
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
