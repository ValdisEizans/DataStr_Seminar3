package datastr;

public class MyLinkedHeap<Ttype> {
	//Mainigie
	private MyNode<Ttype> rootNode = null;
	private MyNode<Ttype> lastNode = null;
	int howManyElements = 0;
	
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
	
	//ievietot bloku
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
		else {
			
		}
		
	}
	
	
	
	
	
}
