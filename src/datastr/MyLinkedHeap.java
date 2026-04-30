package datastr;

import java.util.LinkedList;
import java.util.Queue;

public class MyLinkedHeap<Ttype> {
	//Mainigie
	private MyNode<Ttype> rootNode = null;
	private MyNode<Ttype> lastNode = null;
	private int howManyElements = 0;
	private int level = 0;
	
	//geteri, prieks blokiem nevajag
	public int getHowManyElements() {
		return howManyElements;
	}
	
	//seteri - nav nepieciesami
	
	//konstruktori - nevajag nevienu, jo default jau nak no Object klases
	
	private boolean isEmpty() {
		return (howManyElements == 0); 
	}
	
	private boolean isFull() {
		try {
			new MyNode<Character>('A');//megina RAM rezervet vietu
			return false;
		}
		catch(OutOfMemoryError e){
			return true;
		}
	}
	
	//pievienot bloku
	public void engueue(Ttype element) throws Exception{
		if(isFull()) {
			throw new Exception("Kaudze ir pilna, nevar pievienot elementu!");
		}
		
		if(element == null) {
			throw new Exception("Nav noradits elements!");
		}
		
		//ja pirmais bloks
		if(isEmpty()) {
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			rootNode = newNode;
			lastNode = newNode;
			howManyElements++;
		}
		//ja kaudze ir jau bloki, pievieno vel vienu bloks
		else {
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);

			//bus saknes elementa kreisais berns
			if(howManyElements == 1) {
				rootNode.setLeftChildNode(newNode);
				newNode.setParrentNode(rootNode);
				lastNode = newNode;
				howManyElements++;
				level++;
				reHeapUp(newNode);	
				return;
			}
			
			//pedejam blokam blakus nav neviena bloka labaja puse
			if(lastNode.getParrentNode() != null && lastNode.getParrentNode().getRightChildNode() == null) {
				MyNode<Ttype> parentNodeTemp = lastNode.getParrentNode();
				parentNodeTemp.setRightChildNode(newNode);
				newNode.setParrentNode(parentNodeTemp);
				
				lastNode = newNode;
				howManyElements++;
				reHeapUp(newNode);
				return;
			}

			/*kad japarlec uz nakamo limeni
			2^0 = 1 elements 0. limeni
			2^1 = 2 elementi 1. limeni
			2^2 = 4 elementi 2. limeni
			*/
			int sum = 0;
			//noskaidro, cik bliku lidz sim limenim ieskaitot
			for(int i = 0; i <= level; i++) {
				sum = (int) (sum + Math.pow(2, i));
			}

			//lastNode ka pedejais bloks sava limeni
			if(sum == howManyElements) {
				MyNode<Ttype> currentNode = rootNode;
				
				//blokam kreisais berns, lec uz to
				while(currentNode.getLeftChildNode() != null) {
					currentNode = currentNode.getLeftChildNode();
				}
				lastNode = currentNode;
				
				lastNode.setLeftChildNode(newNode);
				newNode.setParrentNode(lastNode);
				
				lastNode = newNode;
				howManyElements++;
				level++;
				reHeapUp(newNode);	
				return;
			}
			else {
				//pedejam blokam abi berni
				if(lastNode.getParrentNode().getLeftChildNode()!= null && lastNode.getParrentNode().getRightChildNode()!=null){
						MyNode currentParent = findInsertionNode();
						currentParent.setLeftChildNode(newNode);
						newNode.setParrentNode(currentParent);
						lastNode = newNode;
						reHeapUp(newNode);
						howManyElements++;
						return;
				}
				
				//pedejam blokam nav neviena berna 
				if(lastNode.getLeftChildNode() == null && lastNode.getRightChildNode() == null) {
					lastNode.setLeftChildNode(newNode);
					newNode.setParrentNode(lastNode);
					lastNode = newNode;
					howManyElements++;
					reHeapUp(newNode);	
					return;
				}				
			}
		}
	}
	
	//MAX kaudzes gadijums
	private void reHeapUp(MyNode<Ttype> nodeTemp) {
		//vai blokam ir vecaks
		if(nodeTemp.getParrentNode() != null) {
			MyNode<Ttype> parentTempNode = nodeTemp.getParrentNode();
			//salidizna vai bloka vertiba lielaka par vecaka vertibu
			if(((Comparable)nodeTemp.getElement()).compareTo(parentTempNode.getElement()) > 0) {
				//mainam vieta vertibas
				swap(nodeTemp, parentTempNode);
				//izsauc rekursivi uz vecaku bloku
				reHeapUp(parentTempNode);
			}
		}
	}
	
	private void swap(MyNode<Ttype> node1, MyNode<Ttype> node2) {
		Ttype temp = node1.getElement();
		node1.setElement(node2.getElement());
		node2.setElement(temp);
	}
	
	//print funkcija
	public void print() throws Exception{
		if(isEmpty()) {
			throw new Exception("Kaudze ir tuksa, nevar izdrukat!");
		}
		printHelper(rootNode);
	}
	
	private void printHelper(MyNode<Ttype> nodeTemp) {
		if(nodeTemp != null) {
			System.out.println("P: " + nodeTemp.getElement());
			//vai eksiste kreisais berns
			if(nodeTemp.getLeftChildNode() != null) {
				System.out.println("P: " + nodeTemp.getElement() + " L child: " + nodeTemp.getLeftChildNode().getElement());
				//izpilda rekursivi funkciju uz kreisa berna
				printHelper(nodeTemp.getLeftChildNode());
			}
			//vai eksiste labais berns
			if(nodeTemp.getRightChildNode() != null) {
				System.out.println("P: " + nodeTemp.getElement() + " R child: " + nodeTemp.getRightChildNode().getElement());
				//izpilda rekursivi funkciju uz laba berna
				printHelper(nodeTemp.getRightChildNode());
			}
		}
	}
	
	private MyNode findInsertionNode() {
		Queue<MyNode> queue = new LinkedList<>();
		queue.add(rootNode);
		while (!queue.isEmpty()) {
		MyNode currentNode = queue.poll();
		if (currentNode.getLeftChildNode() == null) {
		return currentNode;
		} else {
		queue.add(currentNode.getLeftChildNode());
		}
		if (currentNode.getRightChildNode() == null) {
		return currentNode;
		} else {
		queue.add(currentNode.getRightChildNode());
		}
		}
		return null;
		}
	
	//dzest bloku no MAX kaudzes
	public Ttype degueue() throws Exception{
		// veicam visas pārbaudes
		if(isEmpty()) {
			throw new Exception("Kaudze ir tukša, nevar dzest elementu!");
		}
		// saglabasim root elementu mainīgaja
		Ttype maxElement = rootNode.getElement();
		
		// pedejo bloka vertību ieliekam root blokā
		rootNode.setElement(lastNode.getElement());
		
		//tagadejais pedejais mezgls vecaka kreisais berns
		if(lastNode.getParrentNode().getLeftChildNode() == lastNode) {
			lastNode.getParrentNode().setLeftChildNode(null);
		}
		//tagadejais pedejais mezgls vecaka labais berns
		if(lastNode.getParrentNode().getRightChildNode() == lastNode) {
			lastNode.getParrentNode().setRightChildNode(lastNode);
		}
		
		// samazinam howManyElements
		howManyElements--;
		
		// lastNode samainīt (level samazinat, kur tas ir nepieciešams)
		
		// reheapDown izsaukt
		reHeapDown(rootNode);
		
		// atgriežam elementu, kurš bija sākumā saknes blokā
		return maxElement;
	}
	
	private void reHeapDown(MyNode<Ttype> nodeTemp) {
		if(nodeTemp != null) {
			//ja tikai viens berns un tas ir kreisais
			if(nodeTemp.getLeftChildNode() != null && nodeTemp.getRightChildNode() == null) {
				if(((Comparable)nodeTemp.getElement()).compareTo(nodeTemp.getLeftChildNode().getElement()) < 0) {
					swap(nodeTemp,nodeTemp.getLeftChildNode());
				}
			}
			//ja abi berni
			else if (nodeTemp.getLeftChildNode() != null && nodeTemp.getRightChildNode() != null){
				//parbaudam vai kreisais berns lielaks par labo
				if(((Comparable)nodeTemp.getLeftChildNode().getElement()).compareTo(nodeTemp.getRightChildNode().getElement()) > 0) {
					//vai kreisais berns lielaks par pasu bloku
					if(((Comparable)nodeTemp.getLeftChildNode().getElement()).compareTo(nodeTemp.getElement()) > 0) {
						swap(nodeTemp,nodeTemp.getLeftChildNode());
						reHeapDown(nodeTemp.getLeftChildNode());
					}
				
				
				}
				//parbaudam vai labais berns lielaks par kreiso
				else {
					//vai kreisais berns mazaks par pasu bloku
					if(((Comparable)nodeTemp.getRightChildNode().getElement()).compareTo(nodeTemp.getElement()) > 0) {
						swap(nodeTemp,nodeTemp.getRightChildNode());
						reHeapDown(nodeTemp.getRightChildNode());
					}
				}
			}
		}
	}
	
	
}
