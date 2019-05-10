package cn.bobdeng.utils.args;

import java.util.Optional;
import java.util.stream.Stream;

public class Schemas {
    Schema[] schemas;

    public Schemas(Schema[] schemas) {
        this.schemas = schemas;
    }

    public static Schemas of(Schema... schemas) {
        return new Schemas(schemas);
    }

    public <T> T getArgValue(char name, String value, Class<T> clz) {
        return (T) findByName(name)
                .map(schema -> schema.getValue(value))
                .orElse(null);
    }

    Optional<Schema> findByName(char name) {
        return Stream.of(schemas)
                .filter(schema -> schema.is(name))
                .findFirst();
    }
}
