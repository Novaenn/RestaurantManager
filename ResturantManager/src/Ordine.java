import java.util.ArrayList;

public class Ordine {

	private int num = 0;
	
	private int prezzoTot;
	
	private ArrayList<Piatto> piattiOrdinati;
	
	public Ordine() {
		num++;
		prezzoTot = 0;
		piattiOrdinati = new ArrayList<>();
	}
	

	public void addPiattoOrdinato(Piatto nPiatto) {
		piattiOrdinati.add(nPiatto);
		prezzoTot += nPiatto.getPrezzo();
	}
	
	public void removePiattoOrdinato(Piatto nPiatto) {
		piattiOrdinati.remove(nPiatto);
		prezzoTot -= nPiatto.getPrezzo();
	}
	
	public float getPrezzoTot() {
		return prezzoTot;
	}

	public int getNum() {
		return num;
	}
	
	public void setNum(int numero) {
		num = numero;
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
		num++;
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
	
	public String toString() {
		return "Ordine #"+String.valueOf(num);
		
	}
	
}
