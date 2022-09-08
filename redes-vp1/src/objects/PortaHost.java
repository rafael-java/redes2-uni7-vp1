package objects;

public class PortaHost extends Porta {

	private Host host;
	
	public PortaHost(int id, String macAddress, Host host) {
		super(id, macAddress);
		this.host = host;
	}
	
	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	@Override
	public void enviar(Pacote pacote) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receber(Pacote pacote) {
		// TODO Auto-generated method stub
		
	}

}
