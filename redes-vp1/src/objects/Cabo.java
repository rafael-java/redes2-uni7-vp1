package objects;

public class Cabo {
	private Porta ponta1;
	private Porta ponta2;

	public Cabo() {
		super();
		System.out.println("new Cabo()");
	}

	public void transmitir(Pacote pacote, Porta origem) {
		System.out.println("Cabo.transmitir(Pacote pacote, Porta origem)");
		System.out.println("Pode lançar uma excessao");
		
		if (ponta1 != null && ponta2 != null && ponta1.getLigado() && ponta2.getLigado()) {
			if (ponta1.equals(origem)) {
				System.out.println("if ponta1.equals(origem)");
				System.out.println("ponta2.receber(pacote)");
				this.getPonta2().receber(pacote);
			} else {
				System.out.println("if ponta2.equals(origem)");
				System.out.println("ponta1.receber(pacote)");
				this.getPonta1().receber(pacote);
			}
		} else { throw new NullPointerException(); }
	}

	public void atrelar(Porta ponta1, Porta ponta2) {
		System.out.println("Cabo.atrelar(Porta ponta1, Porta ponta2)");

		this.ponta1 = ponta1;
		this.ponta2 = ponta2;
		System.out.println("ponta1.set...");

		ponta1.setLigado(true);
		ponta1.setCabo(this);
		
		System.out.println("ponta2.set...");
		ponta2.setLigado(true);
		ponta2.setCabo(this);
		
	}

	public Porta getPonta1() {
		System.out.println("Cabo.getPonta1()");
		return ponta1;
	}

	public void setPonta1(Porta ponta1) {
		System.out.println("Cabo.setPonta1");
		this.ponta1 = ponta1;
	}

	public Porta getPonta2() {
		System.out.println("Cabo.getPonta2()");
		return ponta2;
	}

	public void setPonta2(Porta ponta2) {
		System.out.println("Cabo.setPonta2(Porta ponta2)");
		this.ponta2 = ponta2;
	}

}
