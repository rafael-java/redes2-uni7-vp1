package objects;

public class Pacote {
	private String MacOrigem;
	private String IpOrigem;
	private String MacDestino;
	private String IpDestino;
	private String payload;
	
	public void setMacDestino(String MacDestiny) {
		this.MacDestino=MacDestiny;
	}
	
	public Pacote(String macOrigem, String ipOrigem, String ipDestino, String dados) {
		super();
		MacOrigem = macOrigem;
		IpOrigem = ipOrigem;
		IpDestino = ipDestino;
		payload = dados;
	}
	public Pacote(String macOrigem, String ipOrigem, String macDestino, String ipDestino, String payload) {
		super();
		MacOrigem = macOrigem;
		IpOrigem = ipOrigem;
		MacDestino = macDestino;
		IpDestino = ipDestino;
		this.payload = payload;
	}
	
	private void esperar() {
		
	}


	
	
}
