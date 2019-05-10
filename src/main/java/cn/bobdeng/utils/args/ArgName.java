package cn.bobdeng.utils.args;

import java.util.Objects;

public class ArgName {
    char name;

    public ArgName(char name) {
        this.name = name;
    }

    public static ArgName of(String value) {
        if (value.length() != 2) return null;
        if (value.charAt(0) != '-') return null;
        if(value.charAt(1)>='0' && value.charAt(1)<='9'){
            return null;
        }
        return new ArgName(value.charAt(1));
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
