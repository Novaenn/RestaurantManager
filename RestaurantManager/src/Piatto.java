/**
 * Classe rappresentante un piatto
 * @author Samuele Bella & Francesco De Persio
 *
 */
public class Piatto {

	/**
	 * Nome del piatto
	 */
	private String nome;
	
	/**
	 * Prezzo del piatto
	 */
	private float prezzo;
	
	public Piatto(String pNome, float pPrezzo) {
		nome = pNome;
		prezzo = pPrezzo;
	}
	
	/**
	 * Ritorna il nome del piatto
	 * @return Nome del piatto
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Setta il nome del piatto
	 * @param nome Nome da dare al piatto
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Ritorna il prezzo del piatto
	 * @return Prezzo del piatto
	 */
	public float getPrezzo() {
		return prezzo;
	}

	/**
	 * Setta il prezzo del piatto
	 * @param prezzo Prezzo da dare al piatto
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	public String toString() {
		return this.nome+ " " +String.valueOf(this.prezzo) + " €";
	}
	
}
