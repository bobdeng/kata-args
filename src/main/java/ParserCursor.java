public class ParserCursor {
    int cursor;

    public ParserCursor(int cursor) {
        this.cursor = cursor;
    }

    public boolean isOver(int length) {
        return cursor>=length;
    }

    public void next() {
        cursor++;
    }
}
