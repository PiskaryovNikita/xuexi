import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private int i = 1;
    private final User user = new User("test");

    public UserTest() {
        System.out.println("UserTest object is created");
    }

    /**
     * On each test - UserTest object is created. Each instance has its own fields.
     * As result each @Test is independent
     */
    @Test
    public void getName() {
        i++;
        assertEquals("test", user.getName());
    }

    @Test
    public void getName2() {
        i++;
        assertEquals("test", user.getName());
    }

    @Test
    public void getName3() {
        i++;
        assertEquals("test", user.getName());
    }

    @After
    public void cleanup() {
        System.out.println(i);
    }
}