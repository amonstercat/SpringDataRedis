package com.lzc.study.util;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
//用来获取springboot创建好的工厂
@Configuration
public class ApplicationContextUtils implements ApplicationContextAware {
    //保留下来的工厂
    private static   ApplicationContext applicationContext;

    @Override  //将spring创建好的工厂以参数形式传递给这个类
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
    //提供在工厂中获取的对象的方法  redisTemplate
    public  static  Object getBean(String beanName)
    {
        return applicationContext.getBean(beanName);
    }
}
