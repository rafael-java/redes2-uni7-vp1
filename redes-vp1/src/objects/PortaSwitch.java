package objects;

public class PortaSwitch extends Porta {

	private Switch swi;
	
	public PortaSwitch(int id, String macAddress, Switch swi) {
		super(id, macAddress);
		this.swi = swi;
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: new PortaSwitch");
	}

	public Switch getSwi() {
		return swi;
	}

	public void setSwi(Switch swi) {
		this.swi = swi;
	}


	@Override
	public void receber(Pacote pacote) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: receber (porta switcch)");

		swi.receber(pacote, this);
	}

}
