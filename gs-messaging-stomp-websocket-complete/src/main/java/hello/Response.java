package hello;

public class Response {
	private String content;
    private String hour;
    private String minute;
    private String seconds;
    private String temperature;
    private String umidity;
    private String scale;


    public void setContent(String content) {
		this.content = content;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public void setUmidity(String umidity) {
		this.umidity = umidity;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}


    public String getHour() {
		return hour;
	}

	public String getMinute() {
		return minute;
	}

	public String getSeconds() {
		return seconds;
	}

	public String getTemperature() {
		return temperature;
	}

	public String getUmidity() {
		return umidity;
	}

	public String getScale() {
		return scale;
	}

	
    public Response() {
    }
    
    
    @Override
    public String toString() {
    	return  "" +  scale + " : " + getTemperature() + " RH% : " + getUmidity() + " at " + getHour() + ":"  + getMinute() + ":" + getSeconds() ;
    }
    public String getContent() {
        return content;
    }

}
