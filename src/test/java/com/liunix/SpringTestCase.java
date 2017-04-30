package com.liunix;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;

/*-------------基础的annotation写法，啥意思?-------------------*/
@Target(value = { ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
/*-----------------------------------------------*/
@Configuration
/*------------------------专为测试所用-----------------------*/
@PropertySource("classpath:/application-test.properties")
@EnableAutoConfiguration // 放在高级目录中才有用啊
@ComponentScan
/*------------------------专为测试所用-----------------------*/
// @RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringTestCase.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public @interface SpringTestCase {

}
