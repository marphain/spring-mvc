package com.marphain.demo.newer.spring.config.form;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * 扫描基于注解@Component、@Controller、@Service等创建bean
 */
@Configuration
@ComponentScan(basePackages = "com.marphain.demo.newer.spring.bean")
public class ScanConfiguration {

}
