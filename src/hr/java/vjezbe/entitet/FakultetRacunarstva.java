package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.glavna.Glavna;
import hr.java.vjezbe.iznimke.NemoguceOdreditiProsjekStudentaException;
import hr.java.vjezbe.iznimke.PostojiViseNajmladjihStudenataException;

/**
 * 
 * @author Gandeloft
 *
 */
public class FakultetRacunarstva extends ObrazovnaUstanova implements Diplomski {

	private static final Logger log = LoggerFactory.getLogger(Glavna.class);

	/**
	 * Služi za stvaranje objekta tipa "FakultetRacunarstva" koji sadrži naziv
	 * ustanove, polje objekata tipa "Predmet" koje sadrži sve predmete tog objekta,
	 * polje objekata tipa "Profesor" koje sadrži sve profesore tog objekta, polje
	 * objekata tipa "Student" koje sadrži sve studente tog objekta te polje objekata tipa "Ispit" koje sadrži sve ispite tog objekta.
	 * 
	 * @param nazivUstanove naziv ustanove
	 * @param predmeti predmeti koje ustanova sadrži
	 * @param profesori profesori ustanove
	 * @param studenti studenti ustanove
	 * @param ispiti ispiti ustanove
	 */
	public FakultetRacunarstva(String nazivUstanove, Predmet[] predmeti, Profesor[] profesori, Student[] studenti,
			Ispit[] ispiti) {
		super(nazivUstanove, predmeti, profesori, studenti, ispiti);
	}
	
	

	/* (non-Javadoc)
	 * @see hr.java.vjezbe.entitet.Visokoskolska#izracunajKonacnuOcjenuStudijaZaStudenta(hr.java.vjezbe.entitet.Ispit[], int, int)
	 */
	@Override
	public BigDecimal izracunajKonacnuOcjenuStudijaZaStudenta(Ispit[] ispiti, int ocjenaDiplomskogRada,
			int ocjenaObraneDiplomskogRada) {
		BigDecimal prosjekOcjenaNaIspitima = new BigDecimal(0);
		BigDecimal konacnaOcjenaStudijaZaStudenta = new BigDecimal(1);
		try {
			prosjekOcjenaNaIspitima = odrediProsjekOcjenaNaIspitima(ispiti); // prosjek ocjena studenta
			konacnaOcjenaStudijaZaStudenta = prosjekOcjenaNaIspitima.multiply(new BigDecimal(3));
//			3 * prosjekOcjenaNaIspitima
			konacnaOcjenaStudijaZaStudenta = konacnaOcjenaStudijaZaStudenta.add(new BigDecimal(ocjenaDiplomskogRada));
//			(3 * prosjekOcjenaNaIspitima) + ocjenaDiplomskogRada
			konacnaOcjenaStudijaZaStudenta = konacnaOcjenaStudijaZaStudenta
					.add(new BigDecimal(ocjenaObraneDiplomskogRada));
//			(3 * prosjekOcjenaNaIspitima) + ocjenaDiplomskogRada + ocjenaObraneDiplomskogRada
			konacnaOcjenaStudijaZaStudenta = konacnaOcjenaStudijaZaStudenta.divide(new BigDecimal(5));
//			((3 * prosjekOcjenaNaIspitima) + ocjenaDiplomskogRada + ocjenaObraneDiplomskogRada) / 5
		} catch (NemoguceOdreditiProsjekStudentaException iznimka) {
			log.error(iznimka.getMessage());
		}
		return konacnaOcjenaStudijaZaStudenta;
	}

	/* (non-Javadoc)
	 * @see hr.java.vjezbe.entitet.Diplomski#odrediStudentaZaRektorovuNagradu()
	 */
	@Override
	public Student odrediStudentaZaRektorovuNagradu() {
		Student studentSNajvecimProsjekom = null;
		BigDecimal najveciProsjek = new BigDecimal(-1);
		for (Student s : this.getStudenti()) {
			BigDecimal prosjekStudenta = new BigDecimal(0);
			Ispit[] ispitiStudenta = Diplomski.super.filtrirajIspitePoStudentu(this.getIspiti(), s);
			try {
				prosjekStudenta = odrediProsjekOcjenaNaIspitima(ispitiStudenta);
			} catch (NemoguceOdreditiProsjekStudentaException izuzetak) {
				log.error(izuzetak.getMessage());
				System.out.println("Student " + s.getIme() + " " + s.getPrezime()
						+ " zbog negativne ocjene na jednom od ispita ima prosjek 'nedovoljan (1)'!");
			}
			if (prosjekStudenta.compareTo(najveciProsjek) == 1) {
				najveciProsjek = prosjekStudenta;
				studentSNajvecimProsjekom = s;
			} else if (prosjekStudenta.compareTo(najveciProsjek) == 0) {
				odrediNajmladegStudenta(studentSNajvecimProsjekom, s);
			}
		}
		return studentSNajvecimProsjekom;
	}

