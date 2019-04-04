package hr.java.vjezbe.entitet;

public abstract class ObrazovnaUstanova {
	private String nazivUstanove;
	private Predmet[] predmeti;
	private Profesor[] profesori;
	private Student[] studenti;
	private Ispit[] ispiti;

	/**
	 * Služi za postavljanje kostura svih klasa koje æe proširivati ovu klasu.
	 * Prima argumente za naziv ustanove, predmete ustanove, profesore ustavove te ispite ustanove.
	 * 
	 * @param nazivUstanove Naziv ustanove
	 * @param predmeti redmeti koji se održavaju na ustanovi!ð
	 * @param profesori Profesori koji su dio objekta.
	 * @param studenti Studenti koje objekt ima.
	 * @param ispiti Ispiti koje faks dodjeljuje.
	 */
	public ObrazovnaUstanova(String nazivUstanove, Predmet[] predmeti, Profesor[] profesori, Student[] studenti,
			Ispit[] ispiti) {
		super();
		this.nazivUstanove = nazivUstanove;
		this.predmeti = predmeti;
		this.profesori = profesori;
		this.studenti = studenti;
		this.ispiti = ispiti;
	}

	/**
	 * Vraæa true ili false temeljen na postojanosti objekta tipa "Ispit" unutar danog polja objekata tipa "Ispit".
	 * 
	 * @param ispiti polje ispita na kojem æe se raditi
	 * @return vraæa true ukoliko postoji jedinica, false ako ne postoji
	 */
	public static Boolean postojiLiJedinica(Ispit[] ispiti) {
		Boolean provjera = false;
		for (Ispit i : ispiti) {
			if (i.getOcjena() == 1) {
				provjera = true;
			}
		}
		return provjera;
	}

	/**
	 * Vraæa objekt tipa "Student" koji je u danoj godini bio akademski
	 * najuspiješniji. To se mjeri raèunanjem prosjeka ocjena na ispitima tog
	 * objekta tipa "Student".
	 * 
	 * @param godina na koju se želi ogranièiti polje ispita
	 * @return vraæa objekt tipa "Student" koji je bio najuspiješniji u danoj godini.
	 */
	public abstract Student odrediNajuspjesnijegStudentaNaGodini(int godina);

	public String getNazivUstanove() {
		return nazivUstanove;
	}

	public void setNazivUstanove(String nazivUstanove) {
		this.nazivUstanove = nazivUstanove;
	}

	public Predmet[] getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(Predmet[] predmeti) {
		this.predmeti = predmeti;
	}

	public Profesor[] getProfesori() {
		return profesori;
	}

	public void setProfesori(Profesor[] profesori) {
		this.profesori = profesori;
	}

	public Student[] getStudenti() {
		return studenti;
	}

	public void setStudenti(Student[] studenti) {
		this.studenti = studenti;
	}

	public Ispit[] getIspiti() {
		return ispiti;
	}

	public void setIspiti(Ispit[] ispiti) {
		this.ispiti = ispiti;
	}

}
