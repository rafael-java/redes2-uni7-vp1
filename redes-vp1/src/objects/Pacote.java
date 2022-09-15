package objects;

public class Pacote {
	private String macOrigem;
	private String ipOrigem;
	private String macDestino;
	private String ipDestino;
	private String payload;

	public Pacote(String macOrigem, String ipOrigem, String ipDestino, String payload) {
		System.out.println("new pacote (String macOrigem, String ipOrigem, String ipDestino, String payload)");

		this.macOrigem = macOrigem;
		this.ipOrigem = ipOrigem;
		this.ipDestino = ipDestino;
		this.payload = payload;
	}
	
	public Pacote(String macOrigem, String macDestino, String ipOrigem, String ipDestino, Boolean ARPRequest) {
		System.out.println("new pacote (String macOrigem, String macDestino, String ipOrigem, String ipDestino, Boolean ARPRequest)");

		this.macOrigem = macOrigem;
		this.ipOrigem = ipOrigem;
		this.macDestino = macDestino;
		this.ipDestino = ipDestino;
		if (ARPRequest) {
			this.payload = "Request";
		} else {
			this.payload = "Reply";
		}
	}

	public String getMacOrigem() {
		System.out.println("Pacote.getMacOrigem()");
		return macOrigem;
	}

	public void setMacOrigem(String macOrigem) {
		System.out.println("Pacote.setMacOrigem(String macOrigem)");
		this.macOrigem = macOrigem;
	}

	public String getIpOrigem() {
		System.out.println("Pacote.getIpOrigem()");
		return ipOrigem;
	}

	public void setIpOrigem(String ipOrigem) {
		System.out.println("Pacote.setIpOrigem(String ipOrigem)");
		this.ipOrigem = ipOrigem;
	}

	public String getMacDestino() {
		System.out.println("Pacote.getMacDestino()");
		return macDestino;
	}

	public void setMacDestino(String macDestino) {
		System.out.println("Pacote.setMacDestino(String macDestino)");

		this.macDestino = macDestino;
	}

	public String getIpDestino() {
		System.out.println("Pacote.getIpDestino()");
		return ipDestino;
	}

	public void setIpDestino(String ipDestino) {
		System.out.println("Pacote.setIpDestino(String ipDestino)");
		this.ipDestino = ipDestino;
	}

	public String getPayload() {
		System.out.println("Pacote.getPayload()");
		return payload;
	}

	public void setPayload(String payload) {
		System.out.println("Pacote.setPayload(String payload)");
		this.payload = payload;
	}
}
