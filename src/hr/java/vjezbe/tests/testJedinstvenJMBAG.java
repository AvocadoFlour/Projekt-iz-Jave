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
//		String[] strArr = new String[profArr.length + stuArr.length]; //STRING ARRAY KOJI ÆE SADRŽAVATI SVE JMBAGE PROFESORA I STUDENATA
//		for (Profesor p : profArr) {
//			strArr[counter0] = p.getJmbag();
//			counter0 += 1;
//		}
////GOTOVA POHRANA SVIH POSTOJEÆIH JMBAG-a PROFESORA
//		int counter1 = counter0;
//		for (Student s : stuArr) {
//			strArr[counter1] = s.getJmbag();
//			counter1 += 1;
//		}
//		//GOTOVA POHRANA SVIH POSTOJEÆIH JMBAG-a STUDENATA
//		
//
//		boolean provjera = true;
//		while (provjera) {
//			System.out.println("Unos JMBAG-a");
//			String noviJMBAG = unos.nextLine();
//			for (String st : strArr) {
//				if (new String(st).equals(noviJMBAG)) {
//					System.out.println("Unešen veæ postojeæi JMBAG. To nije moguæe ja mislim hmhm");					
//				}
//				*noviJMBAG stavi se u novi objekt*
//				else {System.out.println("Unos uspiješno izvršen!");}
//				provjera = false;
//			}
//		}
//	}
//}
