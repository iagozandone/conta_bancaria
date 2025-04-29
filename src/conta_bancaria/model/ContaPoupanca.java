package conta_bancaria.model;
import java.time.LocalDate;

public class ContaPoupanca extends Conta {
	private int aniversarioConta;
	private final float rendimento = 0.005f;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversarioConta) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversarioConta = aniversarioConta;
	}

	public int getAniversarioConta() {
		return aniversarioConta;
	}

	public void setAniversarioConta(int aniversarioConta) {
		this.aniversarioConta = aniversarioConta;
	}
	public void render() {
		int diaAtual = LocalDate.now().getDayOfMonth();

		if (diaAtual == this.aniversarioConta) {
			float valorRendimento = getSaldo() * this.rendimento;
			setSaldo(getSaldo() + valorRendimento);
			System.out.println("Rendimento aplicado: R$" + valorRendimento);
		} else {
			System.out.println("Hoje não é o dia do aniversário da conta. Nenhum rendimento aplicado.");
		}
	}
	@Override
	public void visualizar() {
	    super.visualizar();
	    System.out.println("Aniversário da conta todo dia: " + this.aniversarioConta);
	}

}
