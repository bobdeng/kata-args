import java.util.Objects;

public class ArgName {
    char name;

    public ArgName(char name) {
        this.name = name;
    }

    public static ArgName of(String value) {
        return new ArgName(value.charAt(1));
    }

    public boolean is(char name) {
        return this.name==name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArgName argName = (ArgName) o;
        return name == argName.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
