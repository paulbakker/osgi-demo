package agenda.service.mongo;

import java.util.ArrayList;
import java.util.List;

import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;

import org.amdatu.mongo.MongoDBService;
import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.Property;
import org.apache.felix.dm.annotation.api.ServiceDependency;

import com.mongodb.DBCollection;

import agenda.api.AgendaService;
import agenda.api.Conference;

@Component(properties = {@Property(name="persistent", value="true")})
public class MongoAgendaService implements AgendaService{

	@ServiceDependency volatile MongoDBService mongoDBService;
	
	@Override
	public List<Conference> listConferences() {

		DBCollection collection = mongoDBService.getDB().getCollection("conferences");
		JacksonDBCollection<Conference, Object> conferences = JacksonDBCollection.wrap(collection, Conference.class);
		DBCursor<Conference> cursor = conferences.find();
		List<Conference> result = new ArrayList<Conference>();
		while(cursor.hasNext()) {
			result.add(cursor.next());
		}
		
		return result;
	}

	@Override
	public void saveConference(Conference conference) {
		DBCollection collection = mongoDBService.getDB().getCollection("conferences");
		JacksonDBCollection<Conference, Object> conferences = JacksonDBCollection.wrap(collection, Conference.class);
		
		conferences.save(conference);
	}

}
