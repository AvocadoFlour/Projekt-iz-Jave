package hr.java.vjezbe.glavna;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.entitet.FakultetRacunarstva;
import hr.java.vjezbe.entitet.Ispit;
import hr.java.vjezbe.entitet.ObrazovnaUstanova;
import hr.java.vjezbe.entitet.Predmet;
import hr.java.vjezbe.entitet.Profesor;
import hr.java.vjezbe.entitet.Student;
import hr.java.vjezbe.entitet.VeleucilisteJave;
import hr.java.vjezbe.iznimke.PostojiViseNajmladjihStudenataException;
import hr.java.vjezbe.metode.UnosIntIzuzetak;
import hr.java.vjezbe.tests.PunjenjeBaze;
import hr.java.vjezbe.metode.UnosIntIzuzetak;

public class Glavna {

	private static final Logger log = LoggerFactory.getLogger(Glavna.class);
	private static final int BROJ_PROFESORA = 2;
	private static final int BROJ_PREDMETA = 2;
	private static final int BROJ_STUDENTA = 2;
	private static final int BROJ_ISPITNIH_ROKOVA = 2;

	public static void main(String[] args) {

		log.info("Program pokrenut.");

		Scanner unos = new Scanner(System.in);

		String stringUnosaBrojaObrazovnihUstanova = "Unesite broj obrazovnih ustanova";

		int brojObrazovnihUstanova = UnosIntIzuzetak.unosIntIzuzetak(unos, stringUnosaBrojaObrazovnihUstanova, log);

		ObrazovnaUstanova[] obrazovneUstanove = new ObrazovnaUstanova[brojObrazovnihUstanova];

		inicijalizacijaSvega(obrazovneUstanove, unos);

	}

