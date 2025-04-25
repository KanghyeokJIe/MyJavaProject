package workshop.account.exception;

public class InsufficientBalanceException extends Exception {
	//private String errMessage;
	public InsufficientBalanceException(String errMessage) {
		//this.errMessage = errMessage;
		super(errMessage);
	}
}