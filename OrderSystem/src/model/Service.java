package model;

public class Service extends Orderable{

	private int hours, persons;

	public Service(String name, int person, int hours) {
        super(name);
		this.hours = hours;
		persons = person;
	}
    public int getHours(){
        return hours;
    }
    public void increasePersons(int addPersons){
        this.persons += addPersons;
    }
	public int getPrice() {
		return 1242 * hours * persons;
	}
	public void print() {
		System.out.println(persons + " persons for " +
				hours + "h of " + getName());
	}
}
