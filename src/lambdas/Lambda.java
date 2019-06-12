package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Lambda {

	public static void main(String[] args) {

		/*
		 * O LAMBDA FUNCIONA SEMPRE QUANDO SE TEM UMA INTERFACE COM UNICO MÉTODO
		 * ABSTRATO
		 */

		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		// comparando em ordem natural
		Collections.sort(palavras);
		System.out.println("Ordenação natural: " + palavras);

		
		// 1° forma de implementar comparator com Lambda
		palavras.sort((s1, s2) -> {
			if (s1.length() < s2.length()) {
				return -1;
			}
			if (s1.length() > s2.length()) {
				return 1;
			}
			return 0;
		});
		
		// 2° forma de implementar comparator com Lambda
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		
		
		
		
		// 1. Implementando Consumer
		palavras.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});

		// 2. Implementando com Lambda 1° forma
		palavras.forEach((String s) -> {
			System.out.println(s);
		});

		// 3. Implementando com Lambda 2° forma
		palavras.forEach(s -> System.out.println(s));

	}
}
