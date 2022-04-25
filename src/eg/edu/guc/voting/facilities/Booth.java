package eg.edu.guc.voting.facilities;

public class Booth extends SmallSetup {
	private int noOfBoxes;

	public Booth(String address) {
		super(address);
	}

	public Booth(String address, int noOfBoxes) {
		super(address);
		this.noOfBoxes = noOfBoxes;
	}

	public int getNoOfBoxes() {
		return noOfBoxes;
	}

	public void setNoOfBoxes(int noOfBoxes) {
		this.noOfBoxes = noOfBoxes;
	}

	public Booth() {
		super();
		noOfBoxes = 0;
	}

	public int getCapacity() {
		int x = super.getCapacity();
		x = 1;
		return x;
	}

	public String toString() {
		String r = "Booth" + getAddress();
		return r;
	}

}
