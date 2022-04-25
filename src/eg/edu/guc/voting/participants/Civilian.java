package eg.edu.guc.voting.participants;

import java.util.Calendar;

public class Civilian extends Person {
	private String title;
	private int nOfChildren;
	private String job;

	public Civilian(String id, String fullName, Calendar birthDate, String title) {
		super(fullName, id, birthDate, false);
		this.title = title;
		nOfChildren = 0;
		job = " ";
	}

	public Civilian() {
		super();
		title = "-";
		nOfChildren = 0;
		job = "-";
	}

	public boolean isEligibleToVote() {
		Calendar x = Calendar.getInstance();
		int z = super.getAge();
		int cm = x.get(Calendar.MONTH);
		Calendar birthDate = super.getBirthDate();
		int bm = birthDate.get(Calendar.MONTH);
		int cd = x.get(Calendar.DAY_OF_MONTH);
		int bd = birthDate.get(Calendar.DAY_OF_MONTH);
		if (z > 18) {
			return true;
		} else if (z == 18) {
			if (bm > cm) {
				return true;
			} else if (bm == cm) {
				if (bd >= cd) {
					return true;
				}
			}
		}
		return false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getnOfChildren() {
		return nOfChildren;
	}

	public void setnOfChildren(int nOfChildren) {
		this.nOfChildren = nOfChildren;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String toString() {
		return title + super.toString() + "Job :" + job;
	}

	public boolean equals(Object o) {
		boolean b = o instanceof Civilian;
		if (!b) {
			return false;
		}
		Civilian c = (Civilian) o;
		if (this.title.equals(c.title) && this.nOfChildren == c.nOfChildren
				&& this.job.equals(c.job) && super.equals(o)) {
			return true;
		}
		return false;
	}

}
