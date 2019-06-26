package com.marphain.demo.newer.spring.config;

import com.marphain.demo.newer.spring.config.form.AnnotationConfiguration;
import com.marphain.demo.newer.spring.config.form.ScanConfiguration;
import com.marphain.demo.newer.spring.config.form.XmlConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * 配置入口，引用多个配置类
 */
@Configuration
@Import({XmlConfiguration.class, AnnotationConfiguration.class, ScanConfiguration.class})
public class ContextConfiguration {
}
