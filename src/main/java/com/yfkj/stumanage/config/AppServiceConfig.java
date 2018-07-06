package com.yfkj.stumanage.config;

import com.yfkj.stumanage.service.*;
import com.yfkj.stumanage.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jerry Tan
 * @date 2018\7\6 0006 11:23
 */
@Configuration
public class AppServiceConfig {
    @Bean
    public ClassesService classesServiceImpl(){
        return new ClassesServiceImpl();
    }

    @Bean
    public CourseService courseServiceImpl(){
        return new CourseServiceImpl();
    }

    @Bean
    public StudentService studentServiceImpl(){
        return new StudentServiceImpl();
    }

    @Bean
    public TeacherService teacherServiceImpl(){
        return new TeacherServiceImpl();
    }

    @Bean
    public UserService userServiceImpl(){
        return new UserServiceImpl();
    }
}
