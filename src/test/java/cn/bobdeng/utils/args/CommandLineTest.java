package cn.bobdeng.utils.args;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CommandLineTest {
    private Schemas schemas;

    @Before
    public void setup() {
        schemas=Schemas.of(
          Schema.of('l',Boolean.class,Boolean.FALSE),
          Schema.of('n',String.class,"Hello"),
          Schema.of('p',Integer.class,8080),
          Schema.of('c',Integer.class,1)
        );

    }
    @Test
    public void test_bool_null(){
        Args args=Args.of("-l -n bob -p 80 -c -1");
        CommandLine commandLine=CommandLine.of(schemas,args);
        assertFalse(commandLine.getArg('l',Boolean.class));
    }

    @Test
    public void test_bool_has_value(){
        Args args=Args.of("-l true -n bob -p 80 -c -1");
        CommandLine commandLine=CommandLine.of(schemas,args);
        assertTrue(commandLine.getArg('l',Boolean.class));
    }

    @Test
    public void test_string_has_value(){
        Args args=Args.of("-l true -n bob -p 80 -c -1");
        CommandLine commandLine=CommandLine.of(schemas,args);
        assertEquals(commandLine.getArg('n',String.class),"bob");
    }

    @Test
    public void test_string_has_null(){
        Args args=Args.of("-l true -n -p 80 -c -1");
        CommandLine commandLine=CommandLine.of(schemas,args);
        assertEquals(commandLine.getArg('n',String.class),"Hello");
    }

    @Test
    public void test_int_has_null(){
        Args args=Args.of("-l true -n -p 80 -c ");
        CommandLine commandLine=CommandLine.of(schemas,args);
        assertEquals(commandLine.getArg('c',Integer.class).intValue(),1);
    }

    @Test
    public void test_int_has_value(){
        Args args=Args.of("-l true -n -p 80 -c -9");
        CommandLine commandLine=CommandLine.of(schemas,args);
        assertEquals(commandLine.getArg('p',Integer.class).intValue(),80);
        assertEquals(commandLine.getArg('c',Integer.class).intValue(),-9);
    }
}
