package eg.edu.guc.voting.participants;

public interface Votable {
	void giveVote();

	int countVotes();

	String getId();

}
