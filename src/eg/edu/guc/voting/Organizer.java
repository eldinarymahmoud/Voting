package eg.edu.guc.voting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

import eg.edu.guc.voting.exceptions.VotingException;
import eg.edu.guc.voting.participants.Candidate;
import eg.edu.guc.voting.participants.Civilian;
import eg.edu.guc.voting.participants.Farmer;
import eg.edu.guc.voting.participants.Independent;
import eg.edu.guc.voting.participants.Officer;
import eg.edu.guc.voting.participants.Party;
import eg.edu.guc.voting.participants.Person;
import eg.edu.guc.voting.participants.Worker;

public class Organizer {
	private ArrayList<Person> countryPeople = new ArrayList<Person>();
	private LinkedList<Election> e = new LinkedList<Election>();
	private int nOfElections;

	public Calendar peoplePartOff(String[] wor) {
		String[] bdate = wor[3].split("/");
		int shahr = Integer.parseInt(bdate[0]);
		int yoom = Integer.parseInt(bdate[1]);
		int sana = Integer.parseInt(bdate[2]);
		Calendar date = Calendar.getInstance();
		date.set(sana, shahr, yoom);
		return date;
	}

	public Calendar civiliansPartOfff(String[] wor) {
		String[] bdate = wor[2].split("/");
		int shahr = Integer.parseInt(bdate[0]);
		int yoom = Integer.parseInt(bdate[1]);
		int sana = Integer.parseInt(bdate[2]);
		Calendar date = Calendar.getInstance();
		date.set(sana, shahr, yoom);
		return date;
	}

	public String[] partOff(String line) {
		String[] wor = line.split(",");
		return wor;
	}

	public void addingPeople(String[] wor, Calendar date) {
		if (wor[0].equals("Officer")) {
			countryPeople.add(new Officer(wor[1], wor[2], date, wor[4]));
		} else {
			Person c = new Civilian(wor[1], wor[2], date, wor[4]);
			countryPeople.add(c);
		}
	}

	public void addingCandidates(String[] wor, Calendar date, int i) {
		if (wor[0].equals("Farmer")) {
			Candidate x = new Farmer(wor[1], wor[2], date, wor[4]);
			e.get(i).addVotable(x);
		} else if (wor[0].equals("Independent")) {
			Candidate x = new Independent(wor[1], wor[2], date, wor[4]);
			e.get(i).addVotable(x);
		} else {
			Candidate x = new Worker(wor[1], wor[2], date, wor[4]);
			e.get(i).addVotable(x);
		}
	}

	public Organizer(java.io.Reader reader) throws IOException {
		BufferedReader b = new BufferedReader(reader);
		nOfElections = Integer.parseInt(b.readLine());
		for (int i = 0; i < nOfElections; i++) {
			String line = b.readLine();
			while (!line.equals("")) {
				String[] wor = partOff(line);
				Calendar date = peoplePartOff(wor);
				addingPeople(wor, date);
				line = b.readLine();
			}
			e.add(new Election("", countryPeople));
			line = b.readLine();
			while (!line.equals("")) {
				String[] wor = partOff(line);
				Calendar date = peoplePartOff(wor);
				addingCandidates(wor, date, i);
				line = b.readLine();
			}
			int kamParty = Integer.parseInt(b.readLine());
			for (int k = 0; k < kamParty; k++) {
				String esmParty = b.readLine();
				Party kz = new Party(esmParty);
				int kamMember = Integer.parseInt(b.readLine());
				for (int j = 0; j < kamMember; j++) {
					line = b.readLine();
					String[] wor = partOff(line);
					Calendar date = civiliansPartOfff(wor);
					Civilian cro = new Civilian(wor[0], wor[1], date, wor[3]);
					kz.addMember(cro);
				}
				e.get(i).addVotable(kz);
			}
			for (int q = 0; q < 2; q++) {
				line = b.readLine();
			}
			while (!line.contains("#")) {
				String[] wor = line.split(",");
				try {
					e.get(i).vote(wor[0], wor[1], wor[2]);
				} catch (VotingException e1) {
					return;
				}
				line = b.readLine();
			}
		}
	}

