package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.ContaBancaria;

public class Main {

	public static void main(String[] args) {
		List<ContaBancaria> contas = new ArrayList<>(
			List.of(
				new ContaBancaria("Garen", "123.123.123-12"),
				new ContaBancaria("Ashe", "922.683.820-87"),
				new ContaBancaria("Jax", "755.437.400-18"),
				new ContaBancaria("Skarner", "379.802.520-71"),
				new ContaBancaria("Darius", "211.506.840-89"),
				new ContaBancaria("Blitz", "514.173.480-38")
			)
		);
		
		List<ContaBancaria> contasFiltradas = contas.stream()
				.filter(c -> c.getNome().contains("e"))
				.collect(Collectors.toList());
		contasFiltradas.forEach(c -> System.out.println(c));
		
		List<ContaBancaria> contasModificadas = contas.stream()
				.peek(c -> c.deposito(150.00F))
				.collect(Collectors.toList());
		contasModificadas.forEach(c -> System.out.println(c));
		
		List<Float> contasSaldo = contas.stream()
				.map(c -> c.getSaldo())
				.collect(Collectors.toList());
		contasSaldo.forEach(c -> System.out.println(c));
	}

}
