package datas;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
	
	public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		
		LocalDate olimpiadasToquio = LocalDate.of(2020, Month.JUNE, 5);
		int anos = olimpiadasToquio.getYear() - hoje.getYear();
		System.out.println(anos);
		
		// entre
		Period periodo = Period.between(hoje, olimpiadasToquio);
		System.out.println(periodo.getDays());
		
		
		LocalDate proximaOlimpiada = olimpiadasToquio.plusYears(4);
		System.out.println(proximaOlimpiada);
		
		// formatação
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String novaData = proximaOlimpiada.format(formatador);
		System.out.println(novaData);
		
		
	}
}

























