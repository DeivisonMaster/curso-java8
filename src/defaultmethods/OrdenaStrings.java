package defaultmethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		// comparando em ordem natural
		Collections.sort(palavras);
		System.out.println("Ordenação natural: " + palavras);

		Comparator<String> comparador = new ComparadorPorTamanho();
		Collections.sort(palavras, comparador);
		System.out.println("Ordenação especifica " + palavras);
		
		// Java 8
		palavras.sort(comparador);
		System.out.println("Ordenação com Java 8: " + palavras);
		
		
		// forEach
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
		
	}
}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println(s);
	}
	
}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length()) {
			return -1;
		}
		if (s1.length() > s2.length()) {
			return 1;
		}
		return 0;
	}

}























