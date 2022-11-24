package configuration.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Config {

    public Browser browser;

    public String activeEnv;

    public Environment environments;

}
