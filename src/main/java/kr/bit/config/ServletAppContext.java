package kr.bit.config;

import kr.bit.bean.Student;
import kr.bit.mapper.SubjectMapper;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"kr.bit.controller", "kr.bit.dao", "kr.bit.service"})
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer {

    @Value("${db.classname}")
    private String db_classname;

    @Value("${db.url}")
    private String db_url;

    @Value("${db.username}")
    private String db_username;

    @Value("${db.password}")
    private String db_password;

    @Resource(name = "loginSession")
    private Student loginSession;

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(db_classname);
        dataSource.setUrl(db_url);
        dataSource.setUsername(db_username);
        dataSource.setPassword(db_password);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(BasicDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        SqlSessionFactory sessionFactory = sqlSessionFactoryBean.getObject();
        return sessionFactory;
    }

    @Bean
    public MapperFactoryBean<SubjectMapper> subjectMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<SubjectMapper> mapperFactoryBean = new MapperFactoryBean<>(SubjectMapper.class);
        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
        return mapperFactoryBean;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        WebMvcConfigurer.super.configureViewResolvers(registry);
        registry.jsp("/WEB-INF/views/",".jsp");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }

}