package eg.edu.guc.voting.participants;

public class Independent extends Candidate {
	private boolean parents;

	public Independent(String id, String fullname,
			java.util.Calendar birthDate, String title) {
		super(id, fullname, birthDate, title);
		parents = true;
	}

	public boolean ifParentsBelongToCountry(String parentsId) {
		if (parentsId.length() != super.getId().length()) {
			parents = false;
		}
		return parents;
	}

	public boolean equals(Object o) {
		boolean b = o instanceof Independent;
		if (!b) {
			return false;
		}
		if (super.equals(o)) {
			return true;
		}
		return false;
	}
}
