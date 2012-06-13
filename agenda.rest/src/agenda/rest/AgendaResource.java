package agenda.rest;

import java.io.IOException;
import java.io.StringWriter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.ServiceDependency;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import agenda.api.AgendaService;

@Component(provides=Object.class)
@Path("agenda")
public class AgendaResource {
	@ServiceDependency
	private volatile AgendaService agendaService;
	
	@GET
	@Produces("application/json")
	public String listConferences() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		StringWriter writer = new StringWriter();
		mapper.writeValue(writer, agendaService.listConferences());
		
		return writer.toString();
	}
}
