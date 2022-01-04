/**
 * Classe rappresentate il lavoro di uno chef
 * @author Samuele Bella & Francesco De Persio
 *
 */
public class Chef {
	
	/**
	 * Menu gestito dallo chef
	 */
	private Menu mMenu;
	
	public Chef(Menu cMenu) {
		mMenu =  cMenu;
	}
	
	/**
	 * Ritorna l'istanza della classe Menu
	 * @return Il menu
	 */
	public Menu getMenu() {
		return this.mMenu;
	}
	
	/**
	 * Aggiunge un'istanza della classe Piatto all menu
	 * @param nomePiatto Nome del piatto
	 * @param prezzoPiatto Prezzo del piatto
	 */
	public void aggiungiPiatto(String nomePiatto, float prezzoPiatto) {
		mMenu.addPiatto(new Piatto(nomePiatto, prezzoPiatto));
	}

	/**
	 * Rimuove un'istanza della classe Piatto dal menu
	 * @param nomePiatto Nome del piatto
	 */
	public void eliminaPiatto(String nomePiatto) {
		mMenu.removePiatto(nomePiatto);
	}
	
	/**
	 * Modifica l'attributo nome di un'istanza della classe Piatto presente nel menu
	 * @param newName Nuovo nome del piatto
	 * @param nomePiatto Vecchio nome del piatto
	 */
	public void modificaNome(String newName, String nomePiatto) {
		mMenu.modificaNome(newName, nomePiatto);
	}
	
	/**
	 * Modifica l'attributo prezzo di un'istanza della classe Piatto presente nel menu
	 * @param prezzoPiatto Valore del nuovo prezzo
	 * @param nomePiatto Nome del piatto
	 */
	public void modificaPrezzo(float prezzoPiatto, String nomePiatto) {
		mMenu.modificaPrezzo(prezzoPiatto, nomePiatto);
	}
}
