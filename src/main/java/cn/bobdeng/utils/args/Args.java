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
        for (int i = 0; i < values.length; i++) {
            ArgName argName = ArgName.of(values[i]);
            ArgValue argValue = null;
            if (argName != null) {
                if (i + 1 < values.length) {
                    argValue = ArgValue.of(values[i + 1]);
                    if (argValue != null) {
                        i++;
                    } else {
                        argValue = new ArgValue(null);
                    }
                } else {
                    argValue = new ArgValue(null);
                }
                args.put(argName, argValue);
            }
        }
    }

    public String get(char name) {
        ArgValue argValue = args.get(new ArgName(name));
        return argValue.getValue();
    }
}
