package agenda.client.console;

import java.util.Properties;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.apache.felix.service.command.CommandProcessor;
import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogService;

import agenda.api.AgendaService;

public class Activator extends DependencyActivatorBase {

	@Override
	public void init(BundleContext context, DependencyManager manager)
			throws Exception {
		Properties properties = new Properties();
		properties.put(CommandProcessor.COMMAND_SCOPE, "agenda");
		properties.put(CommandProcessor.COMMAND_FUNCTION, new String[] {"listConferences", "addConference"});
		
		
		manager.add(createComponent().setInterface(Object.class.getName(), properties).setImplementation(Console.class)
				.add(createServiceDependency().setService(AgendaService.class, "(persistent=true)").setRequired(true))
				.add(createServiceDependency().setService(LogService.class).setRequired(false)));
	}

	@Override
	public void destroy(BundleContext context, DependencyManager manager)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
