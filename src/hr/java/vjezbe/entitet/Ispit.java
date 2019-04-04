package hr.java.vjezbe.entitet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.glavna.Glavna;
import hr.java.vjezbe.metode.UnosDatuma;

/**
 * @author Gandeloft
 *
 */
public class Ispit {

	private static final Logger log = LoggerFactory.getLogger(Glavna.class);
	private Predmet predmet;
	private Student student;
	private Integer ocjena;
	private LocalDateTime datumIVrijeme;

	/**
	 * Služi za stvaranje objekta tipa "Ispit" primajuæi objekt tipa predmet a
	 * temelju kojega se objektu definira o kojem predmetu je rijeè, prima objekt
	 * tipa student koje govori o kojem je studentu rijeè, o polju ocjena u koje se
	 * sprema ocjena ostvarena na ispitu te datum i vrijeme održavanja ispita.
	 * 
	 * @param predmet       predmet ispita
	 * @param student       student koji je pisao ispit
	 * @param ocjena        ocjena koju je student ostvario
	 * @param datumIVrijeme datum i vrijeme održavanja roka
	 */
	public Ispit(Predmet predmet, Student student, Integer ocjena, LocalDateTime datumIVrijeme) {
		super();
		this.predmet = predmet;
		this.student = student;
		this.ocjena = ocjena;
		this.datumIVrijeme = datumIVrijeme;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getOcjena() {
		return ocjena;
	}

	public void setOcjena(Integer ocjena) {
		this.ocjena = ocjena;
	}

	public LocalDateTime getDatumIVrijeme() {
		return datumIVrijeme;
	}

	public void setDatumIVrijeme(LocalDateTime datumIVrijeme) {
		this.datumIVrijeme = datumIVrijeme;
	}

	/**
	 * Atomska metoda za stvaranje novih objekata tipa ispit. Prima polje objekata
	 * tipa "Student", polje objekata tipa "Predmet" i polje objekata tipa "Ispit". Takoðer prima i jedan objekt tipa skener koji služi unos.
	 * 
	 * 
	 * @param stuArr polje objekata tipa "Student" koje služi za odabir studenta o kojem je rijeè
	 * @param preArr prima polje objekada tipa "Predmet" koje služi za odabir predmeta ispitnog roka
	 * @param ispiArr polje objekata tipa "Ispit" u koje æe se spremiti novostvoreni ispit
	 * @param unos unos podataka sa korisnikove stranje
	 * @param i brojaè o kojem je predmetu rijeè
	 */
	public static void unosIspitnogRoka(Student[] stuArr, Predmet[] preArr, Ispit[] ispiArr, Scanner unos, int i) {
		System.out.println("Odaberite predmet " + (i + 1) + ". ispitnog roka upisom rednog broja predmeta");
		int counterProfesori = 0;
		for (Predmet x : preArr) {
			System.out.println((counterProfesori + 1) + ". predmet je: " + preArr[counterProfesori].getNaziv());
			counterProfesori += 1;
		}
		int indexPredmeta = unos.nextInt() - 1; // Služiti æe za dodavanje studenta u predmet u èijem je ispitu
												// sudjelovao
		Predmet pred = preArr[indexPredmeta];

		System.out.println("Oudaberite studenta: ");
		int counterStudenti = 0;
		for (Student y : stuArr) {
			System.out.println((counterStudenti + 1) + ". " + stuArr[counterStudenti].getIme() + " "
					+ stuArr[counterStudenti].getPrezime());
			counterStudenti += 1;
		}
		int indexStudenta = unos.nextInt() - 1; // Služiti æe za dodavanje studenta u predmet u èijem je ispitu
												// sudjelovao
		Student stud = stuArr[indexStudenta];
		preArr[indexPredmeta].getStuArr();
//		https://stackoverflow.com/questions/25918532/adding-an-element-to-the-first-empty-arrays-index
		for (int j = 0; j < preArr[indexPredmeta].getStuArr().length; j++)
			if (preArr[indexPredmeta].getStuArr()[j] == null) {
				preArr[indexPredmeta].getStuArr()[j] = stuArr[indexStudenta];
				break;
			}
		System.out.println("Unesite ocjenu na ispitu (1-5):");
		int ocjenaNaIspitu = unos.nextInt();

		while (ocjenaNaIspitu < 1 || ocjenaNaIspitu > 5) {
			System.out.println("Unesena ocjena nije istina, molimo.");
			ocjenaNaIspitu = unos.nextInt();
		}
//			https://stackoverflow.com/questions/22463062/how-to-parse-format-dates-with-localdatetime-java-8
		LocalDateTime datum = UnosDatuma.dateTimeInput(unos, log);
		ispiArr[i] = new Ispit(pred, stud, ocjenaNaIspitu, datum);
		if (ocjenaNaIspitu == 5) {
			System.out.println("Student " + stud.getIme() + " " + stud.getPrezime()
					+ " je ostvario ocjenu 'izvrstan' na predmetu '" + pred.getNaziv() + "'.");
		}
		System.out.println("");
	}

}
