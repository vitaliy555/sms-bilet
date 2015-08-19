package com.ticket.config;

import java.util.Collections;
import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.ticket.services.UpdateRailroadStationService;

@Configuration
@ComponentScan("com.ticket")
public class WebConfig extends WebMvcConfigurerAdapter {

    // переопределив данный метод мы сможем указать где будут лежать ресурсы нашего проекта, такие
    // как css, image, js и другие.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/pages/**").addResourceLocations("/pages/");
    }

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setOrder(2);
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

    public ContentNegotiatingViewResolver setupContentNegotiatingViewResolver() {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
        viewResolver.setOrder(1);
        viewResolver.setDefaultViews(Collections.<View>singletonList(new MappingJacksonJsonView()));
        viewResolver.setMediaTypes(new HashMap<String, String>(){{put("json","application/json");}});
        viewResolver.setIgnoreAcceptHeader(true);
        return viewResolver;
    }

    @Bean
    public UpdateRailroadStationService setupUpdateRailroadStationService() {
        return new UpdateRailroadStationService();
    }
}
