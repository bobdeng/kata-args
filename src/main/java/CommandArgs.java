import java.util.HashMap;
import java.util.Map;

public class CommandArgs {
    Map<String,String> parameters;
    int index;
    public static CommandArgs of(String command) {
        CommandArgs commandArgs=new CommandArgs();
        commandArgs.parameters=new HashMap<>();
        commandArgs.parse(command);
        return commandArgs;
    }

    private void parse(String command) {
        String[] values=command.split("\\p{Blank}");
        if(values.length>0){
            parse(values);
        }
    }
    private void parse(String[] values) {
        index=0;
        while(index<values.length-1) {
            parseNameValue(values, index);
            index++;
        }
    }

    private boolean parseNameValue(String[] values,int index) {
        char argName = getArgName(values,index);
        String argValue = getArgValue(values, index);
        putNameValue(index, argName, argValue);
        return argValue!=null;
    }

    private void putNameValue(int index, char argName, String argValue) {
        if (argValue != null) {
            index++;
            parameters.put(String.valueOf(argName),argValue);
        }
    }

    private char getArgName(String[] values,int index) {
        return values[index].charAt(1);
    }

    private String getArgValue(String[] values, int index) {
        if(values.length<=index+1){
            return null;
        }
        if(isParamName(values[index + 1])){
            return null;
        }
        return values[index+1];
    }

    private boolean isParamName(String value) {
        return value.charAt(0)=='-' && value.length()==2 && !isNumberChar(value.charAt(1));
    }

    private boolean isNumberChar(char c){
        return c>='0' && c<='9';
    }

    public String getArg(String name) {
        return parameters.get(name);
    }
}
