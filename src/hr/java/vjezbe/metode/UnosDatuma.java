package hr.java.vjezbe.metode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import org.slf4j.Logger;

public class UnosDatuma {

	// https://stackoverflow.com/questions/42522744/taking-input-using-localdate
	public static LocalDate dateInput(String poruka, Scanner unos, Logger log) {
		boolean provjera = true;
		LocalDate datum = LocalDate.now();
		String korisnikovUnos = "";
		do {
			System.out.println(poruka);
			try {
				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d.M.yyyy");
				korisnikovUnos = unos.nextLine();
				datum = LocalDate.parse(korisnikovUnos, dateFormat);
				provjera = false;
			} catch (DateTimeParseException izuzetak) {
				log.error("Korisnik nije unio datum u definiranom formatu. Korisnikov unos: " + korisnikovUnos);
				System.out.println("Niste unijeli datum u formatu koji je definiran.");
			}
		} while (provjera);
		return datum;
	}

	public static LocalDateTime dateTimeInput(Scanner unos, Logger log) {
		boolean provjera = true;
		LocalDateTime datum = LocalDateTime.now();
		do {
			System.out.println("Unesite datum ispita u formatu 'yyyy-MM-dd'");
			String strDatumDani = unos.next();
			System.out.println(" Unesite sate ispita u formatu 'HH:mm'");
			String strDatumMinute = unos.next();
			String str = strDatumDani + " " + strDatumMinute;
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				datum = LocalDateTime.parse(str, formatter);
				provjera = false;
			} catch (DateTimeParseException izuzetak) {
				log.error("Korisnik nije unio datum i/ili vrijeme u definiranom formatu. Korisnikov unos datuma: "
						+ strDatumDani + " | Korisnikov unos vremena: " + strDatumMinute);
				System.out.println("Niste unijeli datum u formatu koji je definiran.");
			}
		} while (provjera);
		return datum;
	}

	// https://stackoverflow.com/questions/42522744/taking-input-using-localdate
	public static LocalDate dateInputZaPunjenjeBaze(String input) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d.M.yyyy");
		LocalDate date = LocalDate.parse(input, dateFormat);
		return date;
	}

	public static LocalDateTime dateTimeInputZaPunjenjeBaze(String input) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime datum = LocalDateTime.parse(input, formatter);
		return datum;
	}

}
