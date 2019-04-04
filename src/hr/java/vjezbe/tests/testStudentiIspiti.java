package hr.java.vjezbe.tests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import hr.java.vjezbe.entitet.Ispit;
import hr.java.vjezbe.entitet.Predmet;
import hr.java.vjezbe.entitet.Profesor;
import hr.java.vjezbe.entitet.Student;

public class testStudentiIspiti {

	Student[] stuArr = new Student[2];

	public static void lijepo() {
		LocalDate datum1 = LocalDate.of(1993, 8, 20);
		Student student1 = new Student("Tomislav", "Stipiæ", "12512515", datum1);

		LocalDate datum2 = LocalDate.of(1965, 1, 11);
		Student student2 = new Student("Marko", "Mešioæ", "536546712357635", datum2);
		Student stud1 = new Student("Luka", "Modric", "1999230322", datum1);
		Student stud2 = new Student("Margo", "Krešetiæ", "25787191414", datum2);
		Student[] stuArr0 = new Student[2];
		stuArr0[0] = stud1;
		stuArr0[1] = stud2;
		Profesor profesor1 = new Profesor("532515", "Marko", "Italija", "Profesor");
		Profesor profesor2 = new Profesor("086455", "Trek", "Drek", "The Bare");

		Predmet predmet1 = new Predmet("34526246", "Odjevanje obuæe 13", 7, profesor1, stuArr0);
		Predmet predmet2 = new Predmet("96078894", "Meksièki specijaliteti", 3, profesor2, stuArr0);

		LocalDateTime datum3 = LocalDateTime.of(2001, 2, 23, 4, 34);
		Ispit ispit1 = new Ispit(predmet1, student1, 5, datum3);
		LocalDateTime datum4 = LocalDateTime.of(2043, 5, 1, 5, 00);
		Ispit ispit2 = new Ispit(predmet1, student2, 5, datum4);
		LocalDateTime datum5 = LocalDateTime.of(2043, 5, 1, 5, 00);
		Ispit ispit3 = new Ispit(predmet2, student1, 5, datum5);

		Ispit[] ispiti = new Ispit[3];
		ispiti[0] = ispit1;
		ispiti[1] = ispit2;
		ispiti[2] = ispit3;

		ArrayList<Integer> indexPripadajucihIspita = new ArrayList<Integer>();
		int counterOfPripadajuæihIspita = 0;
		int counterOfForLoopExecutions = 0;
		for (Ispit i : ispiti) {
			if (i.getStudent() == student1) {
				indexPripadajucihIspita.add(counterOfForLoopExecutions);
				counterOfPripadajuæihIspita += 1;
				counterOfForLoopExecutions += 1;
			} else {
				counterOfForLoopExecutions += 1;
			}
		}
		Ispit[] pripadajuciIspiti = new Ispit[counterOfPripadajuæihIspita];
		counterOfForLoopExecutions = 0;
		System.out.println(indexPripadajucihIspita + " INDEX");
		for (int i : indexPripadajucihIspita) {
			pripadajuciIspiti[counterOfForLoopExecutions] = ispiti[indexPripadajucihIspita
					.get(counterOfForLoopExecutions)];
			counterOfForLoopExecutions += 1;
		}
//		for (Ispit i : pripadajuciIspiti) {
//			System.out.println(i.getDatumIVrijeme() + i.getPredmet().getNaziv() + " REZULTAT");
//		}

	}
}
