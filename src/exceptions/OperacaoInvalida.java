package exceptions;

public class OperacaoInvalida extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public OperacaoInvalida(String mensagem, String operacao) {
		super("Operação " + operacao + " não realizada: " + mensagem);
	}
}
