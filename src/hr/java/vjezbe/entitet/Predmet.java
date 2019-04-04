package hr.java.vjezbe.entitet;

import java.util.Scanner;

import org.slf4j.Logger;

import hr.java.vjezbe.metode.UnosIntIzuzetak;

/**
 * @author Gandeloft
 *
 */
public class Predmet {

	private String sifra;
	private String naziv;
	private int brojEctsBodova;
	private Profesor nositelj;
	private Student[] stuArr;

	/**
	 * Služi za kreiranje objekta klase "Predmer" koji sadrži definirane parametre:
	 * Šifra predmeta, naziv predmeta, broj ECTS bodova koje predmet nosi, objekt
	 * klase "Profesor" koji predstavlja nositelja predmeta, te polje objekta tipa
	 * "Student" koje sadrži sve studente koji pohaðaju taj predmet *
	 * 
	 * @param sifra
	 * @param naziv
	 * @param brojEctsBodova
	 * @param nositelj
	 * @param stuArr
	 */
	public Predmet(String sifra, String naziv, int brojEctsBodova, Profesor nositelj, Student[] stuArr) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.brojEctsBodova = brojEctsBodova;
		this.nositelj = nositelj;
		this.stuArr = stuArr;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getBrojEctsBodova() {
		return brojEctsBodova;
	}

	public void setBrojEctsBodova(int brojEctsBodova) {
		this.brojEctsBodova = brojEctsBodova;
	}

	public Profesor getNositelj() {
		return nositelj;
	}

	public void setNositelj(Profesor nositelj) {
		this.nositelj = nositelj;
	}

	public Student[] getStuArr() {
		return stuArr;
	}

	public void setStuArr(Student[] stuArr) {
		this.stuArr = stuArr;
	}

	/**
	 * Metoda koja služi za atomsko stvaranje objekta tipa "Predmet". Prima polje
	 * objekata tipa "Profesor" iz kojega æe se izvuæi moguæi objekti tipa
	 * "Profesor" da budu odabrani kao "nositelj" novokreiranog objekta, te polje
	 * objekata tipa "Predmet" kako bi se u konaènici u to polje mogao i pohraniti
	 * novostvoreni objekt. Pod atomsko stvaranje se želi reæi da se omoguæuje
	 * stvaranje svih potrebnih resursa za stvaranje jednog objekta tipa "Predmet"
	 * unutar ove metode.
	 * 
	 * @param profArr
	 * @param preArr
	 * @param unos
	 * @param i
	 * @param log
	 */
	public static void unesiPredmet(Profesor[] profArr, Predmet[] preArr, Scanner unos, int i, Logger log) {
		System.out.print("\n Unijeti sifru " + (i + 1) + ". predmeta: ");
		String sifra = unos.next();
		System.out.print("\n Unijeti naziv " + (i + 1) + ". predmeta: ");
		String naziv = unos.next();
		StringBuilder porukaUnosaECTSBodova = new StringBuilder("\n Unijeti ECTS bodove ").append(i + 1)
				.append(". predmeta: ");
		int ects = UnosIntIzuzetak.unosIntIzuzetak(unos, porukaUnosaECTSBodova.toString(), log);
		System.out.print("\n Odabrati profesora nositelja predmeta unosom rednog broja profesora: ");
		int brojacZaIspisivanjeProf = 0;
		StringBuilder profesorIPripadajuæiRedniBroj = new StringBuilder("");
		for (Profesor p : profArr) {
			brojacZaIspisivanjeProf += 1;
			profesorIPripadajuæiRedniBroj
					.append("\n " + brojacZaIspisivanjeProf + ". Profesor: " + p.getIme() + " " + p.getPrezime());
		}
		int redniBrojProfesora = UnosIntIzuzetak.unosIntIzuzetak(unos, profesorIPripadajuæiRedniBroj.toString(), log);

		Profesor nositelj = profArr[redniBrojProfesora - 1];
		String unosStudenataUPredmetu = "\n Unesite koliko studenata pohada predmet";
		int brojStudenataUPredmetu = UnosIntIzuzetak.unosIntIzuzetak(unos, unosStudenataUPredmetu, log);
		Student[] studentiPredmetArr = new Student[brojStudenataUPredmetu];
		Predmet pred = new Predmet(sifra, naziv, ects, nositelj, studentiPredmetArr);
		preArr[i] = pred;
	}

	/**
	 * Služi za izlistavanje svih predmeta i studenata koji pohaðaju svaki predmet
	 * iz polj objekata tipa "Predmet" koje je metodi dano.
	 * 
	 * @param preArr
	 */
	public static void ispisPredmeta(Predmet[] preArr) {
		System.out.println("\n Predmeti koji postoje su");
		int brojacIspisaPredmeta = 0;
		for (Predmet p : preArr) {
			brojacIspisaPredmeta += 1;
			System.out.println("\n" + brojacIspisaPredmeta + ". predmet je: " + p.getNaziv());

			int brojacIspisaStudenataUP = 0;
			if (p.getStuArr()[brojacIspisaStudenataUP] != null) {
				System.out.println("Studenti upisani na predmet su: ");
			}
			for (Student s : p.getStuArr()) {
				while (p.getStuArr()[brojacIspisaStudenataUP] != null) {
					brojacIspisaStudenataUP += 1;
					System.out.println(brojacIspisaStudenataUP + ". " + s.getIme() + " " + s.getPrezime());
				}
			}
		}
	}

}
