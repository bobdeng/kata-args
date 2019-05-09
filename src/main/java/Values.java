public class Values {
    String[] values;

    public Values(String[] values) {
        this.values = values;
    }

    public int size() {
        return values.length;
    }

    public String getValue(ParserCursor cursor) {
        if(cursor.isOver(values.length)){
            return null;
        }
        return values[cursor.cursor];
    }
}
