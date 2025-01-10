package kr.bit.config;

import kr.bit.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class RootAppContext {

    @Bean("loginSession")
    @SessionScope
    public Student loginBean() {
        return new Student();
    }

}