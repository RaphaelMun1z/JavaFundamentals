package entities;

public class ContaBancaria {
	private String nome;
	private String cpf;
	private Float saldo;

	public ContaBancaria() {

	}

	public ContaBancaria(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.saldo = 0.0F;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public Float getSaldo() {
		return this.saldo;
	}

	public void saque(Float valor) {
		if(valor > 0)
			if(valor <= this.getSaldo())
				this.saldo -= valor;
			else
				System.out.println("Erro: Valor em conta insuficiente!\n");
		else
			System.out.println("Erro: Valor de depósito inválido!\n");
	}

	public void deposito(Float valor) {
		if(valor > 0)
			this.saldo += valor;
		else
			System.out.println("Erro: Valor de depósito inválido!\n");
	}
	
	public String toString() {
		return "Nome: " + this.getNome() + ", Cpf: " + this.getCpf() + ", Saldo: " + this.getSaldo();
	}
}
