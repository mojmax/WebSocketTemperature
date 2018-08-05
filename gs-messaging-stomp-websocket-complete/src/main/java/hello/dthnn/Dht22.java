package hello.dthnn;

public class Dht22 extends DhtNn {
	
	private static final long tbeDht22Time = 18000000;
	
	protected int dhtNNRhInt_256, dhtNNRhDec_16, dhtNNRhDec_0, dhtNNTempInt_4096, dhtNNTempInt_256, dhtNNTempDec_16, dhtNNTempDec_0, sign= 0;
	
	public Dht22() {
		super(msSleepDhtNnTime,  tbeDht22Time);
		setName("Dht22");
	}
	
	public Dht22(int ipin) {
		super(ipin, msSleepDhtNnTime, tbeDht22Time);
		setName("Dht22");
	}
	@Override
	protected void calculateRhTemp() {
			
			dhtNNRhInt_256 		= validSamples.get(4)  << 3 | validSamples.get(5)  << 2 | validSamples.get(6)  << 1 | validSamples.get(7)  ;
			dhtNNRhDec_16 		= validSamples.get(8) << 3  | validSamples.get(9) << 2  | validSamples.get(10) << 1 | validSamples.get(11) ; 
			dhtNNRhDec_0 		= validSamples.get(12) << 3 | validSamples.get(13) << 2 | validSamples.get(14) << 1 | validSamples.get(15);
			dhtNNTempInt_4096 	= validSamples.get(16) << 3 | validSamples.get(17) << 2 | validSamples.get(18) << 1 | validSamples.get(19);
			dhtNNTempInt_256 	= validSamples.get(20) << 3 | validSamples.get(21) << 2 | validSamples.get(22) << 1 | validSamples.get(23);
			dhtNNTempDec_16 	= validSamples.get(24) << 3 | validSamples.get(25) << 2 | validSamples.get(26) << 1 | validSamples.get(27);
			dhtNNTempDec_0 		= validSamples.get(28) << 3 | validSamples.get(29) << 2 | validSamples.get(30) << 1 | validSamples.get(31);
			sign = validSamples.get(16) * -1;
			if (checkParity()) {
			
				getMis().setRh(new Double(dhtNNRhInt_256*256 + dhtNNRhDec_16*16 + dhtNNRhDec_0)/10) ;
				getMis().setTemp(new Double(dhtNNTempInt_256*256 + dhtNNTempDec_16*16 + dhtNNTempDec_0)/10);
			}
	}
	
}
