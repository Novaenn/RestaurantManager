
public class Chef {
	
	private Menu Menu;
	
	public Chef(Menu cMenu) {
		Menu =  cMenu;
	}
	
	public void aggiungiPiatto(String nomePiatto, float prezzoPiatto) {
		Menu.addPiatto(new Piatto(nomePiatto, prezzoPiatto));
	}

	public void eliminaPiatto(String nomePiatto) {
		Menu.removePiatto(nomePiatto);
	}
	
	public void modificaNome(String newName, String nomePiatto) {
		Menu.modificaNome(newName, nomePiatto);
	}
	
	public void modificaPrezzo(float prezzoPiatto, String nomePiatto) {
		Menu.modificaPrezzo(prezzoPiatto, nomePiatto);
	}
	
	public String stampa() {
		return Menu.formattaMenu();
	}
}
