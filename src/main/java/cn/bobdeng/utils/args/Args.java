package cn.bobdeng.utils.args;

import java.util.HashMap;
import java.util.Map;

public class Args {
    Map<ArgName, ArgValue> args;

    public Args() {
        args = new HashMap<>();
    }

    public static Args of(String command) {
        Args args = new Args();
        args.parseCommand(command);
        return args;
    }

    private void parseCommand(String command) {
        String[] values = command.split("\\p{Blank}");
        parseArgs(values);
    }

    private void parseArgs(String[] values) {
        ArgValues argValues = new ArgValues(values);
        while (argValues.hasNext()) {
            parseNameValues(argValues);
        }

    }

    private void parseNameValues(ArgValues argValues) {
        ArgName argName = argValues.getNextName();
        if (argName != null) {
            ArgValue argValue = getArgValue(argValues);
            args.put(argName, argValue);
        }
    }

    private ArgValue getArgValue(ArgValues argValues) {
        return argValues.getArgValue(()->new ArgValue(null));
    }

    public String get(char name) {
        ArgValue argValue = args.get(new ArgName(name));
        return argValue.getValue();
    }
}
