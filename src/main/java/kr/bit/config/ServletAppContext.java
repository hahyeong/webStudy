package kr.bit.config;

import kr.bit.bean.Student;
import kr.bit.interceptor.LoginInterceptor;
import kr.bit.mapper.StudentMapper;
import kr.bit.mapper.SubjectMapper;
import kr.bit.service.StudentService;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.Resource;

@Configuration
@EnableWebMvc
@ComponentScan("kr.bit.dao")
@ComponentScan("kr.bit.service")
@ComponentScan("kr.bit.controller")
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

    @Autowired
    private StudentService studentService;

    @Resource(name = "loginBean")
    private Student loginBean;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        WebMvcConfigurer.super.configureViewResolvers(registry);
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }

    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(db_classname);
        dataSource.setUrl(db_url);
        dataSource.setUsername(db_username);
        dataSource.setPassword(db_password);

        return dataSource;
    }

    @Bean
    public SqlSessionFactory factory(BasicDataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        return sqlSessionFactory;
    }

    @Bean
    public MapperFactoryBean<StudentMapper> student_mapper(SqlSessionFactory factory) throws Exception{

        MapperFactoryBean<StudentMapper> fac = new MapperFactoryBean<StudentMapper>(StudentMapper.class);
        fac.setSqlSessionFactory(factory);

        return fac;
    }

    @Bean
    public MapperFactoryBean<SubjectMapper> subject_mapper(SqlSessionFactory factory) throws Exception{

        MapperFactoryBean<SubjectMapper> fac = new MapperFactoryBean<SubjectMapper> (SubjectMapper.class);
        fac.setSqlSessionFactory(factory);

        return fac;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);

        LoginInterceptor loginInterceptor = new LoginInterceptor(loginBean);
        InterceptorRegistration registration = registry.addInterceptor(loginInterceptor);
        registration.addPathPatterns("/list");
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}