package eg.edu.guc.voting.exceptions;

@SuppressWarnings("serial")
public class MultipleVoteException extends VotingException {
	public MultipleVoteException() {
		super();
	}

	public MultipleVoteException(String myMessage) {
		super(myMessage);
	}

}
