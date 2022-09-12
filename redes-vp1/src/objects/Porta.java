package objects;

public abstract class Porta {
	private Integer id;
	private Boolean ligado;
	private String macAddress;
	private Cabo cabo;
	
	public Porta(int id, String macAddress) {
		this.ligado = false;
	}
	
	public void enviar(Pacote pacote) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: enviar (porta)");

		this.cabo.transmitir(pacote, this);
	}
	
	public abstract void receber(Pacote pacote);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
