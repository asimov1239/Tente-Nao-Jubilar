package control;

public class Pagamento {
	private int creditos;
	private String proprietario;
	
	public Pagamento(int creditos, String proprietario) {
		this.creditos = creditos;
		this.proprietario = proprietario;
	}
	
	public int getCreditos() {
		return creditos;
	}
	
	public String getProprietario() {
		return proprietario;
	}
	
}