	/**
	 * Vraæa objekt tipa "Student" provjeravajuæi koji od dva dana objekta tipa "Student" ima veæi datum roðenja, odnosno je mlaði.
	 * Prima dva parametra tipa "Student".
	 * Metoda sadrži checked izuzetak do kojega dolazi kada su datumi oba objekta tipa "Student" sa kojima se radi jednaki.
	 * 
	 * @param studentSNajvecimProsjekom
	 * @param studentSIstimProsjekom
	 * @return
	 * @throws PostojiViseNajmladjihStudenataException
	 */
	public Student odrediNajmladegStudenta(Student studentSNajvecimProsjekom, Student studentSIstimProsjekom)
			throws PostojiViseNajmladjihStudenataException {
		if (studentSIstimProsjekom.getDatumRodjenja().getYear() > studentSNajvecimProsjekom.getDatumRodjenja()
				.getYear()) {
			studentSNajvecimProsjekom = studentSIstimProsjekom;
		} else if (studentSIstimProsjekom.getDatumRodjenja().getYear() == studentSNajvecimProsjekom.getDatumRodjenja()
				.getYear()) {
			if (studentSIstimProsjekom.getDatumRodjenja().getDayOfYear() > studentSNajvecimProsjekom.getDatumRodjenja()
					.getDayOfYear()) {
				studentSNajvecimProsjekom = studentSIstimProsjekom;

			} else if (studentSIstimProsjekom.getDatumRodjenja().getDayOfYear() == studentSNajvecimProsjekom
					.getDatumRodjenja().getDayOfYear()) {
				System.out.println("Pronaðeno je više najmlaðih studenata s istim datumom roðenja, a to su: "
						+ studentSIstimProsjekom.getIme() + " " + studentSIstimProsjekom.getPrezime() + " i "
						+ studentSNajvecimProsjekom.getIme() + " " + studentSNajvecimProsjekom.getPrezime() + ".");
				;
				throw new PostojiViseNajmladjihStudenataException(
						"Studenti koji djele najbolji prosjek su roðeni na isti datum.");
			}
		}
		return studentSNajvecimProsjekom;
	}

	/* (non-Javadoc)
	 * @see hr.java.vjezbe.entitet.ObrazovnaUstanova#odrediNajuspjesnijegStudentaNaGodini(int)
	 */
	@Override
	public Student odrediNajuspjesnijegStudentaNaGodini(int godina) {
		ArrayList<Integer> indexPripadajucihIspita = new ArrayList<Integer>();
		int counterIspitaUGodiniUkupno = 0;
		int counterIspitaUGodiniIndexMjestaUListiKlase = 0;
		Student studentSNajvisePetica = null;
		for (Ispit ispit : this.getIspiti()) {
			if (ispit.getDatumIVrijeme().getYear() == godina) {
				indexPripadajucihIspita.add(counterIspitaUGodiniIndexMjestaUListiKlase);
				counterIspitaUGodiniUkupno += 1;
				counterIspitaUGodiniIndexMjestaUListiKlase += 1;
			} else {
				counterIspitaUGodiniIndexMjestaUListiKlase += 1;
			}
		}
		Ispit[] ispitiStudenataUJednojGodini = new Ispit[counterIspitaUGodiniUkupno];
		for (int i = 0; i < counterIspitaUGodiniUkupno; i++) {
			ispitiStudenataUJednojGodini[i] = this.getIspiti()[indexPripadajucihIspita.get(i)];
		}

		int counterPeticaMax = 0;
		for (Student s : this.getStudenti()) {
			Ispit[] ispitiStudenta = Diplomski.super.filtrirajIspitePoStudentu(ispitiStudenataUJednojGodini, s);
			int counterPetica = 0;
			for (Ispit i : ispitiStudenta) {
				if (i.getOcjena() == 5) {
					counterPetica += 1;
				}
			}
			if (counterPetica > counterPeticaMax) {
				studentSNajvisePetica = s;
				counterPeticaMax = counterPetica;
				counterPetica = 0;
			} else {
				counterPetica = 0;
			}
		}
		return studentSNajvisePetica;
	}

}
