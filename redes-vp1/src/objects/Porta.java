package objects;

public abstract class Porta {
	private Boolean ligado;
	private String macAddress;
	private String ip;
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	private Cabo cabo;
	
	public Porta(String macAddress) {
		this.macAddress = macAddress;
		this.ligado = false;
	}
	
	public Porta(String macAddress, String Ip) {
		this.macAddress = macAddress;
		this.ip = Ip;
		this.ligado = false;
	}
	
	public void enviar(Pacote pacote) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: enviar (porta)");

		this.cabo.transmitir(pacote, this);
	}
	
	public abstract void receber(Pacote pacote);

	public Boolean getLigado() {
		return ligado;
	}

	public void setLigado(Boolean ligado) {
		this.ligado = ligado;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public Cabo getCabo() {
		return cabo;
	}

	public void setCabo(Cabo cabo) {
		this.cabo = cabo;
	}
}
