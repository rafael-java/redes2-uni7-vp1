package objects;

public class Cabo {
	private Porta ponta1;
	private Porta ponta2;
		
	public Cabo(Porta ponta1, Porta ponta2) {
		super();
		this.ponta1 = ponta1;
		this.ponta2 = ponta2;
	}
	
	public void transmitir(Pacote pacote, Porta origem) {
//		if(ponta1.equals(origem)) {
//			ponta2.receber(pacote);
//		}else {
//			ponta1.receber(pacote);
//		}
	}
	
	public void atrelar(Porta portaHost, Porta portaSwitch) {
//		this.ponta1=porta1;
//		this.ponta2=porta2;
	}

	public Porta getPonta1() {
		return ponta1;
	}

	public void setPonta1(Porta ponta1) {
		this.ponta1 = ponta1;
	}

	public Porta getPonta2() {
		return ponta2;
	}

	public void setPonta2(Porta ponta2) {
		this.ponta2 = ponta2;
	}
	
}
