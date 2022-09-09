package objects;

public class Pacote {
	private String macOrigem;
	private String ipOrigem;
	private String macDestino;
	private String ipDestino;
	private String payload;

	public Pacote(String macOrigem, String ipOrigem, String ipDestino, String payload) {
		this.macOrigem = macOrigem;
		this.ipOrigem = ipOrigem;
		this.ipDestino = ipDestino;
		this.payload = payload;
	}
	
	public Pacote(String macOrigem, String macDestino, String ipOrigem, String ipDestino, Boolean ARP) {
		this.macOrigem = macOrigem;
		this.ipOrigem = ipOrigem;
		this.macDestino = macDestino;
		this.ipDestino = ipDestino;
		if (ARP) {
			this.payload = "Request";
		} else {
			this.payload = "Reply";
		}
	}
	
	private void esperar() {
		
	}

	public String getMacOrigem() {
		return macOrigem;
	}

	public void setMacOrigem(String macOrigem) {
		this.macOrigem = macOrigem;
	}

	public String getIpOrigem() {
		return ipOrigem;
	}

	public void setIpOrigem(String ipOrigem) {
		this.ipOrigem = ipOrigem;
	}

	public String getMacDestino() {
		return macDestino;
	}

	public void setMacDestino(String macDestino) {
		this.macDestino = macDestino;
	}

	public String getIpDestino() {
		return ipDestino;
	}

	public void setIpDestino(String ipDestino) {
		this.ipDestino = ipDestino;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
}
