package objects;

public abstract class Porta {
	private Integer id;
	private Boolean ligado;
	private String macAddress;
	private Cabo cabo;
	
	public Porta(int id, boolean ligado, String macAddress) {
		
	}
	
	public void enviar(Pacote pacote) {
		//this.cabo.
	}
	
	public void receber(Pacote pacote) {
		
	}

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
