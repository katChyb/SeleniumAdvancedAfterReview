package configuration.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import configuration.models.Config;
import lombok.SneakyThrows;

import java.io.File;

public class YamlReader {

    private Config config;

    @SneakyThrows
    public YamlReader() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        this.config = mapper.readValue(new File("src/main/resources/config.yaml"), Config.class);
    }

    public Config getConfig() {
        return config;
    }

}
