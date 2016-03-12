import com.devarchi.web.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by donghoon on 2016. 3. 12..
 */
public class DomainTest {

    private User user;

    @Before
    public void init() {
        user = new User();
    }

    @Test
    public void userObjectTest() {
        assertNotNull(user);
    }
}
