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
			System.out.println("new PortaHost");
		} else {
			throw new InvalidAlgorithmParameterException("Mac ou ip já existe na rede");
		}
	}
	
	public Host getHost() {
		System.out.println("PortaHost.getHost");
		return host;
	}

	public void setHost(Host host) {
		System.out.println("PortaHost.setHost(Host host)");
		this.host = host;
	}

	@Override
	public void receber(Pacote pacote) {
		System.out.println("PortaHost.receber (porta host)");

		this.host.receber(pacote, this);
	}

	public String getIp() {
		System.out.println("PortaHost.getIp()");
		return ip;
	}

	public void setIp(String ip) {
		System.out.println("PortaHost.setIp(String ip)");
		this.ip = ip;
	}
}
