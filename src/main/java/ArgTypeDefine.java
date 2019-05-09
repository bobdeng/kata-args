public class ArgTypeDefine<T> {
    ArgClass<T> clz;
    ArgDefaultValue<T> defaultValue;

    public ArgTypeDefine(ArgClass<T> clz, ArgDefaultValue<T> defaultValue) {
        this.clz = clz;
        this.defaultValue = defaultValue;
    }

    public static <T> ArgTypeDefine of(Class<T> type, T defaultValue) {
        return new ArgTypeDefine(new ArgClass(type), new ArgDefaultValue(defaultValue));
    }

    public T getDefaultValue() {
        return defaultValue.value;
    }

    public ArgConverter getArgConverter() {
        return clz.getArgConverter();
    }
}
