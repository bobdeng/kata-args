import java.util.HashMap;
import java.util.Map;

public class CommandArgs {
    Map<ArgName, ArgValue> parameters;

    public static CommandArgs of(String command) {
        CommandArgs commandArgs=new CommandArgs();
        commandArgs.parameters=new HashMap<>();
        commandArgs.parse(command);
        return commandArgs;
    }

    private void parse(String command) {
        String[] values=command.split("\\p{Blank}");
        if(values.length>0){
            parseValues(values);
        }
    }

    private void parseValues(String[] values) {
        CommandValues commandValues=CommandValues.of(values);
        commandValues.parse((name, value) -> parameters.put(name,value));
    }

    public ArgValue getArg(char name) {
        return parameters.get(new ArgName(name));
    }
}
