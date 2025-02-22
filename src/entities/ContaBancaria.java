package entities;

import java.util.List;
import java.util.Optional;

import exceptions.OperacaoInvalida;

public class ContaBancaria {
	private Float numeroDaConta;
	private String nomeDoTitular;
	private String cpf;
	private Float saldo;

	public ContaBancaria() {

	}

	public ContaBancaria(Float numeroDaConta, String nomeDoTitular, String cpf) {
		this.numeroDaConta = numeroDaConta;
		this.nomeDoTitular = nomeDoTitular;
		this.cpf = cpf;
		this.saldo = 0.0F;
	}

	public Float getNumeroDaConta() {
		return this.numeroDaConta;
	}

	public String getNomeDoTitular() {
		return this.nomeDoTitular;
	}

	public void setNomeDoTitular(String nome) {
		this.nomeDoTitular = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Float getSaldo() {
		return this.saldo;
	}

	public void saque(Float valor) {
		if (valor > 0) {
			if (valor <= this.getSaldo()) {
				this.saldo -= valor;
				System.out.println(
						"[" + this.getNomeDoTitular() + "] Sucesso: Valor de R$" + valor + " subtraido da conta!");
			} else {
				throw new OperacaoInvalida("Valor em conta insuficiente!", "saque");
			}
		} else {
			throw new OperacaoInvalida("Valor de saque inválido!", "saque");
		}
	}

	public void deposito(Float valor) {
		if (valor > 0) {
			this.saldo += valor;
			System.out
					.println("[" + this.getNomeDoTitular() + "] Sucesso: Valor de R$" + valor + " adicionado a conta!");
		} else {
			throw new OperacaoInvalida("Valor de depósito inválido!", "deposito");
		}
	}

	public void transferencia(List<ContaBancaria> contas, Float numContaDest, Float valor) {
		Optional<ContaBancaria> contaDest = contas.stream()
				.filter(c -> c.getNumeroDaConta().equals(numContaDest))
				.findFirst();
		if (contaDest.isPresent()) {
			saque(valor);
			contaDest.get().deposito(valor);
			System.out.println("[" + this.getNomeDoTitular() + "] Sucesso: Transferência de R$" + valor + " para "
					+ contaDest.get().getNomeDoTitular() + " realizado!");
		} else {
			throw new OperacaoInvalida("Conta de destino inexistente!", "transferência");
		}
	}

	public String toString() {
		return "Nome: " + this.getNomeDoTitular() + ", Cpf: " + this.getCpf() + ", Saldo: " + this.getSaldo();
	}
}
