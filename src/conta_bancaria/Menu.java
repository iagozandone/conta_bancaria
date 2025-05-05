package conta_bancaria;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
        Scanner leia = new Scanner(System.in);
        
        ContaController contas = new ContaController();
        
        int opcao, numero, agencia, tipo, aniversario, numeroDestino;
        String titular;
        float saldo, limite,valor;
        
        //Dados para teste
        ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);

		contas.cadastrar(cc1);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);

		contas.cadastrar(cp1);
 
        
        
        while (true) {

            System.out.println(Cores.TEXT_CYAN+ Cores.ANSI_BLACK_BACKGROUND+"╔═══════════════════════════════════╗ ");
            System.out.println("║               BANCO               ║ ");
            System.out.println("║    SEU DINHEIRO NOSSA ALEGRIA     ║ ");
            System.out.println("╠═══════════════════════════════════╣ ");
            System.out.println("║ 1 │ Criar Nova Conta              ║ ");
            System.out.println("║ 2 │ Listar Todas as Contas        ║ ");
            System.out.println("║ 3 │ Buscar Conta por Número       ║ ");
            System.out.println("║ 4 │ Atualizar Dados da Conta      ║ ");
            System.out.println("║ 5 │ Excluir Conta                 ║ ");
            System.out.println("║ 6 │ Realizar Saque                ║ ");
            System.out.println("║ 7 │ Realizar Depósito             ║ ");
            System.out.println("║ 8 │ Realizar Transferência        ║ ");
            System.out.println("║ 9 │ Sair do Sistema               ║ ");
            System.out.println("╚═══════════════════════════════════╝ ");

            System.out.println("Escolha uma opção:                    ");
            opcao = leia.nextInt();
            System.out.println(Cores.TEXT_RESET);

            if (opcao == 9) {
                System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + "Programa finalizado!\n");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("Criar Conta\n");
                    
                    System.out.println("Digite o número da Agência: ");
                    agencia = leia.nextInt();
                    
                    System.out.println("Digite o nome do titular: ");
                    leia.skip("\\R");
                    titular = leia.nextLine();
                    
                    System.out.println("Digite o tipo de conta (1 - CC | 2 - CP: ");
                    tipo = leia.nextInt();
                    
                    System.out.println("Digite o saldo inicial da conta: ");
                    saldo = leia.nextInt();
                    
                    switch(tipo) {
                    case 1 -> {
                    	System.out.println("Digite o limite da conta: ");
                        limite = leia.nextFloat();
                        contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
                        
                    }
                	case 2 -> {
                		System.out.println("Digite o dia do aniversário da conta: ");
                		aniversario = leia.nextInt();
                		contas.cadastrar(new ContaPoupanca(contas.gerarNumero(),agencia, tipo, titular, saldo, aniversario));
                    
                	}
                }
                    		
                    keyPress();
                    break;
                case 2:
                    System.out.println("Listar todas as Contas\n");
                    contas.listarTodas()
;                    keyPress();
                    break;
                case 3:
                    System.out.println("Consultar dados da Conta - por número\n");
                    	System.out.print("Digite o número da conta: ");
                    	numero = leia.nextInt();
                    	
                    	contas.procurarPorNumero(numero);
                    	         
                    keyPress();
                    break;
                case 4:
                    System.out.println("Atualizar dados da Conta\n");
                    
                    // Informe o numero da conta
                    System.out.print("Digite o número da conta: ");
                	numero = leia.nextInt();
                	
                	Optional <Conta> conta = contas.buscarNaCollection(numero);
                	
                	// Existe?
                	if (conta.isPresent()) {
                		
                		//Atualizar os dados
                		System.out.println("Digite o número da Agência: ");
                        agencia = leia.nextInt();
                        
                        System.out.println("Digite o nome do titular: ");
                        leia.skip("\\R");
                        titular = leia.nextLine();
                        
                        // Recuperar o tipo da conta
                        tipo = conta.get().getTipo();
                        
                        System.out.println("Digite o novo saldo da conta: ");
                        saldo = leia.nextInt();
                        
                        // Identificar o tipo
                        switch(tipo) {
	                        case 1 -> { // Se for conta Corrente
	                        	System.out.println("Digite o limite da conta: ");
	                            limite = leia.nextFloat();
	                            contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
	                            
	                        }
	                    	case 2 -> { // Se for Conta Poupança
	                    		System.out.println("Digite o dia do aniversário da conta: ");
	                    		aniversario = leia.nextInt();
	                    		contas.atualizar(new ContaPoupanca(numero,agencia, tipo, titular, saldo, aniversario));
	                    	}
	                    }
                		
                	}else // Caso não exista a conta
                		System.out.printf("\nA conta número %d não existe! ", numero);
                    
                    keyPress();
                    break;
                case 5:
                    System.out.println("Apagar a Conta\n");
                    System.out.print("Digite o número da conta: ");
                	numero = leia.nextInt();
                	contas.deletar(numero);
                	
                    keyPress();
                    break;
                case 6:
                    System.out.println("Saque\n");
                                    	
                    System.out.print("Digite o número da conta: ");
                	numero = leia.nextInt();
                	
                	System.out.print("Digite o valor do saque: ");
                	valor = leia.nextFloat();
                	
                	contas.sacar(numero, valor);
                	         
                    keyPress();
                    break;
                case 7:
                    System.out.println("Depósito\n");
                    
                    System.out.print("Digite o número da conta: ");
                	numero = leia.nextInt();
                	
                	System.out.print("Digite o valor do deposito: ");
                	valor = leia.nextFloat();
                	
                	contas.depositar(numero, valor);
                	         
                    keyPress();
                    break;
                case 8:
                    System.out.println("Transferência entre Contas\n");
                    
                    System.out.print("Digite o número da conta de origem: ");
                	numero = leia.nextInt();
                	
                	 System.out.print("Digite o número da conta de destino: ");
                 	numeroDestino = leia.nextInt();
                	
                	System.out.print("Digite o valor da tranferência: ");
                	valor = leia.nextFloat();
                	
                	contas.tranferir(numero, numeroDestino, valor);
                    
                    keyPress();
                    break;
                default:
                    System.out.println("\nOpção Inválida!\n");
                    keyPress();
                    break;
            }
        }
    }

    public static void keyPress() {
        try {
            System.out.println(Cores.TEXT_RESET + "\nPressione Enter para continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de Enter!");
        }
    }

    public static void sobre() {
        System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND +
                "╔════════════════════════════════════════════╗");
        System.out.println("║         Projeto Desenvolvido por:          ║");
        System.out.println("║                                            ║");
        System.out.println("║   Iago Zandone - iagozandone@gmail.com     ║");
        System.out.println("║   https://github.com/iagozandone           ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
}