package objects;

public class PortaSwitch extends Porta {

	private Switch swi;
	
	public PortaSwitch(int id, boolean ligado, String macAddress, Switch swi) {
		super(id, ligado, macAddress);
		this.swi = swi;
	}

	public Switch getSwi() {
		return swi;
	}

	public void setSwi(Switch swi) {
		this.swi = swi;
	}
	
	

}
