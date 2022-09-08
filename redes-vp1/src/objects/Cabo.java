package objects;

public class Cabo {
	private Porta ponta1;
	private Porta ponta2;

	public Cabo() {
		super();
	}

	public void transmitir(Pacote pacote, Porta origem) {
		if (ponta1 != null && ponta2 != null && ponta1.getLigado() && ponta2.getLigado()) {
			if (ponta1.equals(origem)) {
				ponta2.receber(pacote);
			} else {
				ponta1.receber(pacote);
			}
		} else { throw new NullPointerException(); }
	}

	public void atrelar(Porta ponta1, Porta ponta2) {
		this.ponta1 = ponta1;
		this.ponta2 = ponta2;
		ponta1.setLigado(true);
		ponta2.setLigado(true);
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
