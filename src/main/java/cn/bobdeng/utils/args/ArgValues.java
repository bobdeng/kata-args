package cn.bobdeng.utils.args;

import java.util.function.Supplier;

public class ArgValues {
    String[] values;
    int index;

    public ArgValues(String[] values) {
        this.values = values;
        index = 0;
    }

    public boolean hasNext() {
        return index < values.length;
    }

    public ArgName getNextName() {
        if (!hasNext()) {
            return null;
        }
        ArgName argName=ArgName.of(getValue());
        next();
        return argName;
    }

    private void next() {
        index++;
    }

    private String getValue() {
        return values[index];
    }

    public ArgValue getArgValue(Supplier<ArgValue> defaultValue) {
        if (!hasNext() || isArgName()) {
            return defaultValue.get();
        }
        return ArgValue.of(getValue());
    }

    private boolean isArgName() {
        return ArgName.of(getValue()) != null;
    }
}
