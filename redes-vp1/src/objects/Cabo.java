package objects;

public class Cabo {
	private Porta ponta1;
	private Porta ponta2;
	
	public void transmitir(Pacote pacote, Porta origem) {
		if(ponta1.equals(origem)) {
			ponta2.receber(pacote);
		}else {
			ponta1.receber(pacote);
		}
	}
	
	public void atrelar(Porta porta1, Porta porta2) {
		this.ponta1=porta1;
		this.ponta2=porta2;
	}
	
}
