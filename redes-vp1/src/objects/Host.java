package objects;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Host {

	private String macAddress;
	private String ip;
	private HashMap<String, String> tabArp = new HashMap<>();
	private HashMap<String, Porta> tabEnc = new HashMap<>();
	private PortaHost portaHost;
	private Queue<Pacote> fila =  new LinkedList<Pacote>();
	
	public Host(String macAddress, String ip) {
		this.macAddress = macAddress;
		this.ip = ip;
	}

	public void enviar(String ipDestino, String payload) {
		Pacote pkg = new Pacote(this.macAddress, this.ip, ipDestino, payload);
		String macDestino = buscarARP(ipDestino);
		Pacote pkgToSend = null;
		if(macDestino != null) {
			pkgToSend = pkg;
			pkg.setMacDestino(macDestino);
		} else {
			Pacote arpPkg = new Pacote(this.macAddress, "FF:FF:FF:FF:FF:FF", this.ip, ip, true);
			pkgToSend = arpPkg;
			fila.add(pkg); // Adiciona na Fila o Pacote para que fique na espera de um ArpReply
		}
		
		this.portaHost.enviar(pkgToSend);
	}
	
	public void receber(Pacote pacote) {
		// Ao Receber o ArpReply Reenviar todas os Pacotes na Fila. 
	}
	
	private String buscarARP(String ip) {
		String buscado = this.tabArp.get(ip);
		return buscado;
	}
	
	private Porta buscarEnc(String macAddress) {
		Porta buscado = this.tabEnc.get(macAddress);
		return buscado;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public HashMap<String, String> getTabArp() {
		return tabArp;
	}

	public void setTabArp(HashMap<String, String> tabArp) {
		this.tabArp = tabArp;
	}

	public HashMap<String, Porta> getTabEnc() {
		return tabEnc;
	}

	public void setTabEnc(HashMap<String, Porta> tabEnc) {
		this.tabEnc = tabEnc;
	}

	public PortaHost getPortaHost() {
		return portaHost;
	}

	public void setPortaHost(PortaHost portaHost) {
		this.portaHost = portaHost;
	}

	public Queue<Pacote> getFila() {
		return fila;
	}

	public void setFila(Queue<Pacote> fila) {
		this.fila = fila;
	}
	
}
