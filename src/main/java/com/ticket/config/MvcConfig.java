package com.ticket.config;

import java.util.Collections;
import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.ticket.services.UpdateRailroadStationService;

@EnableWebMvc
@Configuration
@ComponentScan("com.ticket")
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public ContentNegotiatingViewResolver setupContentNegotiatingViewResolver() {
        ContentNegotiatingViewResolver negotiatingViewResolver = new ContentNegotiatingViewResolver();
        negotiatingViewResolver.setOrder(1);
        negotiatingViewResolver.setDefaultViews(Collections.<View>singletonList(new MappingJacksonJsonView()));
        negotiatingViewResolver.setMediaTypes(new HashMap<String, String>() {
            {
                put("json", "application/json");
            }
        });
        negotiatingViewResolver.setIgnoreAcceptHeader(true);
        return negotiatingViewResolver;
    }

    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setOrder(2);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);

        return viewResolver;
    }

    @Bean(name = "updateRailroadStationService")
    public UpdateRailroadStationService setupUpdateRailroadStationService() {
        return new UpdateRailroadStationService();
    }

}