package eg.edu.guc.voting.facilities;

public class School extends LargeComplex {
	private int numberRooms;
	private int noOfBoxes;

	public School(String name, int numberRooms) {
		super(name);
		this.numberRooms = numberRooms;
	}

	public School(String name, int numberRooms, int noOfBoxes) {
		super(name);
		this.numberRooms = numberRooms;
		this.noOfBoxes = noOfBoxes;
	}

	public int getNoOfBoxes() {
		return noOfBoxes;
	}

	public void setNoOfBoxes(int noOfBoxes) {
		this.noOfBoxes = noOfBoxes;
	}

	public int getCapacity() {
		int capacity = super.getCapacity();
		capacity = 6 * numberRooms;
		return capacity;
	}

	public int getNumberRooms() {
		return numberRooms;
	}

	public void setNumberRooms(int numberRooms) {
		this.numberRooms = numberRooms;
	}

	public String toString() {
		String z = "School" + super.getName() + "/n" + "Number of rooms : "
				+ numberRooms;
		return z;
	}

}
