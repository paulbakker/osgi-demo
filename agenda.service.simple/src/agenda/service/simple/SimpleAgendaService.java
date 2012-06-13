package agenda.service.simple;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import agenda.api.AgendaService;
import agenda.api.Conference;

public class SimpleAgendaService implements AgendaService{
	private List<Conference> conferences = new CopyOnWriteArrayList<Conference>();
	
	public void start() {
		conferences.add(new Conference("Devoxx", "Antwerp"));
		conferences.add(new Conference("JavaOne", "SF"));
	}
	
	@Override
	public List<Conference> listConferences() {
		return conferences;
	}

	@Override
	public void saveConference(Conference conference) {
		conferences.add(conference);
	}

}
