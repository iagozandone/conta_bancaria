package conta_bancaria.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repositiry.ContaRepository;

public class ContaController implements ContaRepository {

	//Criar a Collection ArrayList
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	
	//Variavel para contolar os número das contas
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);
		
		if (conta.isPresent()) {
			conta.get().visualizar();;
	}else {
			System.out.printf("\nA Conta %d não foi encontrada ", numero);
		}
	}

	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("Aconta foi criada com sucesso!");
		
	
	}

	@Override
	public void atualizar(Conta conta) {
		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
			System.out.println("\nDados Anteriores");
			buscaConta.get().visualizar();
			System.out.println("\nDados Atualizados");
			procurarPorNumero(buscaConta.get().getNumero());
		System.out.printf("\nA Conta %d foi atualizada com sucesso! ", conta.getNumero());
		
		}else {
			System.out.printf("\nA Conta %d não foi encontrada ", numero);
		}
		}

	@Override
	public void deletar(int numero) {
	    Optional<Conta> conta = buscarNaCollection(numero);
	    
	    if (conta.isPresent()) {
	        if (listaContas.remove(conta.get()) == true)
	            System.out.printf("\nA Conta número %d foi excluída com sucesso!", numero);
	    } else {
	        System.out.printf("\nA Conta %d não foi encontrada ", numero);
	    }
	}


	@Override
	public void sacar(int numero, float valor) {
		
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		 Optional<Conta> conta = buscarNaCollection(numero);
		    
		    if (conta.isPresent()) {
		    	if (conta.get().sacar(valor) == true)
			        System.out.println("\nO deposito de " + nfMoeda.format(valor) +  " foi efetuado com sucesso na conta número: " + numero );
		    }
	}

	@Override
	public void depositar(int numero, float valor) {
		
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		 Optional<Conta> conta = buscarNaCollection(numero);
		    
		 if (conta.isPresent()) {
			 conta.get().depositar(valor);
		        System.out.println("\nO deposito de " + nfMoeda.format(valor) +  " foi efetuado com sucesso na conta número: " + numero );
	    } else {
	        System.out.printf("\nA Conta %d não foi encontrada ", numero);
		}
	}

	@Override
	public void tranferir(int numeroOrigem, int numeroDestino, float valor) {
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		 Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		 Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);
		 
		 if (contaOrigem.isPresent() && contaDestino.isPresent()) {
			 if (contaOrigem.get().sacar(valor) == true)
			 contaDestino.get().depositar(valor);
		        System.out.println("\nA transferência no valor de " + nfMoeda.format(valor) +  "da Conta" + numeroOrigem + " para a conta "+ numeroDestino +" foi efetuado com sucesso! ");
	    } else {
	        System.out.printf("\nA Conta %d não foi encontrada ", numero);
		}
	}

	//Métodos Auxiliares
	public int gerarNumero() {
		return ++numero;
	}
	public Optional<Conta> buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if(conta.getNumero() == numero)
				return Optional.of(conta);
		}
		
		return Optional.empty();
	}
}
