package cn.bobdeng.utils.args;

public class ArgValue {
    String value;

    public ArgValue(String value) {
        this.value = value;
    }

    public static ArgValue of(String value) {
        if(ArgName.of(value)!=null){
            return null;
        }
        return new ArgValue(value);
    }

    public String getValue() {
        return value;
    }
}
