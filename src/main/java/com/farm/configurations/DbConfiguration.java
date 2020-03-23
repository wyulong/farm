package com.farm.configurations;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/** 数据库配置
 * @Author xhua
 * @Date 2020/3/21 23:23
 **/
@Configuration
@MapperScan(basePackages = {"com.farm.mapper"},sqlSessionFactoryRef = "sqlSessionFactory")
public class DbConfiguration {

    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    /** 数据源 **/
    @Primary
    @Bean("dbConfig")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws SQLException {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    /** 会话工厂 **/
    @Primary
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dbConfig")DataSource dataSource) throws Exception{
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return factoryBean.getObject();
    }

    /** 事务控制 **/
    @Primary
    @Bean("transaction")
    public DataSourceTransactionManager transactionManager(@Qualifier("dbConfig") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }



}
