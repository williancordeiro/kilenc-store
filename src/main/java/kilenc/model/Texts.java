package kilenc.model;

public enum Texts {
	
	GAMES("Games"),
	ADVENTURE("Jogos de Aventura"),
	ACTION("Jogos de Ação"),
	KILENC("Tudo na Kilenc Store");
	
	private String valor;
	
	Texts(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}
