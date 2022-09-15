package objects;

import java.security.InvalidAlgorithmParameterException;

public class PortaSwitch extends Porta {

	private Switch swi;
	
	public PortaSwitch(String macAddress, Switch swi) throws InvalidAlgorithmParameterException {
		super(macAddress);
		this.swi = swi;
		System.out.println("new PortaSwitch(String macAddress, Switch swi)");
		System.out.println("throws InvalidAlgorithmParameterException");
	}

	public Switch getSwi() {
		System.out.println("Switch PortaSwitch.getSwi()");
		return swi;
	}

	public void setSwi(Switch swi) {
		System.out.println("Switch PortaSwitch.setSwi(Switch swi)");
		this.swi = swi;
	}


	@Override
	public void receber(Pacote pacote) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: receber (porta switcch)");

		swi.receber(pacote, this);
	}

}
