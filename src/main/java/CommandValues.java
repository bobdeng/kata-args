public class CommandValues {
    Values values;
    ParserCursor cursor;

    public CommandValues(Values values, ParserCursor cursor) {
        this.values = values;
        this.cursor = cursor;
    }

    public static CommandValues of(String[] values) {
        return new CommandValues(new Values(values), new ParserCursor(0));
    }

    public void parse(OnArg onArg) {
        cursor = new ParserCursor(0);
        while (!cursor.isOver(values.size())) {
            parseNameValue(onArg);
        }
    }

    private boolean parseNameValue(OnArg onArg) {
        ArgName argName = getArgName();
        ArgValue argValue = getArgValue();
        putNameValue(argName, argValue, onArg);
        return argValue != null;
    }

    private void putNameValue(ArgName argName, ArgValue argValue, OnArg onArg) {
        if (argValue != null) {
            onArg.onArg(argName, argValue);
            cursor.next();
        }
    }

    private ArgName getArgName() {
        ArgName result = ArgName.of(values.getValue(cursor));
        cursor.next();
        return result;
    }

    private ArgValue getArgValue() {
        ArgValue paramValue = ArgValue.of(values.getValue(cursor));
        if (paramValue != null) {
            cursor.next();
        }
        return paramValue;
    }

}
