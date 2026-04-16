package datastr;

public class MyNode<Ttype> {
	//Mainigiem
	private Ttype element;
	private MyNode<Ttype> parrentNode = null;
	private MyNode<Ttype> leftChildNode = null;
	private MyNode<Ttype> rightChildNode = null;
	
	//Geteri
	public Ttype getElement() {
		return element;
	}
	public MyNode<Ttype> getParrentNode() {
		return parrentNode;
	}
	public MyNode<Ttype> getLeftChildNode() {
		return leftChildNode;
	}
	public MyNode<Ttype> getRightChildNode() {
		return rightChildNode;
	}
	
	//Seteri
	public void setElement(Ttype inputElement) {
		if(inputElement != null) {
			element = inputElement;	
		}
		else {
			element = (Ttype) new Object();
		}
		
	}
	//nav javeic not null parbaudes, jo ir gadijumi kad pedejais vai pirmais bloks
	public void setParrentNode(MyNode<Ttype> parrentNode) {
		this.parrentNode = parrentNode;
	}
	public void setLeftChildNode(MyNode<Ttype> leftChildNode) {
		this.leftChildNode = leftChildNode;
	}
	public void setRightChildNode(MyNode<Ttype> rightChildNode) {
		this.rightChildNode = rightChildNode;
	}
	
	//Konstruktori
	public MyNode (Ttype inputElement){
		setElement(inputElement);
	}	
	
	//toString
	public String toString() {
		return "" + element;
	}
	
}
