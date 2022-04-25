package eg.edu.guc.voting;

import java.util.*;

import eg.edu.guc.voting.exceptions.InvalidVoterException;
import eg.edu.guc.voting.exceptions.MultipleVoteException;
import eg.edu.guc.voting.exceptions.VotableNotFoundException;
import eg.edu.guc.voting.exceptions.VotingException;
import eg.edu.guc.voting.participants.Candidate;
import eg.edu.guc.voting.participants.Civilian;
import eg.edu.guc.voting.participants.Party;
import eg.edu.guc.voting.participants.Person;
import eg.edu.guc.voting.participants.Votable;

public class Election {
	private String title;
	private ArrayList<Person> elsha3b = new ArrayList<Person>();
	private ArrayList<Party> kolElA7zab = new ArrayList<Party>();
	private ArrayList<Candidate> kolELA3da2 = new ArrayList<Candidate>();

	public Election(String title, ArrayList<Person> people) {
		this.title = title;
		this.elsha3b = people;
	}

	public Election() {
		title = " ";
		elsha3b = null;
		kolElA7zab = null;
		kolELA3da2 = null;
	}

	public void addVotable(Votable votable) {
		boolean b = false;
		if (votable instanceof Party) {
			for (int i = 0; i < kolElA7zab.size(); i++) {
				if (kolElA7zab.get(i).equals(votable)) {
					b = true;
				}
			}
			if (!b) {
				Party x = (Party) votable;
				kolElA7zab.add(x);
			}
		}
		if (votable instanceof Civilian) {
			b = false;
			for (int i = 0; i < kolELA3da2.size(); i++) {
				if (kolELA3da2.get(i).equals(votable)) {
					b = true;
				}
			}
			if (!b) {
				Candidate y = (Candidate) votable;
				kolELA3da2.add(y);
			}
		}
	}

	public int countParties() {
		return kolElA7zab.size();
	}

	public int countCandidates() {
		return kolELA3da2.size();
	}

	public void vote(String voterId, String partyName, String candidateId)
			throws VotingException {
		for (int i = 0; i < elsha3b.size(); i++) {
			if (elsha3b.get(i).getId().equals(voterId)) {
				if (!elsha3b.get(i).isEligibleToVote()) {
					throw new InvalidVoterException(
							"Sorry,the person you have entered isn't able to give vote!");
				} else if (elsha3b.get(i).didVote()) {
					throw new MultipleVoteException(
							"Sorry , you can not vote twice!");
				} else {
					if (partyName != "") {
						boolean b = false;
						for (int z = 0; z < kolElA7zab.size(); z++) {
							if (kolElA7zab.get(z).getId().equals(partyName)) {
								b = true;
								kolElA7zab.get(z).giveVote();
								elsha3b.get(i).setDidVote(true);
							}
						}
						if (!b) {
							throw new VotableNotFoundException(
									"Sorry,The Party you have entered does not exist in votables!");
						}
					}
					if (candidateId != null) {
						boolean g = false;
						for (int k = 0; k < kolELA3da2.size(); k++) {
							if (kolELA3da2.get(k).getId().equals(candidateId)) {
								g = true;
								kolELA3da2.get(k).giveVote();
								elsha3b.get(i).setDidVote(true);
							}

						}
						if (!g) {
							throw new VotableNotFoundException(
									"Sorry,The Candidate you have entered does not exist here!");

						}
					}
				}
			}
		}
	}

	public int getVoters() {
		int votes = 0;
		for (int i = 0; i < elsha3b.size(); i++) {
			if (elsha3b.get(i).didVote()) {
				votes = votes + 1;
			}
		}
		return votes;
	}

	public int getEligibleVoters() {
		int votes = 0;
		for (int i = 0; i < elsha3b.size(); i++) {
			if (elsha3b.get(i).isEligibleToVote()) {
				votes = votes + 1;
			}
		}
		return votes;
	}

	public int countVotes(Votable votable) {
		if (votable instanceof Party) {
			for (int i = 0; i < kolElA7zab.size(); i++) {
				if (kolElA7zab.get(i).getId().equals(votable.getId())) {
					int x = kolElA7zab.get(i).countVotes();
					return x;
				}
			}
		} else {
			if (votable instanceof Candidate) {
				for (int j = 0; j < kolELA3da2.size(); j++) {
					if (kolELA3da2.get(j).getId().equals(votable.getId())) {
						int x = kolELA3da2.get(j).countVotes();
						return x;
					}
				}
			}
		}
		return -1;
	}

	public Party getPartyWinner() {
		Party winnerP = kolElA7zab.get(0);
		for (int j = 0; j < kolElA7zab.size(); j++) {
			if (winnerP.countVotes() < kolElA7zab.get(j).countVotes()) {
				winnerP = kolElA7zab.get(j);
			}
		}
		return winnerP;
	}

	public Candidate getWinner() {
		Candidate winnerC = kolELA3da2.get(0);
		for (int j = 0; j < kolELA3da2.size(); j++) {
			if (winnerC.countVotes() < kolELA3da2.get(j).countVotes()) {
				winnerC = kolELA3da2.get(j);
			}
		}
		return winnerC;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<Person> getPeople() {
		return elsha3b;
	}

	public void setPeople(ArrayList<Person> people) {
		this.elsha3b = people;
	}

	public ArrayList<Party> getP() {
		return kolElA7zab;
	}

	public void setP(ArrayList<Party> p) {
		this.kolElA7zab = p;
	}

	public ArrayList<Candidate> getC() {
		return kolELA3da2;
	}

	public void setC(ArrayList<Candidate> c) {
		this.kolELA3da2 = c;
	}

}
