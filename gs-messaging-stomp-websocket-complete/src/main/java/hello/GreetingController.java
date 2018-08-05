package hello;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


import hello.dthnn.Dht22;

@Controller
public class GreetingController {
	Dht22 dht = new Dht22();

	@MessageMapping("/hello")
	@SendTo("/topic/temperature")
	public Response getMessage(HelloMessage message) throws Exception {
		
		Thread.sleep(1000);
		return getResponse();
	}

	@MessageMapping("/scale")
	@SendTo("/topic/temperature")
	public Response changeScale() throws Exception {

		dht.getMis().changeScale();
		Thread.sleep(1000);
		return getResponse();
	}

	private Response getResponse() {
		
		Calendar cal = new GregorianCalendar();
		Response resp = new Response();
		resp.setHour(String.valueOf(cal.get(Calendar.HOUR)));
		resp.setMinute(String.valueOf(cal.get(Calendar.MINUTE)));
		resp.setSeconds(String.valueOf(cal.get(Calendar.SECOND)));
		resp.setScale(String.valueOf(dht.getMis().getScale().getName()));
		resp.setTemperature(String.format("%+3.2f",dht.getMis().getTemp()));
		resp.setUmidity(String.format("%2.2f",dht.getMis().getRh()));
		resp.setContent(resp.toString());

		return resp;

	}

}
