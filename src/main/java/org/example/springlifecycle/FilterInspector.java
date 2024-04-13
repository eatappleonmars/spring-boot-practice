package org.example.springlifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FilterInspector {

    @Autowired
    private ApplicationContext applicationContext;

    public void printRegisteredFilters() {
        String[] filterBeanNames = applicationContext.getBeanNamesForType(FilterRegistrationBean.class);
        System.out.println("filterBeanNames size: " + filterBeanNames.length);
        for (String beanName : filterBeanNames) {
            FilterRegistrationBean<?> filterRegistrationBean = applicationContext.getBean(beanName, FilterRegistrationBean.class);
            System.out.println("Filter Name: " + filterRegistrationBean.getFilter().getClass().getName());
            System.out.println("URL Patterns: " + filterRegistrationBean.getUrlPatterns());
            // Print other properties as needed
        }
    }
}