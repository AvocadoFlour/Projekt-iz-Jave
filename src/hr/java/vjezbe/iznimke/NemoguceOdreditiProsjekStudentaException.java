package hr.java.vjezbe.iznimke;

public class NemoguceOdreditiProsjekStudentaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 267880090245711736L;

	public NemoguceOdreditiProsjekStudentaException() {
		super("Jedan ili više studentovih ispita je ocijenjen ocjenom 1!");
	}

	public NemoguceOdreditiProsjekStudentaException(String poruka) {
		super(poruka);
	}

	public NemoguceOdreditiProsjekStudentaException(String poruka, Throwable uzrok) {
		super(poruka, uzrok);
	}

	public NemoguceOdreditiProsjekStudentaException(Throwable uzrok) {
		super(uzrok);
	}	
	
}
