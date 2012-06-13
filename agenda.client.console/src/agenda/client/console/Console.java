package agenda.client.console;

import java.util.List;

import org.osgi.service.log.LogService;

import agenda.api.AgendaService;
import agenda.api.Conference;

public class Console {
	private volatile AgendaService agendaService;
	private volatile LogService logService;

	public void listConferences() {
		logService.log(LogService.LOG_INFO, "Starting console...");
		
		List<Conference> conferences = agendaService.listConferences();
		if (conferences != null) {
			for (Conference conference : conferences) {
				System.out.println(conference);
			}
		} else {
			System.out.println("Agenda not available");
		}
	}
	
	public void addConference(String name, String location) {
		agendaService.saveConference(new Conference(name, location));
	}
}
