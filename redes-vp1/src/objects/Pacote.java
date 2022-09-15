package objects;

public class Pacote {
	private String macOrigem;
	private String ipOrigem;
	private String macDestino;
	private String ipDestino;
	private String payload;

	public Pacote(String macOrigem, String ipOrigem, String ipDestino, String payload) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: new pacote (normal)");

		this.macOrigem = macOrigem;
		this.ipOrigem = ipOrigem;
		this.ipDestino = ipDestino;
		this.payload = payload;
	}
	
	public Pacote(String macOrigem, String macDestino, String ipOrigem, String ipDestino, Boolean ARPRequest) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: new pacote (ARP)");

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
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:String getMacOrigem()");
		return macOrigem;
	}

	public void setMacOrigem(String macOrigem) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:setMacOrigem(String macOrigem)");
		this.macOrigem = macOrigem;
	}

	public String getIpOrigem() {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:String getIpOrigem()");
		return ipOrigem;
	}

	public void setIpOrigem(String ipOrigem) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:setIpOrigem(String ipOrigem)");
		this.ipOrigem = ipOrigem;
	}

	public String getMacDestino() {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:String getMacDestino()");
		return macDestino;
	}

	public void setMacDestino(String macDestino) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: set mac destino (pacote)");

		this.macDestino = macDestino;
	}

	public String getIpDestino() {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:String getIpDestino()");
		return ipDestino;
	}

	public void setIpDestino(String ipDestino) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:setIpDestino(String ipDestino)");
		this.ipDestino = ipDestino;
	}

	public String getPayload() {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:String getPayload()");
		return payload;
	}

	public void setPayload(String payload) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:setPayload(String payload)");
		this.payload = payload;
	}
}
