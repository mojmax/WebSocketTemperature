package hello.dthnn;

import com.pi4j.temperature.TemperatureConversion;
import com.pi4j.temperature.TemperatureScale;

import static com.pi4j.temperature.TemperatureScale.*;


public class DhtNnValues {
	
	private double temp = 0.0;
	private double rh = 0.0;
	private TemperatureScale scale = CELSIUS;
	
	public synchronized double getRh() {
		return rh;
	}

	public synchronized void setRh(double rh) {
		this.rh = rh;
	}

	public synchronized double getTemp() {
		double out = 0.0;
		if(scale ==CELSIUS) {
			out = temp;
		}
		else if(scale==FARENHEIT) {
			out = TemperatureConversion.convert(CELSIUS, FARENHEIT, temp);
		}
		else if(scale==KELVIN) {
			out = TemperatureConversion.convert(CELSIUS, KELVIN, temp);
			
		} else if(scale==RANKINE) {
			out = TemperatureConversion.convert(CELSIUS, RANKINE, temp);
		}
		return out;
	}

	public synchronized void setTemp(double temp) {
		this.temp = temp;
	}
	

	public String toString() {
		return " Umidity " + rh + " temp " + temp + " " +scale;
	}

	public synchronized TemperatureScale getScale() {
		return scale;
	}

	public synchronized void setScale(TemperatureScale scale) {
		this.scale = scale;
	};
	
	public synchronized void changeScale() {
		switch (this.scale) {
		case CELSIUS:
			this.scale = FARENHEIT;
			break;
		case FARENHEIT:
			this.scale = KELVIN;
			break;
		case KELVIN:
			this.scale = RANKINE;
			break;
		case RANKINE:
			this.scale = CELSIUS;
			break;

		default:
			this.scale = CELSIUS;
			break;
		}
	};

}
