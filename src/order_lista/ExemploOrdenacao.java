package order_lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacao {

	public static void main(String[] args) {

		List<Gato> meusGatos = new ArrayList<>() {
			{
				add(new Gato("Jon", 18, "Preto"));
				add(new Gato("Miaw", 6, "Caramelo"));
				add(new Gato("Havena", 22, "Rajado"));
			}
		};
		
		
		System.out.println("Exibir em ordem de inserção");
		System.out.println(meusGatos);
		
		System.out.println("Ordem aleatoria");
		Collections.shuffle(meusGatos);
		System.out.println(meusGatos);
		
		System.out.println("Ordem natural (Nome)"); //necessário utilizar o metodo comparable para ordem em uma ordem natural
		Collections.sort(meusGatos);
		System.out.println(meusGatos);
		
		System.out.println("Ordem por idade");
		Collections.sort(meusGatos, new ComparatorIdade());
		System.out.println(meusGatos);
		
		System.out.println("Ordem por cor");
		Collections.sort(meusGatos, new ComparatorCor());
		System.out.println(meusGatos);
		
		System.out.println("Ordem por nome/cor/idade");
		Collections.sort(meusGatos, new ComparatoNomeCorIdade());
		System.out.println(meusGatos);
		
	}

}

class Gato implements Comparable<Gato> {
	private String nome;
	private int idade;
	private String cor;

	public Gato(String nome, int idade, String cor) {
		this.nome = nome;
		this.idade = idade;
		this.cor = cor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Gato [nome=" + nome + ", idade=" + idade + ", cor=" + cor + "]";
	}

	@Override
	public int compareTo(Gato gato) {
		return this.getNome().compareToIgnoreCase(gato.getNome());
	}

	
}

class ComparatorIdade implements Comparator<Gato>{
	
	@Override
	public int compare(Gato g1, Gato g2) {
		return Integer.compare(g1.getIdade(), g2.getIdade());
	}	
	
}

class ComparatorCor implements Comparator<Gato>{
	
	@Override
	public int compare(Gato g1, Gato g2) {
		return g1.getCor().compareToIgnoreCase(g2.getCor());
	}	
	
}

class ComparatoNomeCorIdade implements Comparator<Gato>{
	
	@Override
	public int compare(Gato g1, Gato g2) {
		int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
		if(nome != 0) return nome;
		
		int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
		if (cor != 0) return cor;
		
		return Integer.compare(g1.getIdade(), g2.getIdade());
		
	}	
	
}

