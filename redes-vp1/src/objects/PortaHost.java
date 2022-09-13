package objects;

import java.security.InvalidAlgorithmParameterException;

public class PortaHost extends Porta {

	private Host host;
	private String ip;
	
	public PortaHost(String macAddress, String ip, Host host) throws InvalidAlgorithmParameterException {
		super(macAddress);
		if (!Singleton.getInstance().checkIfExists(ip)) {
			this.ip = ip;
			this.host = host;
			System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: new PortaHost");
		} else {
			throw new InvalidAlgorithmParameterException("Mac ou ip já existe na rede");
		}
	}
	
	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	@Override
	public void receber(Pacote pacote) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: receber (porta host)");

		this.host.receber(pacote, this);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
