package hr.java.vjezbe.entitet;

import java.awt.List;
import java.math.BigDecimal;
//import java.math.RoundingMode;
import java.util.ArrayList;

import hr.java.vjezbe.iznimke.NemoguceOdreditiProsjekStudentaException;

public interface Visokoskolska {
	public BigDecimal izracunajKonacnuOcjenuStudijaZaStudenta(Ispit[] ispitiStudenta, int pismeniDioZavrsnog,
			int ocjenaObraneZavrsnog);
	

	default BigDecimal odrediProsjekOcjenaNaIspitima(Ispit[] ispiti) throws NemoguceOdreditiProsjekStudentaException {
		double brojac = 0;
		int zbroj = 0;
		for (Ispit i : ispiti) {
			if (i != null) {
				brojac += 1;
				if (i.getOcjena() == 1) {
					throw new NemoguceOdreditiProsjekStudentaException(
							"Ispitna ocijena jedan na ispitu iz " + i.getPredmet().getNaziv() + " studenta "
									+ i.getStudent().getIme() + " " + i.getStudent().getPrezime());
				}
				else if (i.getOcjena() >= 1 || i.getOcjena() < 6) {
					zbroj = zbroj + i.getOcjena();
				}
			}
		}
//		System.out.println("ZBROJ: " + zbroj + " , BROJAC " + brojac);

//		https://stackoverflow.com/questions/22609217/rounding-bigdecimal-values-with-2-decimal-places  -- DEPRECIATED
//		https://stackoverflow.com/questions/47268003/deprecated-constructor-for-bigdecimal-setscaleint-int-and-roundingmode-enums  -- UPDATED
		BigDecimal prosjek = new BigDecimal(zbroj / brojac);

//		Zaokruživanje BigDecimal na dvije brojke
//		prosjek = prosjek.setScale(2, RoundingMode.HALF_EVEN);  	

		return prosjek;
	};

	private Ispit[] filtrirajPolozeneIspite(Ispit[] ispArr) {
		int counter = 0;
		for (Ispit i : ispArr) {
			if (i.getOcjena() > 1)
				counter += 1;
		}
		int counter1 = 0;
		Ispit[] polozeniIspiti = new Ispit[counter];
		for (Ispit i : ispArr) {
			if (i.getOcjena() > 1) {
				polozeniIspiti[counter1] = i;
				counter1 += 1;
			}
		}
		return polozeniIspiti;
	}

	default Ispit[] filtrirajIspitePoStudentu(Ispit[] ispiti, Student student) {
		ArrayList<Integer> indexPripadajucihIspita = new ArrayList<Integer>();
		int counterOfPripadajucihIspita = 0;
		int counterOfForLoopExecutions = 0;
		for (Ispit i : ispiti) {
			if (i.getStudent() == student) {
				indexPripadajucihIspita.add(counterOfForLoopExecutions);
				counterOfPripadajucihIspita += 1;
				counterOfForLoopExecutions += 1;
			} else {
				counterOfForLoopExecutions += 1;
			}
		}
		Ispit[] pripadajuciIspiti = new Ispit[counterOfPripadajucihIspita];
		counterOfForLoopExecutions = 0;
		for (int i : indexPripadajucihIspita) {
			pripadajuciIspiti[counterOfForLoopExecutions] = ispiti[i];
			counterOfForLoopExecutions += 1;
		}
		return pripadajuciIspiti;
	}
}