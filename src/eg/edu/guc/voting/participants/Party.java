package eg.edu.guc.voting.participants;

import java.util.*;

public class Party implements Votable {

	private String partyName;
	private LinkedList<Civilian> nemnem;
	private int nOfVotes;
	private String description;

	public Party() {
		partyName = " ";
		nemnem = new LinkedList<Civilian>();
		nOfVotes = 0;
		description = " ";
	}

	public Party(String name) {
		partyName = name;
		nemnem = new LinkedList<Civilian>();
	}

	public Party(String name, String description) {
		partyName = name;
		nemnem = new LinkedList<Civilian>();
		this.description = description;
	}

	public boolean isMember(Civilian member) {
		for (int k = 0; k < nemnem.size(); k++) {
			if (nemnem.get(k).equals(member)) {
				return true;
			}
		}
		return false;
	}

	public void addMember(Civilian member) {
		if (!isMember(member)) {
			nemnem.add(member);
		}
	}

	public int countMembers() {
		return nemnem.size();
	}

	public int countVotes() {
		return nOfVotes;
	}

	public void giveVote() {
		nOfVotes++;
	}

	public String[] membersNames() {
		String[] x = new String[countMembers()];
		for (int i = 0; i < nemnem.size(); i++) {
			x[i] = nemnem.get(i).getName();
		}
		return x;
	}

	public String partyDescripton() {
		return description;
	}

	public String getId() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public LinkedList<Civilian> getNemnem() {
		return nemnem;
	}

	public void setNemnem(LinkedList<Civilian> nemnem) {
		this.nemnem = nemnem;
	}

	public String toString() {
		String[] g = membersNames();
		String f = "";
		for (int i = 0; i < g.length; i++) {
			f = f + "\n" + g[i];
		}
		String z = "Party name : " + partyName + "\n" + "Number of members :"
				+ countMembers() + "\n" + "Members' names :" + f + "\n"
				+ "number of votes :" + countVotes();
		return z;
	}

	public boolean equals(Object o) {
		if (o instanceof Party) {
			Party z = (Party) o;
			if (this.partyName.equals(z.partyName)) {
				for (int io = 0; io < z.nemnem.size(); io++) {
					if (!this.isMember(z.nemnem.get(io))) {
						return false;
					}
				}
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
