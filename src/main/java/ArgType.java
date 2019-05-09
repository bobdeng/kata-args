
public class ArgType<T> {
    char name;
    Class<T> type;
    T defaultValue;

    public ArgType(char name, Class<T> type, T defaultValue) {
        this.name = name;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    public static <T> ArgType<T> of(char name, Class<T> clz, T defaultValue) {
        return new ArgType<T>(name, clz, defaultValue);
    }

    public boolean is(char name) {
        return this.name==name;
    }

    public <T> T parse(String argStr) {
        if (argStr == null) {
            return (T) defaultValue;
        }
        ArgConverter argConverter = ArgConvertersFactory.getArgConverter(type);
        return (T) argConverter.fromString(argStr);
    }
}
