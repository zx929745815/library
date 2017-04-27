package xtu.library.web.exception;

public class NullSessionException extends Exception {

	public NullSessionException() {
		System.err.println("session失效，请重新登陆。");
	}
}
