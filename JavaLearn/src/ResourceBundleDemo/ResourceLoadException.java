package ResourceBundleDemo;

public class ResourceLoadException extends Exception {

	private Throwable cause = null;

	public ResourceLoadException() {
		super();
	}

	public ResourceLoadException(String message) {
		super(message);
	}

	public ResourceLoadException(String message, Throwable cause) {
		super(message);
		this.cause = cause;
	}

	public Throwable getCause() {
		return cause;
	}
}
