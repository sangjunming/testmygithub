package com.yuanbao.park.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@MapperScan(basePackages = ClusterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "clusterSqlSessionFactory")
public class ClusterDataSourceConfig implements EnvironmentAware {

    private Environment environment;

    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.yuanbao.park.dao.cluster";
    static final String MAPPER_LOCATION = "classpath:mapper/cluster/*.xml";

    @Bean(name = "clusterDataSource")
    public DataSource clusterDataSource() throws Exception {
        Properties props = new Properties();
        props.put("maxWait", environment.getProperty("cluster.datasource.maxWait"));
        props.put("driverClassName", environment.getProperty("cluster.datasource.driverClassName"));
        props.put("url", environment.getProperty("cluster.datasource.url"));
        props.put("username", environment.getProperty("cluster.datasource.username"));
        props.put("password", environment.getProperty("cluster.datasource.password"));
        props.put("keepAlive", environment.getProperty("cluster.datasource.keepAlive"));
        props.put("maxEvictableIdleTimeMillis", environment.getProperty("cluster.datasource.maxEvictableIdleTimeMillis"));
        props.put("initialSize", environment.getProperty("cluster.datasource.initialSize"));
        props.put("minIdle", environment.getProperty("cluster.datasource.minIdle"));
        props.put("maxActive", environment.getProperty("cluster.datasource.maxActive"));
        props.put("timeBetweenEvictionRunsMillis", environment.getProperty("cluster.datasource.timeBetweenEvictionRunsMillis"));
        props.put("minEvictableIdleTimeMillis", environment.getProperty("cluster.datasource.minEvictableIdleTimeMillis"));
        props.put("validationQuery", environment.getProperty("cluster.datasource.validationQuery"));
        props.put("testWhileIdle", environment.getProperty("cluster.datasource.testWhileIdle"));
        props.put("testOnBorrow", environment.getProperty("cluster.datasource.testOnBorrow"));
        props.put("testOnReturn", environment.getProperty("cluster.datasource.testOnReturn"));
        props.put("poolPreparedStatements", environment.getProperty("cluster.datasource.poolPreparedStatements"));
        props.put("maxPoolPreparedStatementPerConnectionSize", environment.getProperty("cluster.datasource.maxPoolPreparedStatementPerConnectionSize"));
        props.put("removeAbandoned", environment.getProperty("cluster.datasource.removeAbandoned"));
        props.put("removeAbandonedTimeout", environment.getProperty("cluster.datasource.removeAbandonedTimeout"));
        props.put("logAbandoned", environment.getProperty("cluster.datasource.logAbandoned"));
        props.put("connectionProperties", environment.getProperty("cluster.datasource.connectionProperties"));
        props.put("filters", environment.getProperty("cluster.datasource.filters"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() throws Exception {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
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