	public String toString() {
		String v = "";
		int number = 1;
		for (int h = 0; h < e.size(); h++) {
			v = v + number + ") Election has " + e.get(h).getVoters()
					+ " voted people, " + e.get(h).getEligibleVoters()
					+ " people have the right to vote, "
					+ e.get(h).countCandidates() + " Candidates " + ", and "
					+ e.get(h).countParties() + " Parties" + "\n";
			number++;
		}
		return v;
	}

	public static void helper() {
		System.out.println("Hello, and welcome to the GUC Voting Simulation.");
		System.out.println("Today’s elections are:");
	}

	public static void helper2() {
		System.out.println("___________________________________");
		System.out.println("The voting results are:");
		System.out.println("For Candidates :");
	}

	public static void helper3() {
		System.out.println("____________________________");
		System.out.println("*WINNERS*:");
		System.out.println("Candidate Winner Is:");
	}

	public static void helper4() {
		System.out.println("____________________________");
		System.out.println("More options :");
		System.out.println("1)Info about Candidates (press 1)");
		System.out.println("2)Start from the begining(press 2)");
		System.out.println("3)Exit(press 0)");
	}

	public static int partOffff(Organizer m, int i, BufferedReader br, int x)
			throws IOException {
		String z = br.readLine();
		int y = Integer.parseInt(z);
		if (y == 0) {
			i = 11;
			System.out.println("Thanks for your participation!");
		} else if (y == 1) {
			System.out.println("Please enter candidate's id");
			String u = br.readLine();
			boolean k = false;
			for (int l = 0; l < m.e.get(x - 1).getC().size(); l++) {
				if (m.e.get(x - 1).getC().get(l).getId().equals(u)) {
					k = true;
					System.out.println(m.e.get(x - 1).getC().get(l));
					System.out.println("Thanks for your participation!");
				}
				i = 11;
			}
			if (!k) {
				System.out.println("Sorry invalid ID , check it and try again");
			}
		} else if (y == 2) {
			i = 0;
		} else {
			i = 11;
			System.out.println("Thanks for your participation!");
		}
		return i;
	}

	public static void mainHelper(Organizer m, int x) {
		int number = 1;
		for (int j = 0; j < m.e.get(x - 1).getC().size(); j++) {
			System.out.println("Candidate " + number + " got "
					+ m.e.get(x - 1).countVotes(m.e.get(x - 1).getC().get(j))
					+ " votes.");
			number++;
		}
		System.out.println("For Parties :");
		number = 1;
		for (int j = 0; j < m.e.get(x - 1).getP().size(); j++) {
			System.out.println("Party " + number + " got "
					+ m.e.get(x - 1).countVotes(m.e.get(x - 1).getP().get(j))
					+ " votes.");
			number++;
		}
		helper3();
		System.out.println(m.e.get(x - 1).getWinner() + "\n");
		System.out.println("Party Winner Is:");
		System.out.println(m.e.get(x - 1).getPartyWinner());
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			try {
				helper();
				Organizer m = new Organizer(new FileReader("data.txt"));
				System.out.println(m);
				System.out.println("__________________________________");
				System.out
						.println("Enter election number to show its results, press 0 to exit");
				String s = br.readLine();
				int x = Integer.parseInt(s);
				if (x < 0 || x > m.e.size()) {
					System.out.println("ERORR! Available Elections from 1 to "
							+ m.e.size() + "\n" + "\n");

				} else if (x == 0) {
					i = 11;
					System.out.println("Thanks for your participation!");
				} else {
					helper2();
					mainHelper(m, x);
					helper4();
					i = partOffff(m, i, br, x);
				}
			} catch (FileNotFoundException e) {
				return;
			} catch (IOException e) {
				return;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid value (integer)!"
						+ "\n");
			}
		}
	}
}