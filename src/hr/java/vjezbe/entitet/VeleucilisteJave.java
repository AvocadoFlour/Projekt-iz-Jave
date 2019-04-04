package hr.java.vjezbe.entitet;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hr.java.vjezbe.glavna.Glavna;
import hr.java.vjezbe.iznimke.NemoguceOdreditiProsjekStudentaException;

public class VeleucilisteJave extends ObrazovnaUstanova implements Visokoskolska {

	private static final Logger log = LoggerFactory.getLogger(Glavna.class);

	public VeleucilisteJave(String nazivUstanove, Predmet[] predmeti, Profesor[] profesori, Student[] studenti,
			Ispit[] ispiti) {
		super(nazivUstanove, predmeti, profesori, studenti, ispiti);
	}

	@Override
	public BigDecimal izracunajKonacnuOcjenuStudijaZaStudenta(Ispit[] ispitiStudenta, int pismeniDioZavrsnog,
			int ocjenaObraneZavrsnog) {

//		Konaèna ocjena = (2 * prosjek ocjena studenta + ocjena završnog rada + ocjena obrane završnog rada) / 4
		BigDecimal prosjekOcjenaNaIspitima = new BigDecimal(0);
		BigDecimal konacnaOcjenaStudijaZaStudenta = new BigDecimal(1);
		try {
			prosjekOcjenaNaIspitima = odrediProsjekOcjenaNaIspitima(ispitiStudenta); // prosjek ocjena studenta
			konacnaOcjenaStudijaZaStudenta = prosjekOcjenaNaIspitima.multiply(new BigDecimal(2));
//			2 * prosjek ocjena studenta
			konacnaOcjenaStudijaZaStudenta = konacnaOcjenaStudijaZaStudenta.add(new BigDecimal(pismeniDioZavrsnog));
//			( 2 * prosjek ocjenastudenta) + pismeniDioZavrsnog
			konacnaOcjenaStudijaZaStudenta = konacnaOcjenaStudijaZaStudenta.add(new BigDecimal(ocjenaObraneZavrsnog));
//			 2 * prosjek ocjena studenta) + pismeniDioZavrsnog + ocjenaObraneZavrsnog
			konacnaOcjenaStudijaZaStudenta = konacnaOcjenaStudijaZaStudenta.divide(new BigDecimal(4));
//			(2 * prosjek ocjena studenta + ocjena završnog rada + ocjena obrane završnog rada) / 4
		} catch (NemoguceOdreditiProsjekStudentaException izuzetak) {
			log.error(izuzetak.getMessage());
			System.out.println("Student " + ispitiStudenta[0].getStudent().getIme() + " "
					+ ispitiStudenta[0].getStudent().getPrezime()
					+ " zbog negativne ocjene na jednom od ispita ima prosjek 'nedovoljan (1)'!");
		}
		return konacnaOcjenaStudijaZaStudenta;
	}

	@Override
	public Student odrediNajuspjesnijegStudentaNaGodini(int godina) {
//		prvo trebamo dobiti sve ispite iz unesene godine
//		potom treba filtrirati ispite po studentima
//		te potom treba izraèunati prosjek ispita svih studenata
		ArrayList<Integer> indexPripadajucihIspita = new ArrayList<Integer>();
		int counter = 0;
		int counterVelicineArraya = 0;
		for (Ispit i : this.getIspiti()) {
			if (i.getDatumIVrijeme().getYear() == godina) {
				indexPripadajucihIspita.add(counter);
				counter += 1;
				counterVelicineArraya += 1;
			} else {
				counter += 1;
			}
		}
		counter = 0;
		Ispit[] ispitiOdabraneGodine = new Ispit[counterVelicineArraya];

		for (int i : indexPripadajucihIspita) {
			ispitiOdabraneGodine[counter] = this.getIspiti()[i];
			counter += 1;
		}
//	    Array sa svim ispitima iz odreðene godine popunjen ispitima te odreðene godine; "ispitiOdabraneGodine"

		Student studentSNajvecimProsjekom = null;
		BigDecimal najveciProsjek = new BigDecimal(-1);
		for (Student s : this.getStudenti()) {
			BigDecimal potencijalniNoviNajboljiProsjek = new BigDecimal(0);
			Ispit[] ispitiStudenta = Visokoskolska.super.filtrirajIspitePoStudentu(ispitiOdabraneGodine, s);
			try {
				potencijalniNoviNajboljiProsjek = Visokoskolska.super.odrediProsjekOcjenaNaIspitima(ispitiStudenta);
			} catch (NemoguceOdreditiProsjekStudentaException iznimka) {
				log.error(iznimka.getMessage());
				System.out.println("Student " + s.getIme() + " " + s.getPrezime()
						+ " zbog negativne ocjene na jednom od ispita ima prosjek 'nedovoljan (1)'!");
			}

			if (potencijalniNoviNajboljiProsjek.compareTo(najveciProsjek) == 1) {
				najveciProsjek = potencijalniNoviNajboljiProsjek;
				studentSNajvecimProsjekom = s;
			} else if (potencijalniNoviNajboljiProsjek.compareTo(najveciProsjek) == 0) {
				najveciProsjek = potencijalniNoviNajboljiProsjek;
				studentSNajvecimProsjekom = s;
			}
		}
		return studentSNajvecimProsjekom;

	}

}