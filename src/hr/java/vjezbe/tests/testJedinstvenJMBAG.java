package hr.java.vjezbe.tests;
//package hr.java.vjezbe.entitet;
//
//import java.util.HashSet;
//import java.util.Scanner;
//
//import hr.java.vjezbe.entitet.Profesor;
//import hr.java.vjezbe.entitet.Student;
//
//public class Test {
//
//	Scanner unos = new Scanner(System.in);
//
//	public Boolean jedinstvenostJMBAG(Profesor[] profArr, Student[] stuArr) {
//		int counter0 = 0;
//		String[] strArr = new String[profArr.length + stuArr.length]; //STRING ARRAY KOJI �E SADR�AVATI SVE JMBAGE PROFESORA I STUDENATA
//		for (Profesor p : profArr) {
//			strArr[counter0] = p.getJmbag();
//			counter0 += 1;
//		}
////GOTOVA POHRANA SVIH POSTOJE�IH JMBAG-a PROFESORA
//		int counter1 = counter0;
//		for (Student s : stuArr) {
//			strArr[counter1] = s.getJmbag();
//			counter1 += 1;
//		}
//		//GOTOVA POHRANA SVIH POSTOJE�IH JMBAG-a STUDENATA
//		
//
//		boolean provjera = true;
//		while (provjera) {
//			System.out.println("Unos JMBAG-a");
//			String noviJMBAG = unos.nextLine();
//			for (String st : strArr) {
//				if (new String(st).equals(noviJMBAG)) {
//					System.out.println("Une�en ve� postoje�i JMBAG. To nije mogu�e ja mislim hmhm");					
//				}
//				*noviJMBAG stavi se u novi objekt*
//				else {System.out.println("Unos uspije�no izvr�en!");}
//				provjera = false;
//			}
//		}
//	}
//}
