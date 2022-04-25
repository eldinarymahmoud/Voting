package eg.edu.guc.voting.participants;

import java.util.Calendar;

public class Officer extends Person {
	private String rank;
	private int nOfWorkYears;

	public Officer(String id, String fullName, Calendar birthDate, String rank) {
		super(fullName, id, birthDate, false);
		this.rank = "major";
		nOfWorkYears = 0;
	}

	public Officer() {
		super();
		rank = " ";
		nOfWorkYears = 0;
	}

	public boolean isEligibleToVote() {
		return false;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getnOfWorkYears() {
		return nOfWorkYears;
	}

	public void setnOfWorkYears(int nOfWorkYears) {
		this.nOfWorkYears = nOfWorkYears;
	}

	public String toString() {
		return "major" + rank + "/n" + super.toString() + "/n" + "/n"
				+ "Number of work years :" + nOfWorkYears + "/n"
				+ "Officer's age : " + super.getAge();
	}

	public boolean equals(Object o) {
		boolean b = o instanceof Officer;
		if (!b) {
			return false;
		}
		Officer f = (Officer) o;
		if (this.rank.equals(f.rank) && this.nOfWorkYears == f.nOfWorkYears
				&& super.equals(o)) {
			return true;
		}
		return false;

	}
}
