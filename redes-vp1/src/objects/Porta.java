package objects;

import java.security.InvalidAlgorithmParameterException;

public abstract class Porta {
	private Boolean ligado;
	private String macAddress;

	private Cabo cabo;
		
	public Porta(String macAddress) throws InvalidAlgorithmParameterException {
		System.out.println("Porta.Porta(String macAddress)");
		if (!Singleton.getInstance().checkIfExists(macAddress)) {
			this.macAddress = macAddress;
			this.ligado = false;
			
			
		} else {
			throw new InvalidAlgorithmParameterException("Mac ou ip já existe na rede");
		}
	}
	
	public void enviar(Pacote pacote) {
		System.out.println("Porta.enviar (porta)");

		System.out.println("this.cabo.transmitir(pacote, this)");
		this.cabo.transmitir(pacote, this);
	}
	
	public abstract void receber(Pacote pacote);

	public Boolean getLigado() {
		System.out.println("Porta.getLigado()");
		return ligado;
	}

	public void setLigado(Boolean ligado) {
		System.out.println("Porta.setLigado(Boolean ligado)");
		this.ligado = ligado;
	}

	public String getMacAddress() {
		System.out.println("Porta.getMacAddress()");
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		System.out.println("Porta.setMacAddress(String macAddress)");
		this.macAddress = macAddress;
	}

	public Cabo getCabo() {
		System.out.println("Porta.getCabo()");
		return cabo;
	}

	public void setCabo(Cabo cabo) {
		System.out.println("Porta.setCabo(Cabo cabo)");
		this.cabo = cabo;
	}
}
