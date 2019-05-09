import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TestArgs {
    @Test
    public void test_boolean_default_true(){
        ArgSchema argSchema=ArgSchema.as(ArgType.of('l',Boolean.class,true));
        ArgParser argParser=ArgParser.of(argSchema);
        argParser.parse("-l ");
        Boolean arg=argParser.getArg('l');
        assertNotNull(arg);
        assertTrue(arg.booleanValue());
    }

    @Test
    public void test_boolean_default_false(){
        ArgSchema argSchema=ArgSchema.as(ArgType.of('l',Boolean.class,false));
        ArgParser argParser=ArgParser.of(argSchema);
        argParser.parse("-l ");
        Boolean arg=argParser.getArg('l');
        assertNotNull(arg);
        assertFalse(arg.booleanValue());
    }
    @Test
    public void test_boolean_has_value(){
        ArgSchema argSchema=ArgSchema.as(ArgType.of('l',Boolean.class,false));
        ArgParser argParser=ArgParser.of(argSchema);
        argParser.parse("-l true");
        Boolean arg=argParser.getArg('l');
        assertNotNull(arg);
        assertTrue(arg.booleanValue());
    }
    @Test
    public void test_string_default_hello(){
        ArgSchema argSchema=ArgSchema.as(ArgType.of('n',String.class,"hello"));
        ArgParser argParser=ArgParser.of(argSchema);
        argParser.parse("-n ");
        String arg=argParser.getArg('n');
        assertNotNull(arg);
        assertEquals(arg,"hello");
    }

    @Test
    public void test_string_has_value(){
        ArgSchema argSchema=ArgSchema.as(ArgType.of('n',String.class,"hello"));
        ArgParser argParser=ArgParser.of(argSchema);
        argParser.parse("-n world");
        String arg=argParser.getArg('n');
        assertEquals(arg,"world");
    }

    @Test
    public void test_int_default_hello(){
        ArgSchema argSchema=ArgSchema.as(ArgType.of('p',Integer.class,8080));
        ArgParser argParser=ArgParser.of(argSchema);
        argParser.parse("-p ");
        Integer arg=argParser.getArg('p');
        assertEquals(arg.intValue(),8080);
    }
    @Test
    public void test_int_has_value(){
        ArgSchema argSchema=ArgSchema.as(ArgType.of('p',Integer.class,8080));
        ArgParser argParser=ArgParser.of(argSchema);
        argParser.parse("-p 80");
        Integer arg=argParser.getArg('p');
        assertEquals(arg.intValue(),80);
    }

    @Test
    public void test_int_has_nagative_value(){
        ArgSchema argSchema=ArgSchema.as(ArgType.of('p',Integer.class,8080));
        ArgParser argParser=ArgParser.of(argSchema);
        argParser.parse("-p -90");
        Integer arg=argParser.getArg('p');
        assertEquals(arg.intValue(),-90);
    }

    @Test
    public void test_any_types(){
        ArgSchema argSchema=ArgSchema.as(ArgType.of('p',Integer.class,8080),
                ArgType.of('l',Boolean.class,false),
                ArgType.of('n',String.class,"world"));
        ArgParser argParser=ArgParser.of(argSchema);
        argParser.parse("-p 80 -l -n bobdeng");
        Integer intArg=argParser.getArg('p');
        assertEquals(intArg.intValue(),80);

        Boolean boolArg=argParser.getArg('l');
        assertFalse(boolArg);

        String strArg=argParser.getArg('n');
        assertEquals(strArg,"bobdeng");
    }

}
