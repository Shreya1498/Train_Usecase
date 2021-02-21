package train_usecase;

public class Passenger implements Comparable<Object> {
	private String name;
	private int age;
	private char gender;
	
	
	public Passenger(String name, int age, char gender) {
		//super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}


	public Passenger() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Passenger [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}


	public int compareTo(Passenger p)
	{
		return name.compareTo(name);
		
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
