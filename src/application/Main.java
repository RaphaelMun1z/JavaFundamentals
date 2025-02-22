package application;

import java.util.ArrayList;
import java.util.List;

import entities.ContaBancaria;
import exceptions.OperacaoInvalida;

public class Main {

	public static void main(String[] args) {
		List<ContaBancaria> contas = new ArrayList<>(List.of(new ContaBancaria(1234567F, "Garen", "123.123.123-12"),
				new ContaBancaria(1234568F, "Ashe", "922.683.820-87"),
				new ContaBancaria(1234569F, "Jax", "755.437.400-18"),
				new ContaBancaria(1234560F, "Skarner", "379.802.520-71"),
				new ContaBancaria(1234561F, "Darius", "211.506.840-89"),
				new ContaBancaria(1234562F, "Blitz", "514.173.480-38")));

		try {
			contas.get(0).deposito(5000F);
			contas.get(0).transferencia(contas, 1234562F, 90150F);
			System.out.println(contas.get(5));
		} catch (OperacaoInvalida e) {
			System.out.println(e.getMessage());
		}
	}

}
