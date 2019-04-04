package hr.java.vjezbe.metode;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;

public class UnosIntIzuzetak {
	public static int unosIntIzuzetak(Scanner unos, String ispis, Logger log) {
		
		boolean provjera = true;
		int uneseniBroj = 0;
		do {
			System.out.println(
					ispis);
			try {
				uneseniBroj = unos.nextInt();
				provjera = false;
				unos.nextLine();
			} catch (InputMismatchException iznimka) {
				log.error("Korisnik nije unio znamenku.");
				System.out.println("Niste unijeli znamenku.");
				unos.nextLine();
			}
		} while (provjera);
		return uneseniBroj;
	}
}
