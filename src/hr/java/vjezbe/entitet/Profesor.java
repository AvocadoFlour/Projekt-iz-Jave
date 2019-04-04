package hr.java.vjezbe.entitet;

import java.util.Scanner;

public class Profesor extends Osoba {
	private String sifra;
	private String titula;

	/**
	 * Služi za stvaranje jednog objekta tipa "Profesor" uzimajuæi parametre za
	 * šifru, ime, prezime i titulu tog profesora.
	 * 
	 * @param sifra
	 * @param ime
	 * @param prezime
	 * @param titula
	 */
	public Profesor(String sifra, String ime, String prezime, String titula) {
		super(ime, prezime);
		this.sifra = sifra;
		this.titula = titula;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}
	
	

	/**
	 * Metoda koja služi za dodavanje novog objekta u polje objekata tipa "Profesor".
	 * 
	 * @param profArr
	 * @param unos
	 * @param i
	 */
	public static void unosProfesora(Profesor[] profArr, Scanner unos, int i) {
		System.out.print("\n Unijeti sifru " + (i + 1) + ". profesora: ");
		String sifra = unos.nextLine();
		System.out.print("\n Unijeti ime " + (i + 1) + ". profesora: ");
		String ime = unos.nextLine();
		System.out.print("\n Unijeti prezime " + (i + 1) + ". profesora: ");
		String prezime = unos.nextLine();
		System.out.print("\n Unijeti titulu " + (i + 1) + ". profesora: ");
		String titula = unos.nextLine();
		Profesor prof = new Profesor(sifra, ime, prezime, titula);
		profArr[i] = prof;
	}

	/**
	 * Metoda koja služi za pregledno ispisivanje varijabli "ime" i "prezime" svih objekata koje sadrži dano polje objekata tipa "Profesor"F
	 * 
	 * @param profArr
	 */
	public static void ispisProfesora(Profesor[] profArr) {
		System.out.println("\n" + "Profesori koji postoje su");
		int brojacIspisaProfesora = 0;
		for (Profesor p : profArr) {
			brojacIspisaProfesora += 1;
			System.out.println("\n" + brojacIspisaProfesora + ". profesor je: " + p.getIme() + " " + p.getPrezime());

		}

	}
}
