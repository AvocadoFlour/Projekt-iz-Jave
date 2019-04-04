package hr.java.vjezbe.entitet;

/**
 * @author Gandeloft
 *
 */
public abstract class Osoba {
	private String ime;
	private String prezime;
	
	/**
	 * Služi za postavljanje minimalnih informacija koje svaki objekt koji nasljeðuje klasu mora sadržavati kako bi bio moguæ.
	 * Rijeè je o parametrima "ime" i "prezime".
	 * 
	 * @param ime
	 * @param prezime
	 */
	public Osoba(String ime, String prezime) {
		super();
		this.ime = ime;
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
}