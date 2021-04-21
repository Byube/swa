package com.dnk.swa.dataSource.mysql;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
 
import javax.sql.DataSource;

@Configuration
public class MySqlConfig {
	
	@Autowired
	@Qualifier(value = "mariadbDatasource")
	private DataSource mariadbDatasource;
	
	@Autowired
	@Qualifier(value = "postgreDatasource")
	private DataSource postgreDatasource;
	
	@Bean
    @Primary
    public SqlSessionFactory mariadbSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mariadbDatasource);
        /* 맵퍼 xml 파일 경로 설정 */
        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath:com/dnk/swa/dataSource/mapper/*Mapper.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);
        /* alias 설정 com.package..entity.Board -> resultType"Board" */
        sqlSessionFactoryBean.setTypeAliasesPackage("com.dnk.*.dto");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
        
        /* 실제DB컬럼명 스네이크 표기법 = 카멜케이스 표기법 맵핑 */
        configuration.setMapUnderscoreToCamelCase(false);
 
        return sqlSessionFactory;
    }
	
    @Bean
    public SqlSessionFactory postgreSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(postgreDatasource);
        /* 맵퍼 xml 파일 경로 설정 */
        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath:com/dnk/swa/dataSource/mapper/*Mapper.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);
        /* alias 설정 com.package..entity.Board -> resultType"Board" */
        sqlSessionFactoryBean.setTypeAliasesPackage("com.dnk.*.dto");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
        /* 실제DB컬럼명 스네이크 표기법 = 카멜케이스 표기법 맵핑 */
        configuration.setMapUnderscoreToCamelCase(false);
        return sqlSessionFactory;
    }
 
    @Bean
    @Primary
    public SqlSession mariadbsqlSession() throws Exception {
        return new SqlSessionTemplate(mariadbSqlSessionFactoryBean());
    }
 
    @Bean
    public SqlSession postgresqlSession() throws Exception {
        return new SqlSessionTemplate(postgreSqlSessionFactoryBean());
    }
	
}
