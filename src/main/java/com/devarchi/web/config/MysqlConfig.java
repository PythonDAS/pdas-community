package com.devarchi.web.config;

import com.devarchi.web.dao.SkillDao;
import com.devarchi.web.dao.UserDao;
import com.devarchi.web.domain.User;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by donghoon on 2016. 2. 19..
 */
@Configuration
@PropertySource("classpath:db.iruen.properties")
@Data
@EnableTransactionManagement
public class MysqlConfig {

    @Value("${mysql.driverClassName}")
    private String driverClassName;
    @Value("${mysql.url}")
    private String url;
    @Value("${mysql.user}")
    private String user;
    @Value("${mysql.pass}")
    private String pass;
    @Value("${mysql.initialSize}")
    private int initialSize;
    @Value("${mysql.maxActive}")
    private int maxActive;
    @Value("${mysql.maxIdle}")
    private int maxIdle;
    @Value("${mysql.minIdle}")
    private int minIdle;
    @Value("${mysql.maxWait}")
    private int maxWait;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(pass);
        return dataSource;
    }

    @Bean
    public DataSource pooledDataSource() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(pass);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxIdle(maxIdle);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        return dataSource;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(pooledDataSource());
        return tm;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(pooledDataSource());
        Resource[] mapperLocation = new Resource[2];
        mapperLocation[0] = new ClassPathResource("/mapper/userDao.xml");
        mapperLocation[1] = new ClassPathResource("/mapper/skillDao.xml");
        factoryBean.setMapperLocations(mapperLocation);
//현재 동작에 영향없음        factoryBean.setTypeAliases(new Class<?>[]{User.class});
        return factoryBean.getObject();
    }

    @Bean(destroyMethod = "clearCache")
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean());
    }

    @Bean
    public UserDao userDao() throws Exception {
        return sqlSessionTemplate().getMapper(UserDao.class);
    }

    @Bean
    public SkillDao skillDao() throws Exception {
        return sqlSessionTemplate().getMapper(SkillDao.class);
    }
}
