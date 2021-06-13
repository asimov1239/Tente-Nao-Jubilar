package tentenaojubilar;

import java.util.ArrayList;

public class Jogador {
    String nome;
    int credito;
    Instituto[] institutos;

    Jogador(String nome) {
        this.nome = nome;
    }


    void adicionarInstituto(Instituto add) {
        int novotamanho = this.institutos.length + 1;
        Instituto[] novo = new Instituto[novotamanho];
        int j = 0;
        for (int i = 0; i < this.institutos.length; i++) {
            novo[i] = institutos[j];
            j++;
        }
        this.institutos = novo;
    }

}