package cn.bobdeng.utils.args;

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

    public ArgValue getArgValue() {
        if (!hasNext() || isArgName()) {
            return null;
        }
        return ArgValue.of(getValue());
    }

    private boolean isArgName() {
        return ArgName.of(getValue()) != null;
    }
}
