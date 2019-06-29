package methodreferences;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReference {
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();

		palavras.add("Alura Online");
		palavras.add("editora casa do código");
		palavras.add("caelum");
		
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		Consumer<String> consumidor = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};
		
		// lambda
		Consumer<String> consumer = s -> System.out.println(s);
		
		
		// sem lambda
		Function<String, Integer> function = new Function<String, Integer>(){
			@Override
			public Integer apply(String s) {
				return s.length();
			}
		};
		Comparator<String> comparador = Comparator.comparing(function); 
		palavras.sort(comparador);
		
		
		
		// com lambda
		palavras.sort(Comparator.comparing(s -> s.length()));

		
		// Method Reference
		palavras.sort(Comparator.comparing(String::length));
		
		//palavras.forEach(consumer);
		
		palavras.forEach(System.out::println);
	}
}



















