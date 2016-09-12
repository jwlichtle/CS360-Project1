
public class Person {
	int SSN;
	int DOB;
	String name;
	public Person(String n, int s, int d) {
		SSN = s;
		DOB = d;
		name = n;
	}
	public Person() {
	}
	
	public void setSSN(int s) {
		SSN = s;
	}
	public void setDOB(int d) {
		DOB = d;
	}
	public void setName(String n) {
		name = n;
	}
	public int getSSN(){
		return SSN;
	}
	public int getDOB(){
		return DOB;
	}
	public String getName(){
		return name;
	}
}
