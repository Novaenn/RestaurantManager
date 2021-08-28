import java.util.ArrayList;

public class Ordine {

	private int prezzoTot;
	
	private ArrayList<Piatto> piattiOrdinati;
	
	public Ordine() {
		prezzoTot = 0;
		piattiOrdinati = new ArrayList<>();
	}
	
	//public static void main(String[] args) {
	//	Ordine ciao = new Ordine();
	//	ciao.addPiattoOrdinato(new Piatto("Gatto", 25));
	//	ciao.addPiattoOrdinato(new Piatto("Capra", 17));
	//	System.out.println(ciao.formattaOrdine());
	//}

	public void addPiattoOrdinato(Piatto nPiatto) {
		piattiOrdinati.add(nPiatto);
		prezzoTot += nPiatto.getPrezzo();
	}
	
	public void removePiattoOrdinato(Piatto nPiatto) {
		for (int i = 0; i <= piattiOrdinati.size(); i++) {
			if (piattiOrdinati.get(i).getNome() == nPiatto.getNome()) {
				piattiOrdinati.remove(i);
			}
		}
	}
	
	public float getPrezzoTot() {
		return prezzoTot;
	}

	public void setPrezzoTot(int prezzoTot) {
		this.prezzoTot = prezzoTot;
	}

	public ArrayList<Piatto> getPiattiOrdinati() {
		return piattiOrdinati;
	}

	public void setPiattiOrdinati(ArrayList<Piatto> piattiOrdinati) {
		this.piattiOrdinati = piattiOrdinati;
	}
	
	public void clear() {
		prezzoTot = 0;
		piattiOrdinati = new ArrayList<>();
	}
	
	public String formattaOrdine() {
		String stringaOrdine = "";
		for (int i = 0; i < piattiOrdinati.size(); i++) {
			stringaOrdine +=String.format("%-25s %5.2f", piattiOrdinati.get(i).getNome(), piattiOrdinati.get(i).getPrezzo());				
			stringaOrdine += "\n";
		}
		stringaOrdine += "\n";
		stringaOrdine += "\n-------------------------------- \n";			
		stringaOrdine += String.format("Totale:%24.2f ", this.getPrezzoTot());
		return stringaOrdine;
		}
	
}
