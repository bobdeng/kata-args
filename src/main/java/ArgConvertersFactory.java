public class ArgConvertersFactory {
    static ArgConverter getArgConverter(Class type) {
        if (type == String.class) {
            return new StringConverter();
        }
        if (type == Integer.class) {
            return new IntegerConverter();
        }
        if (type == Boolean.class) {
            return new BooleanConverter();
        }
        return null;
    }

}
