package cn.bobdeng.utils.args;

public class Schema<T> {
    char name;
    Class<T> clz;
    T defaultValue;

    public Schema(char name, Class<T> clz, T defaultValue) {
        this.name = name;
        this.clz = clz;
        this.defaultValue = defaultValue;
    }

    public static <T> Schema<T> of(char name, Class<T> clz, T defaultValue) {
        return new Schema<>(name, clz, defaultValue);
    }

    public Object getValue(String value){
        if (value == null) {
            return defaultValue;
        }
        return ValueConverterFactory.parseObject(value, clz);
    }

    public boolean is(char name) {
        return this.name==name;
    }
}
