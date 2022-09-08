package objects;

public class PortaHost extends Porta {

	private Host host;
	
	public PortaHost(int id, boolean ligado, String macAddress) {
		super(id, ligado, macAddress);
	}
	
	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

}
