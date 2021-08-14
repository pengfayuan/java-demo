package com.yuanyuan.springdemo.componentscan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author FAYUAN.PENG
 * @version \$Id: BeanConfig.java,  2021-07-27 0:18 FAYUAN.PENG Exp $$
 */
@Configuration
@ComponentScan(basePackages = "com.yuanyuan.springdemo.componentscan",
        useDefaultFilters = false,
        includeFilters = @Filter(type = FilterType.REGEX, pattern = "com.yuanyuan.springdemo.componentscan.*"))
public class BeanConfig {

}
