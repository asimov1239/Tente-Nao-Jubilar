package tentenaojubilar;

public class Instituto extends Celula {
    String nome = null;
    int aluguel;
    int custo;

    Instituto(int custo, int aluguel, String nome) {
        super();
        this.aluguel = aluguel;
        this.custo = custo;
        this.nome = nome;
    }


}
