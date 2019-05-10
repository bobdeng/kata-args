package cn.bobdeng.utils.args;

public class CommandLine {
    Schemas schemas;
    Args args;

    CommandLine(Schemas schemas, Args args) {
        this.schemas = schemas;
        this.args = args;
    }

    public static CommandLine of(Schemas schemas, Args args) {
        return new CommandLine(schemas,args);
    }

    public <T> T getArg(char name, Class<T> clz) {
        String strValue = args.get(name);
        return schemas.getArgValue(name,strValue,clz);
    }
}
