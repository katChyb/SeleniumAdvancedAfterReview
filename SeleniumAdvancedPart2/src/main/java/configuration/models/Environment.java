package configuration.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class Environment {

    Map<String, EnvironmentSpecification> environments = new LinkedHashMap<>();


    @JsonAnySetter
    public void setEnvironments(String key, EnvironmentSpecification value) {
        environments.put(key, value);
    }

    @JsonAnyGetter
    public List<EnvironmentSpecification> getEnvironmentsName() {
        return environments.values().stream().toList();
    }
    }

