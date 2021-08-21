import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Scontrino {

    private String scontrino;

    public Scontrino(String scontr) {
        scontrino = scontr;
    }

    public void stampa(String fileName){
    	try {
    		File file = new File(fileName);
    		PrintWriter fileOutput = new PrintWriter(fileName);
    		fileOutput.println(scontrino);
    		fileOutput.close();
    	}
    	catch(IOException e) {
    		// DEVE FA QUALCOSA I GUESS
    	}
    	
    }

}
