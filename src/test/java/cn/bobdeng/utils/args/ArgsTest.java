package cn.bobdeng.utils.args;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ArgsTest {
    Args args;

    @Before
    public void setup(){
        args = Args.of("-l -n bob -p -9 -d 100");
    }

    @Test
    public void test(){
        assertEquals(args.get('l'),null);
        assertEquals(args.get('n'),"bob");
        assertEquals(args.get('p'),"-9");
        assertEquals(args.get('d'),"100");
    }
}
