package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
        Scanner leia = new Scanner(System.in);
		
        // Criar (instanciar) um objeto da Classe Conta
        Conta c1 = new Conta(1, 123, 1, "Iago", 500000);
        c1.visualizar();
        
        //Sacar
        c1.sacar(100);
        c1.visualizar();
        
        //Depositar
        c1.depositar(1000);
        c1.visualizar();
        
        //Alterar a Propriedade titular
        c1.setTitular("Iago Zandone");
        c1.visualizar();
        
        
        
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
            int opcao = leia.nextInt();
            System.out.println(Cores.TEXT_RESET + "");

            if (opcao == 9) {
                System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + "             Programa finalizado!             ");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("Criar Conta\n\n");
                    break;
                case 2:
                    System.out.println("Listar todas as Contas\n\n");
                    break;
                case 3:
                    System.out.println("Consultar dados da Conta - por número\n\n");
                    break;
                case 4:
                    System.out.println("Atualizar dados da Conta\n\n");
                    break;
                case 5:
                    System.out.println("Apagar a Conta\n\n");
                    break;
                case 6:
                    System.out.println("Saque\n\n");
                    break;
                case 7:
                    System.out.println("Depósito\n\n");
                    break;
                case 8:
                    System.out.println("Transferência entre Contas\n\n");
                    break;
                default:
                    System.out.println("\nOpção Inválida!\n");
                    break;
            }
        }

	}
    public static void sobre() {
        System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND+"╔════════════════════════════════════════════╗");
        System.out.println("║         Projeto Desenvolvido por:          ║");
        System.out.println("║                                            ║");
        System.out.println("║   Iago Zandone - iagozandone@gmail.com     ║");
        System.out.println("║      https://github.com/iagozandone        ║");
        System.out.println("╚════════════════════════════════════════════╝");    
        }
}
