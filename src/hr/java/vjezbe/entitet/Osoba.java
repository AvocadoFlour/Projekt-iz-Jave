package hr.java.vjezbe.entitet;

/**
 * @author Gandeloft
 *
 */
public abstract class Osoba {
	private String ime;
	private String prezime;
	
	/**
	 * Slu�i za postavljanje minimalnih informacija koje svaki objekt koji naslje�uje klasu mora sadr�avati kako bi bio mogu�.
	 * Rije� je o parametrima "ime" i "prezime".
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