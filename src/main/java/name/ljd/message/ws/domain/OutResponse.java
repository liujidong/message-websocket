package name.ljd.message.ws.domain;

public class OutResponse {
	private String responseMessage;
	private String name;

	public OutResponse(InMessage message) {
		//super();
		this.responseMessage = message.getMessage();
		this.name = message.getName();
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public String getName() {
		return name;
	}
}
