import com.devarchi.web.config.MysqlConfig;
import com.devarchi.web.dao.UserDao;
import com.devarchi.web.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by donghoon on 2016. 2. 19..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MysqlConfig.class})
@WebAppConfiguration
public class MysqlMybatisTest {

    private AbstractApplicationContext context;
    private DataSource dataSource;
    private DataSource pooledDataSource;
    private Connection connection;

    @Autowired
    private UserDao userDao;

    private User user;

    @Before
    public void before() throws SQLException {
        context = new AnnotationConfigApplicationContext(MysqlConfig.class);
        dataSource = (DriverManagerDataSource) context.getBean("dataSource");
        pooledDataSource = (org.apache.tomcat.jdbc.pool.DataSource) context.getBean("pooledDataSource");
        connection = pooledDataSource.getConnection();
        user = new User();
    }

    @Test
    public void dataSourceTest() {
        assertNotNull(dataSource);
        assertNotNull(pooledDataSource);
    }

    @Test
    public void getConnectionTest() {
        assertNotNull(connection);
    }

    @Test
    public void selectUserTest() {
        List<User> userList = userDao.find();
        for (User user : userList) {
            System.out.println("User Id: " + user.getUser_id());
            System.out.println("User Name: " + user.getName());
        }
    }

    @Test
    public void insertUserTest() {
        userDao.deleteUserByName("hyunkyu");

        user.setName("hyunkyu");
        user.setPassword("h1111");
        user.setEmail("imfly7@naver.com");
        userDao.insertUser(user);

        User getUser = userDao.findByName("hyunkyu");
        assertEquals("hyunkyu", getUser.getName());
    }

    @Test
    public void updateUserPsswordTest() {
        User getUser = userDao.findByName("hyunkyu");

        userDao.updateUserPasswordByName("newPassword", getUser.getName());

        User updateUser = userDao.findByName("hyunkyu");

        assertEquals("newPassword", updateUser.getPassword());
    }
}
