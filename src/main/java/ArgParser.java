import java.util.HashMap;
import java.util.Map;

public class ArgParser {
    ArgSchema schema;
    CommandArgs commandArgs;

    private ArgParser(ArgSchema schema) {
        this.schema = schema;
    }

    public static ArgParser of(ArgSchema argSchema) {
        return new ArgParser(argSchema);
    }

    public void parse(String command) {
        commandArgs=CommandArgs.of(command);

    }


    public <T> T getArg(char name) {
        ArgType<T> argType = schema.getArg(name).orElse(null);
        T value = argType.parse(getArgString(name));
        return value;
    }

    private String getArgString(char name) {
        return commandArgs.getArg(String.valueOf(name));
    }
}
