package agenda.api;

import java.util.List;

public interface AgendaService {
	List<Conference> listConferences();
	void saveConference(Conference conference);
}
