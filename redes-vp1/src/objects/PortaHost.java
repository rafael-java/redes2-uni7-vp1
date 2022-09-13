package objects;

public class PortaHost extends Porta {

	private Host host;
	
	public PortaHost(String macAddress, Host host) {
		super(macAddress);
		this.host = host;
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: new PortaHost");
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
}
