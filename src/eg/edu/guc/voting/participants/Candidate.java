package eg.edu.guc.voting.participants;

import java.util.Calendar;

public abstract class Candidate extends Civilian implements Votable {
	private String candSym;
	private int nOfVotes;

	public Candidate(String id, String fullName, Calendar birthDate,
			String title) {
		super(id, fullName, birthDate, title);
		candSym = " ";
	}

	public String getCandSym() {
		return candSym;
	}

	public void setCandSym(String candSym) {
		this.candSym = candSym;
	}

	public int getnOfVotes() {
		return nOfVotes;
	}

	public int countVotes() {
		return nOfVotes;
	}

	public void giveVote() {
		nOfVotes++;
	}

	public void setnOfVotes(int nOfVotes) {
		this.nOfVotes = nOfVotes;
	}

	public Candidate(String symbol) {
		super();
		this.candSym = symbol;
	}

	public Candidate() {
		super();
		candSym = " ";
	}

	public String getSymbol() {
		return candSym;
	}

	public void setSymbol(String symbol) {
		this.candSym = symbol;
	}

	public String toString() {
		String z = "Candidate : " + super.toString();
		return z;
	}

	public boolean equals(Object o) {
		boolean b = o instanceof Candidate;
		if (!b) {
			return false;
		}
		Candidate c = (Candidate) o;
		if (this.candSym.equals(c.candSym) && super.equals(o)) {
			return true;
		}
		return false;
	}
}
