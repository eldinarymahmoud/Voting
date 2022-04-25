package eg.edu.guc.voting.facilities;

public class Stadium extends LargeComplex {
	private int noOfBoxes;

	public Stadium(String name) {
		super(name);
	}

	public Stadium(String name, int noOfBoxes) {
		super(name);
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
		capacity = 40;
		return capacity;
	}

	public String toString() {
		String r = "Stadium" + getName();
		return r;
	}

}
