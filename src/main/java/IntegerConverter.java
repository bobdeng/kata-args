public class IntegerConverter implements ArgConverter {
    @Override
    public Integer fromString(String value) {
        return new Integer(value);
    }
}
