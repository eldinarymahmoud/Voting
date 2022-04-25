package eg.edu.guc.voting.exceptions;

@SuppressWarnings("serial")
public class InvalidVoterException extends VotingException {
	public InvalidVoterException() {
		super();
	}

	public InvalidVoterException(String myMessage) {
		super(myMessage);
	}

}
