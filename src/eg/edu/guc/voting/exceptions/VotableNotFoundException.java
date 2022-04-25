package eg.edu.guc.voting.exceptions;

@SuppressWarnings("serial")
public class VotableNotFoundException extends VotingException {
	public VotableNotFoundException() {
		super();
	}

	public VotableNotFoundException(String myMessage) {
		super(myMessage);
	}

}
