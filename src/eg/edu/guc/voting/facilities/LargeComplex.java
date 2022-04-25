package eg.edu.guc.voting.facilities;

public abstract class LargeComplex extends VotingStation {
	private String ffft;

	public LargeComplex(String name) {
		super();
		this.ffft = name;
	}

	public LargeComplex() {
		super();
		ffft = " ";
	}

	public LargeComplex(int ca) {
		super.setCapacity(ca);
	}

	public String getName() {
		return ffft;
	}

	public void setName(String name) {
		this.ffft = name;
	}

	public int getCapacity() {
		return super.getCapacity();
	}

	public String toString() {
		String g = "Complex name :" + ffft;
		return g;
	}

}
