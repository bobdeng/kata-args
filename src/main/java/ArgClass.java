public class ArgClass<T> {
    Class<T> clz;

    public ArgClass(Class<T> clz) {
        this.clz = clz;
    }

    public ArgConverter getArgConverter() {
        return ArgConvertersFactory.getArgConverter(clz);
    }
}
