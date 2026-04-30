package model;

public class Patient implements Comparable<Patient>{
	private String name;
	private String surname;
	private int priority;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public Patient() {}
	public Patient(String name, String surname, int priority) {
		setName(name);
		setSurname(surname);
		setPriority(priority);
	}

	@Override //var nerakstit
	public String toString() {
		String result = name + " " + surname + " (" + priority + ")";
		return result;
	}
	@Override
	public int compareTo(Patient arg0) {
		if(priority > arg0.priority) {
			return 1;
		}
		else if(priority < arg0.priority) {
			return -1;
		}
		else {
			return 0;
		}
	}
	

}
