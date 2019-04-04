package hr.java.vjezbe.tests;

import hr.java.vjezbe.entitet.Ispit;
import hr.java.vjezbe.entitet.Predmet;
import hr.java.vjezbe.entitet.Profesor;
import hr.java.vjezbe.entitet.Student;
import hr.java.vjezbe.glavna.Glavna;
import hr.java.vjezbe.metode.UnosDatuma;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PunjenjeBaze {

	public static void PunjenjeBaze(Profesor[] profArr, Student[] stuArr, Predmet[] preArr, Ispit[] ispiArr) {
		Profesor prof1 = new Profesor("P111", "Ivica", "Peric", "Viši predavaè");
		Profesor prof2 = new Profesor("P222", "Renato", "Maj", "Nisoki predavaè");
		profArr[0] = prof1;
		profArr[1] = prof2;
		Student stud1 = new Student("Luka", "Modriæ", "1999230322", UnosDatuma.dateInputZaPunjenjeBaze("13.02.1987"));
		Student stud2 = new Student("Margo", "Krešetiæ", "25787191414", UnosDatuma.dateInputZaPunjenjeBaze("13.02.1987"));
		stuArr[0] = stud1;
		stuArr[1] = stud2;
		Predmet pred1 = new Predmet("KK11", "Objektno upravljanje mobitelom", 5, prof1, stuArr);
		Predmet pred2 = new Predmet("KK33", "Sedamdesetdrugo svjetlo", 3, prof2, stuArr);
		preArr[0] = pred1;
		preArr[1] = pred2;
		LocalDateTime datum = UnosDatuma.dateTimeInputZaPunjenjeBaze("2018-12-12 12:23");
		Ispit ispit1 = new Ispit(pred1, stud1, 1, datum);
		Ispit ispit2 = new Ispit(pred2, stud2, 5, datum);
		ispiArr[0] = ispit1;
		ispiArr[1] = ispit2;
	}
}
