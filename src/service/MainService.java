package service;

import datastr.MyLinkedHeap;
import model.Patient;

public class MainService {

	public static void main(String[] args) {
		MyLinkedHeap<Integer> kaudze = new MyLinkedHeap<Integer>();
		try {
			kaudze.engueue(40);
			kaudze.engueue(50);
			kaudze.engueue(35);
			kaudze.engueue(99);
			kaudze.engueue(55);
			kaudze.engueue(2);
			kaudze.print();
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Max vertiba: " + kaudze.degueue());
			kaudze.print();
			//TODO kad last node partaists
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		MyLinkedHeap<Patient> patients = new MyLinkedHeap<Patient>();
		try {
			System.out.println("----------------------------DARBIBAS AR PACIENTIEM------------------------------------------------");
			patients.engueue(new Patient("Janis","Berzins",1));
			patients.engueue(new Patient("Liga","Eglite",3));
			patients.engueue(new Patient("Baiba","Kalnina",2));
			patients.engueue(new Patient("Juris","Nejaukais",5));
			patients.print();
			System.out.println("----------------------------------------------------------------------------");
			patients.degueue();
			patients.print();
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
