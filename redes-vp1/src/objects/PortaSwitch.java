package objects;

public class PortaSwitch extends Porta {

	private Switch swi;
	
	public PortaSwitch(int id, String macAddress, Switch swi) {
		super(id, macAddress);
		this.swi = swi;
	}

	public Switch getSwi() {
		return swi;
	}

	public void setSwi(Switch swi) {
		this.swi = swi;
	}

	@Override
	public void enviar(Pacote pacote) {
		
	}

	@Override
	public void receber(Pacote pacote) {
		swi.receber(pacote, this);
	}
	
	

}
