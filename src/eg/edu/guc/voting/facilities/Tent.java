package eg.edu.guc.voting.facilities;

public class Tent extends SmallSetup {
	private int noOfBoxes;

	public Tent(String address) {
		super(address);
		noOfBoxes = 0;
	}

	public Tent(String address, int noOfBoxes) {
		super(address);
		this.noOfBoxes = noOfBoxes;
	}

	public int getNoOfBoxes() {
		return noOfBoxes;
	}

	public void setNoOfBoxes(int noOfBoxes) {
		this.noOfBoxes = noOfBoxes;
	}

	public int getCapacity() {
		int x = super.getCapacity();
		x = 5;
		return x;
	}

	public String toString() {
		String j = "Tent" + getAddress();
		return j;
	}

}
