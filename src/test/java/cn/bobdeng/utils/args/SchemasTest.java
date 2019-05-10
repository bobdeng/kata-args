package cn.bobdeng.utils.args;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class SchemasTest {
    Schemas schemas;
    @Before
    public void setup(){
        schemas=Schemas.of(
                Schema.of('l',Boolean.class,Boolean.FALSE),
                Schema.of('n',String.class,"Hello"),
                Schema.of('p',Integer.class,8080)
        );
    }

    @Test
    public void test_bool(){
        assertFalse(schemas.getArgValue('l', null,Boolean.class));
        assertTrue(schemas.getArgValue('l', "true",Boolean.class));
        assertFalse(schemas.getArgValue('l', "false",Boolean.class));

    }
    @Test
    public void test_string(){
        assertEquals(schemas.getArgValue('n',null,String.class),"Hello");
        assertEquals(schemas.getArgValue('n',"world",String.class),"world");
    }
    @Test
    public void test_int(){
        assertEquals(schemas.getArgValue('p',null,Integer.class).intValue(),8080);
        assertEquals(schemas.getArgValue('p',"80",Integer.class).intValue(),80);
        assertEquals(schemas.getArgValue('p',"-80",Integer.class).intValue(),-80);
    }
}
