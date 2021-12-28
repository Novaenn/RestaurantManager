
public class Piatto {

	private String nome;
	private float prezzo;
	
	public Piatto(String pNome, float pPrezzo) {
		nome = pNome;
		prezzo = pPrezzo;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}


	public float getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	public String toString() {
		return this.nome+ " " +String.valueOf(this.prezzo) + " €";
	}
	
}
