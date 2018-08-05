package hello.dthnn;

public class Dht11 extends DhtNn {
	private static final long tbeDht11Time = 22000000;
											 										
	public Dht11() {
		super(msSleepDhtNnTime,  tbeDht11Time);
		setName("Dht11");
	}
	
	public Dht11(int ipin) {
		super(ipin, msSleepDhtNnTime,  tbeDht11Time);
		setName("Dht11");
	}
	
	@Override
	protected void calculateRhTemp() {
		if (checkParity()) {
			
			getMis().setRh( new Double(dhtNNRhInt) );
			getMis().setTemp(new Double(dhtNNTempInt));
		}
	}

}
