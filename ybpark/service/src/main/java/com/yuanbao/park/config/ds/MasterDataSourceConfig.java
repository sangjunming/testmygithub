package com.yuanbao.park.config.ds;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 扫描 Mapper 接口并容器管理
 */
@Configuration
@MapperScan(basePackages = MasterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig implements EnvironmentAware {

    private Environment environment;

    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.yuanbao.park.dao.master";
    static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml";

    @Bean(name = "masterDataSource")
    @Primary
    public DataSource masterDataSource() throws Exception {
        Properties props = new Properties();
        props.put("maxWait", environment.getProperty("master.datasource.maxWait"));
        props.put("driverClassName", environment.getProperty("master.datasource.driverClassName"));
        props.put("url", environment.getProperty("master.datasource.url"));
        props.put("username", environment.getProperty("master.datasource.username"));
        props.put("password", environment.getProperty("master.datasource.password"));
        props.put("keepAlive", environment.getProperty("master.datasource.keepAlive"));
        props.put("maxEvictableIdleTimeMillis", environment.getProperty("master.datasource.maxEvictableIdleTimeMillis"));
        props.put("initialSize", environment.getProperty("master.datasource.initialSize"));
        props.put("minIdle", environment.getProperty("master.datasource.minIdle"));
        props.put("maxActive", environment.getProperty("master.datasource.maxActive"));
        props.put("timeBetweenEvictionRunsMillis", environment.getProperty("master.datasource.timeBetweenEvictionRunsMillis"));
        props.put("minEvictableIdleTimeMillis", environment.getProperty("master.datasource.minEvictableIdleTimeMillis"));
        props.put("validationQuery", environment.getProperty("master.datasource.validationQuery"));
        props.put("testWhileIdle", environment.getProperty("master.datasource.testWhileIdle"));
        props.put("testOnBorrow", environment.getProperty("master.datasource.testOnBorrow"));
        props.put("testOnReturn", environment.getProperty("master.datasource.testOnReturn"));
        props.put("poolPreparedStatements", environment.getProperty("master.datasource.poolPreparedStatements"));
        props.put("maxPoolPreparedStatementPerConnectionSize", environment.getProperty("master.datasource.maxPoolPreparedStatementPerConnectionSize"));
        props.put("removeAbandoned", environment.getProperty("master.datasource.removeAbandoned"));
        props.put("removeAbandonedTimeout", environment.getProperty("master.datasource.removeAbandonedTimeout"));
        props.put("logAbandoned", environment.getProperty("master.datasource.logAbandoned"));
        props.put("connectionProperties", environment.getProperty("master.datasource.connectionProperties"));
        props.put("filters", environment.getProperty("master.datasource.filters"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() throws Exception {
        return new DataSourceTransactionManager(masterDataSource());
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MasterDataSourceConfig.MAPPER_LOCATION));
        //添加分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        sessionFactory.setPlugins(new Interceptor[]{pageHelper});
        return sessionFactory.getObject();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}