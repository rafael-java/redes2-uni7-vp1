package objects;

import java.security.InvalidAlgorithmParameterException;

public class PortaSwitch extends Porta {

	private Switch swi;
	
	public PortaSwitch(String macAddress, Switch swi) throws InvalidAlgorithmParameterException {
		super(macAddress);
		this.swi = swi;
	}

	@Override
	public void enviar(Pacote pacote) {
		System.out.println("Porta switch enviando...");
		super.enviar(pacote);
	}

	@Override
	public void receber(Pacote pacote) {
		System.out.println("Recebendo na porta switch...");

		swi.receber(pacote, this);
	}
	

	public Switch getSwi() {
		return swi;
	}

	public void setSwi(Switch swi) {
		this.swi = swi;
	}

}
