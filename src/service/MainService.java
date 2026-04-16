package service;

import datastr.MyLinkedHeap;

public class MainService {

	public static void main(String[] args) {
		MyLinkedHeap<Integer> kaudze = new MyLinkedHeap<Integer>();
		try {
			kaudze.engueue(40);
			kaudze.engueue(50);
			kaudze.engueue(35);
			kaudze.engueue(15);
//			kaudze.engueue(10);
			kaudze.print();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
