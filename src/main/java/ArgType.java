
public class ArgType<T> {
    ArgName name;
    ArgTypeDefine<T> type;

    public ArgType(char name, Class<T> type, T defaultValue) {
        this.name = new ArgName(name);
        this.type = ArgTypeDefine.of(type,defaultValue);
    }

    public static <T> ArgType<T> of(char name, Class<T> clz, T defaultValue) {
        return new ArgType<T>(name, clz, defaultValue);
    }

    public boolean is(char name) {
        return this.name.is(name);
    }

    public <T> T parse(ArgValue argValue) {
        if (argValue == null) {
            return (T) type.getDefaultValue();
        }
        ArgConverter argConverter = type.getArgConverter();
        return (T) argConverter.fromString(argValue.value);
    }
}
