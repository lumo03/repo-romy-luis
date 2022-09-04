package trees;

public enum Answer {
	YES("ja"), NO("nein");

	String resValue;

	Answer(String resValue) {
		this.resValue = resValue;
	}

	public String getResponseValue() {
		return resValue;
	}
}
