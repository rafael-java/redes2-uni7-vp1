package objects;

public class Cabo {
	private Porta ponta1;
	private Porta ponta2;

	public Cabo() {
		super();
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: new Cabo");
	}

	public void transmitir(Pacote pacote, Porta origem) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: transmitir (cabo)");

		if (ponta1 != null && ponta2 != null && ponta1.getLigado() && ponta2.getLigado()) {
			if (ponta1.equals(origem)) {
				ponta2.receber(pacote);
			} else {
				ponta1.receber(pacote);
			}
		} else { throw new NullPointerException(); }
	}

	public void atrelar(Porta ponta1, Porta ponta2) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: atrelar (cabo)");

		this.ponta1 = ponta1;
		this.ponta2 = ponta2;
		ponta1.setLigado(true);
		ponta1.setCabo(this);
		ponta2.setLigado(true);
		ponta2.setCabo(this);
		
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
