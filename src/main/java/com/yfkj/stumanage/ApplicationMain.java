package com.yfkj.stumanage;

import com.yfkj.stumanage.config.AppServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Jerry Tan
 * @date 2018\6\4 0004 18:56
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@ImportResource("classpath*:application-boot.xml")
@Import({AppServiceConfig.class})

public class ApplicationMain extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ApplicationMain.class, args);
        System.out.println("ヾ(◍°∇°◍)ﾉﾞ  stuManage启动成功  ヾ(◍°∇°◍)ﾉﾞ\n");
    }
}