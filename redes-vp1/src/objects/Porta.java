package objects;

import java.security.InvalidAlgorithmParameterException;

public abstract class Porta {
	private Boolean ligado;
	private String macAddress;

	private Cabo cabo;
		
	public Porta(String macAddress) throws InvalidAlgorithmParameterException {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: Porta(String macAddress)");
		if (!Singleton.getInstance().checkIfExists(macAddress)) {
			this.macAddress = macAddress;
			this.ligado = false;
			
			
		} else {
			throw new InvalidAlgorithmParameterException("Mac ou ip já existe na rede");
		}
	}
	
	public void enviar(Pacote pacote) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: enviar (porta)");

		this.cabo.transmitir(pacote, this);
	}
	
	public abstract void receber(Pacote pacote);

	public Boolean getLigado() {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:Boolean getLigado()");
		return ligado;
	}

	public void setLigado(Boolean ligado) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:setLigado(Boolean ligado)");
		this.ligado = ligado;
	}

	public String getMacAddress() {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:String getMacAddress()");
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:setMacAddress(String macAddress)");
		this.macAddress = macAddress;
	}

	public Cabo getCabo() {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:Cabo getCabo()");
		return cabo;
	}

	public void setCabo(Cabo cabo) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:setCabo(Cabo cabo)");
		this.cabo = cabo;
	}
}
