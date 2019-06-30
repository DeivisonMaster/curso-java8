package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Curso {
	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}
	
	public String getNome() {
		return nome;
	}
	public int getAlunos() {
		return alunos;
	}
}


public class ExemploCurso{
	
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>();
		
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("Javascript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		//cursos.sort(Comparator.comparing(c -> c.getAlunos()));
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
		//cursos.forEach(System.out::println);    não retorna toString()
		
		
		// Pesquisa por cursos com mais de 100 alunos
		
		Stream<Curso> stream = cursos.stream();
			stream.filter(c -> c.getAlunos() >= 100)
			.forEach(c -> System.out.println(c.getNome()));
		
			
		System.out.println("******************");
			
		// Pesquisa por quantidade de alunos em cada curso 
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.map(c -> c.getAlunos())
			.forEach(System.out::println);
		
		
		// equivalente
		for (Curso curso : cursos) {
			if(curso.getAlunos() >= 100) {
				System.out.println(curso.getAlunos());
			}
		}
		
		System.out.println("******************");
		
		
		// Pesquisa por quantidade de alunos em cada curso e soma essa quantidade 
		
		int soma = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.mapToInt(Curso::getAlunos)
			.sum();
		
		System.out.println(soma);
		
		
		/* Pesquisar por um curso que tem mais de 100 alunos
		 * 
		 * Optional = permite trabalhar com valores Null onde neste caso
		 * pode ser que o curso exista ou não exista
		 * 
		 * */
		Optional<Curso> optional = cursos.stream()
			.filter(c -> c.getAlunos() > 100)
			.findAny();
		
		
		
		Curso curso = optional.orElse(null);
		System.out.println(curso.getNome());
		
		
		// retorna um valor se atender à condição
		cursos.stream()
		.filter(c -> c.getAlunos() > 100)
		.findAny()
		.ifPresent(c -> System.out.println(c.getNome()));
		
		
		// OptionalDouble - obtem a média
		OptionalDouble media = cursos.stream()
		.filter(c -> c.getAlunos() > 100)
		.mapToInt(Curso::getAlunos)
		.average();
		
		
		// Retornando o valor de stream manipulada para uma List
		List<Curso> resultado = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toList());
	}
}














