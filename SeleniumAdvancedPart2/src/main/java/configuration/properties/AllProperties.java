package configuration.properties;

import configuration.models.Browser;
import configuration.models.Config;
import configuration.models.EnvironmentSpecification;
import configuration.helper.YamlReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


public class AllProperties {
    private static final Logger logger = LoggerFactory.getLogger(AllProperties.class);
 //   private static Object AllPropertiesSingleton;

    private List<EnvironmentSpecification> listOfEnvironments;

    YamlReader yamlReader = new YamlReader();
    Config config = yamlReader.getConfig();

    public AllProperties() {
        setBrowserProperties();
        setEnvironmentProperties();
    }

    public static AllProperties getInstance() {
        return AllPropertiesSingleton.INSTANCE;
    }
    private static class AllPropertiesSingleton {
        private static final AllProperties INSTANCE = new AllProperties();
    }

    private void setBrowserProperties() {
        Browser browser = config.getBrowser();
        Map<String, Object> browserProperties = browser.getProperties();
        browserProperties.forEach((key, value) -> {
            System.setProperty(key, value.toString());
            logger.info("Load env properties: {} = {}", key, value);
        });
    }

    private void setEnvironmentProperties() {

        listOfEnvironments = config.getEnvironments().getEnvironmentsName();
        for (EnvironmentSpecification environment : listOfEnvironments) {
            if (environment.getProperties().get("envName").equals(config.getActiveEnv())) {

                Map<String, Object> activeEnvProperties = environment.getProperties();
                activeEnvProperties.forEach((key, value) -> {
                    System.setProperty(key, value.toString());
                    logger.info("Load env properties: {} = {}", key, value);

                });
                break;
            }
        }
    }

}

