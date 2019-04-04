package hr.java.vjezbe.iznimke;

public class PostojiViseNajmladjihStudenataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1324053465120359404L;

	public PostojiViseNajmladjihStudenataException() {
		super("Oba studenta najmlaða studenta sa istim prosjekom su jednako stari.");
	}

	public PostojiViseNajmladjihStudenataException(String poruka) {
		super(poruka);
		System.exit(0);
	}

	public PostojiViseNajmladjihStudenataException(String poruka, Throwable uzrok) {
		super(poruka, uzrok);
	}
	
	public PostojiViseNajmladjihStudenataException(Throwable uzrok) {
		super(uzrok);
	}

}
