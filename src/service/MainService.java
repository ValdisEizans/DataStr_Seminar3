package service;

import datastr.MyLinkedHeap;

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
			kaudze.engueue(1);
			kaudze.print();
//			System.out.println("----------------------------------------------------------------------------");
//			kaudze.degueue();
//			kaudze.print();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
