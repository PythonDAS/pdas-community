import com.devarchi.web.config.MysqlConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by donghoon on 2016. 2. 19..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MysqlConfig.class})
@WebAppConfiguration
public class MysqlConfigTest {

    private AbstractApplicationContext context;
    private DataSource dataSource;
    private Connection connection;

    @Before
    public void before() throws SQLException {
        context = new AnnotationConfigApplicationContext(MysqlConfig.class);
        dataSource = (DriverManagerDataSource) context.getBean("dataSource");
        connection = dataSource.getConnection();
    }

    @Test
    public void dataSourceTest() {
        assertNotNull(dataSource);
    }

    @Test
    public void getConnectionTest() {
        assertNotNull(connection);
    }
}
