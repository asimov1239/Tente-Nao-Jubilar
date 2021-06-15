package tentenaojubilar;

public class Empresa extends Propriedade {
    String nome;
    int custo;
    int aluguel;

    Empresa(String nome, int aluguel, int custo) {
    	super(nome, aluguel, custo);
    }
}
