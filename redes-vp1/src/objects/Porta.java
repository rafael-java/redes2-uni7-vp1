package objects;

import java.security.InvalidAlgorithmParameterException;

public abstract class Porta {
	private Boolean ligado;
	private String macAddress;

	private Cabo cabo;
		
	public Porta(String macAddress) throws InvalidAlgorithmParameterException {
		if (!Singleton.getInstance().checkIfExists(macAddress)) {
			this.macAddress = macAddress;
			this.ligado = false;
			
		} else {
			throw new InvalidAlgorithmParameterException("Mac ou ip já existe na rede");
		}
	}
	
	public void enviar(Pacote pacote) {
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
