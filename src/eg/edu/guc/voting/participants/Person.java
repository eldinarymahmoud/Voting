package eg.edu.guc.voting.participants;

import java.util.Calendar;

public abstract class Person {
	private String name;
	private Calendar birthDate;
	private String id;
	private String address;
	private String email;
	private int age;
	private boolean isEligibleToVote;
	private boolean didVote;

	public Person(Calendar birthDate, String adress, String email, int age) {
		this.birthDate = birthDate;
		this.age = age;
		this.address = adress;
		this.email = email;
		didVote = false;
	}

	public Person() {
		name = " ";
		birthDate = null;
		id = " ";
		address = " ";
		email = " ";
		isEligibleToVote = false;
		didVote = false;
	}

	public boolean didVote() {
		return didVote;
	}

	public void setDidVote(boolean didVote) {
		this.didVote = didVote;
	}

	public Person(String name, String id, Calendar birthDate,
			boolean isEligibleToVote) {
		this.name = name;
		this.id = id;
		this.birthDate = birthDate;
		this.isEligibleToVote = isEligibleToVote;
		email = " ";
		address = " ";
	}

	public int getAge() {
		Calendar x = Calendar.getInstance();
		int cy = x.get(Calendar.YEAR);
		int by = birthDate.get(Calendar.YEAR);
		int cm = x.get(Calendar.MONTH);
		Calendar birthDate = getBirthDate();
		int bm = birthDate.get(Calendar.MONTH);
		int cd = x.get(Calendar.DAY_OF_MONTH);
		int bd = birthDate.get(Calendar.DAY_OF_MONTH);
		age = cy - by;
		if (cm > bm) {
			age = age - 1;
		} else if (cm == bm) {
			if (cd > bd) {
				age = age - 1;
			}
		}
		return age;
	}

	public abstract boolean isEligibleToVote();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEligibleToVote(boolean isEligibleToVote) {
		this.isEligibleToVote = isEligibleToVote;
	}

	public String toString() {
		return name + "\n" + "The age : " + getAge() + "\n"
				+ "Did he OR she vote : " + didVote + "\n"
				+ "Was he / she eligible to vote :" + isEligibleToVote + "\n";

	}

	public boolean equals(Object o) {
		boolean b = o instanceof Person;
		if (!b) {
			return false;
		}
		Person p = (Person) o;
		if (this.name.equals(p.name) && this.birthDate.equals(p.birthDate)
				&& this.id.equals(p.id) && this.address.equals(p.address)
				&& this.email.equals(p.email) && this.age == p.age
				&& this.isEligibleToVote == p.isEligibleToVote) {
			return true;
		}
		return false;
	}
}