package cn.bobdeng.utils.args;

public class Schemas {
    Schema[] schemas;

    public Schemas(Schema[] schemas) {
        this.schemas = schemas;
    }

    public static Schemas of(Schema... schemas) {
        return new Schemas(schemas);
    }

    public <T>T getArgValue(char name, String value,Class<T> clz) {
        for(int i=0;i<schemas.length;i++){
            if(schemas[i].name==name){
                return (T)schemas[i].getValue(value);
            }
        }
        return null;
    }
}
