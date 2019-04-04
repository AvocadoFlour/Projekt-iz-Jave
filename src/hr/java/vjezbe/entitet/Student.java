package hr.java.vjezbe.entitet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.slf4j.Logger;

import hr.java.vjezbe.metode.UnosDatuma;

public class Student extends Osoba {
	
	private String jmbag;
	private LocalDate datumRodjenja;
	
	public Student(String ime, String prezime, String jmbag, LocalDate datumRodjenja) {
		super(ime, prezime);
		this.jmbag = jmbag;
		this.datumRodjenja = datumRodjenja;
	}

	public String getJmbag() {
		return jmbag;
	}
	public void setJmbag(String jmbag) {
		this.jmbag = jmbag;
	}
	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
		
	public static void unosStudenta(Student[] stuArr, Scanner unos, int i, Logger log) {
		System.out.print("\n Unijeti ime " + (i + 1) + ". studenta: ");
		String ime = unos.nextLine();
		System.out.print("\n Unijeti prezime " + (i + 1) + ". studenta: ");
		String prezime = unos.nextLine();
		System.out.print("\n Unijeti JMBAG " + (i + 1) + ". studenta: ");
		String jmbag = unos.nextLine();
		StringBuilder graditeljStringa = new StringBuilder();
		graditeljStringa.append("\n Unijeti datum roïjenja " + (i + 1) + ". studenta u formatu 'dd.MM.yyyy': ");
		LocalDate datum = UnosDatuma.dateInput(graditeljStringa.toString(), unos, log);
		Student stu = new Student(ime, prezime, jmbag, datum);
		stuArr[i] = stu;
	}
		
	public static void ispisStudenata(Student[] stuArr) {
		System.out.println("\n Studenti koji postoje su");
		int brojacIspisaStudenata = 0;
		for (Student s : stuArr) {
			brojacIspisaStudenata += 1;
			System.out.println("\n" + brojacIspisaStudenata + ". student je: " + s.getIme() + " " + s.getPrezime());
		}
	}
	
}
