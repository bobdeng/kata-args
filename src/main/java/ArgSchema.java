import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ArgSchema {
    List<ArgType> types;

    public ArgSchema(List<ArgType> types) {
        this.types = types;
    }

    public static ArgSchema as(ArgType... types) {
        return new ArgSchema(Arrays.asList(types));
    }

    public Optional<ArgType> getArg(char name) {
        return types.stream()
                .filter(argType -> argType.is(name))
                .findFirst();
    }
}
