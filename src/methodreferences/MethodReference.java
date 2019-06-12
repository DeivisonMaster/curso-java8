package methodreferences;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MethodReference {
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");
		
		
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		// Method reference 1
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		
		// Method reference 2
		palavras.sort(Comparator.comparing(String::length));
		
		
		// Comparador destrinchado
		Function<String, Integer> funcao = new Function<String, Integer>(){

			@Override
			public Integer apply(String s) {
				return s.length();
			}
		};
		Comparator<String> comparador = Comparator.comparing(funcao);
		palavras.sort(comparador);
	}
}



















