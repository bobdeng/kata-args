import java.util.Objects;

public class ArgValue {
    String value;

    public ArgValue(String value) {
        this.value = value;
    }

    public static ArgValue of(String value) {
        if (value == null) {
            return null;
        }
        if (isParamName(value)) {
            return null;
        }
        return new ArgValue(value);
    }

    private static boolean isParamName(String value) {
        return value.charAt(0) == '-' && value.length() == 2 && !isNumberChar(value.charAt(1));
    }

    private static boolean isNumberChar(char c) {
        return c >= '0' && c <= '9';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArgValue that = (ArgValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
