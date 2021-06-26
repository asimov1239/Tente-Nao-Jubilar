package exceptions;

public class DirecaoInvalida extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DirecaoInvalida() {
		super();
	}
	
	public DirecaoInvalida(String mensagem) {
		super(mensagem);
	}
	
}
