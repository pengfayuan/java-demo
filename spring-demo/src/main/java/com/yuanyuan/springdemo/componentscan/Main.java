package com.yuanyuan.springdemo.componentscan;

import com.yuanyuan.springdemo.componentscan.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author FAYUAN.PENG
 * @version \$Id: Main.java,  2021-07-27 14:09 FAYUAN.PENG Exp $$
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println("load bean: " + beanDefinitionName);
        }
    }
}
