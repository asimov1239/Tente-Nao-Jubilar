package space;

import java.util.ArrayList;
import java.util.Scanner;

import actor.Jogador;

public class Empresa extends Propriedade {
	
	public ArrayList<Object> efeito(Jogador jogador, int casas) {
		Scanner teclado = new Scanner(System.in);
		ArrayList<Object> pagamento = null;
		if (dono == null) {
			if (jogador.getCredito() > custo) {
				System.out.println("Voce deseja comprar " + nome + "? Lhe custará " + custo + " e você receberá " + aluguel + " de aluguel");
				String resposta = teclado.nextLine();
				if (resposta.equalsIgnoreCase("sim")) {
					jogador.setCredito(-custo);
					jogador.adicionarPropriedade(this);
					this.dono = jogador.getNome();
					System.out.println("Voce comprou " + nome + "!");
				}
			}
		}
		else if (!jogador.getNome().equals(dono)) {
			int precoTotal = casas * aluguel;
			System.out.println(nome + " é propriedade de " + dono + ". Lhe pague pelos seus servicos: " + casas + " * " + aluguel + " = " + precoTotal +  " creditos."); 
			jogador.setCredito(-precoTotal);
			pagamento = new ArrayList<Object>(2);
			pagamento.add(dono);
			pagamento.add(precoTotal);
		}
		teclado.close();
		return pagamento;
		
		
		
		
		
	}
	
}