	private static void inicijalizacijaSvega(ObrazovnaUstanova[] obrazovneUstanove, Scanner unos) {

		for (int i = 0; i < obrazovneUstanove.length; i++) {
			Profesor[] profArr = new Profesor[BROJ_PROFESORA];
			Student[] stuArr = new Student[BROJ_STUDENTA];
			Predmet[] preArr = new Predmet[BROJ_PREDMETA];
			Ispit[] ispiArr = new Ispit[BROJ_ISPITNIH_ROKOVA];

			System.out.println("Unesite podatke potrebne za stvaranje " + (i + 1) + ". obrazovne ustanove.");

//			for (int k = 0; k < BROJ_PROFESORA; k++) {
//				Profesor.unosProfesora(profArr, unos, k);
//			}
//
//			for (int k = 0; k < BROJ_PREDMETA; k++) {
//				Predmet.unesiPredmet(profArr, preArr, unos, k, log);
//			}
//
//			for (int k = 0; k < BROJ_STUDENTA; k++) {
//				Student.unosStudenta(stuArr, unos, k, log);
//			}
//
//			for (int k = 0; k < BROJ_ISPITNIH_ROKOVA; k++) {
//				Ispit.unosIspitnogRoka(stuArr, preArr, ispiArr, unos, k);
//			}

			PunjenjeBaze.PunjenjeBaze(profArr, stuArr, preArr, ispiArr);

			String stringOdabiraTipaUstanove = "Za stvaranje 'Veleuèilišta Jave' unesite 1, a za stvaranje 'Fakulteta Raèunalstva unesite 2";
			int odabir = UnosIntIzuzetak.unosIntIzuzetak(unos, stringOdabiraTipaUstanove, log);

			System.out.println("Unesite naziv obrazovne ustanove.");
			String nazivNoveObrazovneUstanove = unos.nextLine();
			if (odabir == 1) {
				VeleucilisteJave veleucilisteJave = new VeleucilisteJave(nazivNoveObrazovneUstanove, preArr, profArr,
						stuArr, ispiArr);
				obrazovneUstanove[i] = veleucilisteJave;
			} else if (odabir == 2) {
				FakultetRacunarstva fakultetRacunalstva = new FakultetRacunarstva(nazivNoveObrazovneUstanove, preArr,
						profArr, stuArr, ispiArr);
				obrazovneUstanove[i] = fakultetRacunalstva;
			}
			if (obrazovneUstanove[i] instanceof VeleucilisteJave) {
				VeleucilisteJave veleucilisteJave = (VeleucilisteJave) obrazovneUstanove[i];

				for (Student s : veleucilisteJave.getStudenti()) {
					Ispit[] ispitiStudenta = veleucilisteJave.filtrirajIspitePoStudentu(veleucilisteJave.getIspiti(),
							s);
					if (VeleucilisteJave.postojiLiJedinica(ispitiStudenta)) {
						System.out.println("Student " + s.getIme() + " " + s.getPrezime()
						+ " zbog negativne ocjene na jednom od ispita ima prosjek\n" + "„nedovoljan (1)“!");
					}
					else {
					System.out.println("Student: " + s.getIme() + " " + s.getPrezime());
					String porukaUnosaZavrsnogRada = "Unesite ocjenu završnog rada studenta: ";
					int ocjenaZavrsnogRaDA = UnosIntIzuzetak.unosIntIzuzetak(unos, porukaUnosaZavrsnogRada, log);
					String porukaUnosaObraneZavrsnogRada = "Unesite ocjenu obrane završnog rada studenta: ";
					int ocjenaObraneZavrsnogRada = UnosIntIzuzetak.unosIntIzuzetak(unos, porukaUnosaObraneZavrsnogRada,
							log);					
					BigDecimal konacnaOcjenaStudija = veleucilisteJave.izracunajKonacnuOcjenuStudijaZaStudenta(
							ispitiStudenta, ocjenaZavrsnogRaDA, ocjenaObraneZavrsnogRada);
					String konacnaOcjenaString = konacnaOcjenaStudija.toString();
					System.out.println("Konaèna ocjena studija studenta " + s.getIme() + " " + s.getPrezime() + " je "
							+ konacnaOcjenaString);
					}
				}
				Student najboljiStudentGodine = veleucilisteJave.odrediNajuspjesnijegStudentaNaGodini(2018);
				System.out.println("Najbolji student godine 2018 je " + najboljiStudentGodine.getIme() + " "
						+ najboljiStudentGodine.getPrezime());
			}

			else if (obrazovneUstanove[i] instanceof FakultetRacunarstva) {
				FakultetRacunarstva fakultetRacunalstva = (FakultetRacunarstva) obrazovneUstanove[i];
				for (Student s : fakultetRacunalstva.getStudenti()) {
					Ispit[] ispitiStudenta = fakultetRacunalstva
							.filtrirajIspitePoStudentu(fakultetRacunalstva.getIspiti(), s);
					if (FakultetRacunarstva.postojiLiJedinica(ispitiStudenta)) {
						System.out.println("Student " + s.getIme() + " " + s.getPrezime()
								+ " zbog negativne ocjene na jednom od ispita ima prosjek\n" + "„nedovoljan (1)“!");

					} else {
						System.out.println("Student: " + s.getIme() + " " + s.getPrezime());
						String porukaUnosaZavrsnogRada = "Unesite ocjenu završnog rada studenta: ";
						int ocjenaZavrsnogRaDA = UnosIntIzuzetak.unosIntIzuzetak(unos, porukaUnosaZavrsnogRada, log);
						String porukaUnosaObraneZavrsnogRada = "Unesite ocjenu obrane završnog rada studenta: ";
						int ocjenaObraneZavrsnogRada = UnosIntIzuzetak.unosIntIzuzetak(unos,
								porukaUnosaObraneZavrsnogRada, log);

						BigDecimal konacnaOcjenaStudija = fakultetRacunalstva.izracunajKonacnuOcjenuStudijaZaStudenta(
								ispitiStudenta, ocjenaZavrsnogRaDA, ocjenaObraneZavrsnogRada);
						String konacnaOcjenaString = konacnaOcjenaStudija.toString();
						System.out.println("Konaèna ocjena studija studenta " + s.getIme() + " " + s.getPrezime()
								+ " je " + konacnaOcjenaString);
					}
				}

				Student najboljiStudentGodine = fakultetRacunalstva.odrediNajuspjesnijegStudentaNaGodini(2018);
				System.out.println("Najbolji student godine je " + najboljiStudentGodine.getIme() + " "
						+ najboljiStudentGodine.getPrezime());
				try {
					Student rektorovStudent = fakultetRacunalstva.odrediStudentaZaRektorovuNagradu();
					System.out.println(
							"Rektorova nagrada " + rektorovStudent.getIme() + " " + rektorovStudent.getPrezime());
				} catch (PostojiViseNajmladjihStudenataException izuzetak) {
					log.error(izuzetak.getMessage());
				}
			}
		}
		unos.close();
	}
}