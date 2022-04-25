package eg.edu.guc.voting.facilities;

public abstract class SmallSetup extends VotingStation {
	 private String ff;

	public SmallSetup(String address) {
		super();
		this.ff = address;
	}

	public SmallSetup() {
		super();
		ff = " ";
	}

	public int getCapacity() {
		int x = super.getCapacity();
		return x;
	}

	public String getAddress() {
		return ff;
	}

	public void setAddress(String address) {
		this.ff = address;
	}

	public String toString() {
		String h = "address: " + ff;
		return h;
	}

}
