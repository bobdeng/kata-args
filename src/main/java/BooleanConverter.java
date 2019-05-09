public class BooleanConverter implements ArgConverter {
    @Override
    public Boolean fromString(String value) {
        return value.equalsIgnoreCase("true");
    }
}
