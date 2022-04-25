package eg.edu.guc.voting.facilities;

public abstract class VotingStation {
	private int ksf;
	private int votingworkers;

	public VotingStation(int capacity) {
		this.ksf = capacity;
	}

	public VotingStation() {
		ksf = 0;
		this.votingworkers = 0;
	}

	public VotingStation(int capacity, int votingWorkers) {
		this.ksf = capacity;
		this.votingworkers = votingWorkers;
	}

	public void setCapacity(int capacity) {
		this.ksf = capacity;
	}

	public int getVotingworkers() {
		return votingworkers;
	}

	public void setVotingworkers(int votingworkers) {
		this.votingworkers = votingworkers;
	}

	public int getCapacity() {
		return ksf;
	}

	public String toString() {
		String z = "Number of people who can vote at the same time : " + ksf;
		return z;

	}
}
