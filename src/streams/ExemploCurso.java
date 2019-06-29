package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
		
	}
}














