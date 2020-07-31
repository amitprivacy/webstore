package com.amit.webstore.config;

import java.util.ArrayList;
import java.util.Locale;

import javax.validation.Validator;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;
import org.springframework.web.util.UrlPathHelper;

import com.amit.webstore.domain.Product;
import com.amit.webstore.interceptor.ProcessingTimeLogInterceptor;
import com.amit.webstore.interceptor.PromoCodeInterceptor;


@EnableWebMvc
@Configuration
@ComponentScan("com.amit.webstore")
public class WebApplicationContextConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver getviewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("/webjars/");
		
		registry.addResourceHandler("/img/**")
		.addResourceLocations("resources/images/");
	}
	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		
		urlPathHelper.setRemoveSemicolonContent(false);
		
		configurer.setUrlPathHelper(urlPathHelper);
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
		
		resource.setBasename("messages");
		return resource;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver()
	{
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		//resolver.setDefaultEncoding("utf-8");
		resolver.setMaxUploadSize(5*1024*1024);
		return resolver;
	}
	
	@Bean
	public MappingJackson2JsonView jsonView()
	{
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		
		jsonView.setPrettyPrint(true);
		return jsonView;
	}
	
	@Bean
	public MarshallingView xmlView()
	{
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Product.class);
		
		MarshallingView xmlView = new MarshallingView(marshaller);
		
		return xmlView;
	}
	
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager)
	{
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		
		resolver.setContentNegotiationManager(manager);
		
		ArrayList<View> views = new ArrayList<>();
		
		views.add(jsonView());
		views.add(xmlView());
		resolver.setDefaultViews(views);
		return resolver;
	}
	
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(new ProcessingTimeLogInterceptor());
		LocaleChangeInterceptor inter = new LocaleChangeInterceptor();
		inter.setParamName("language");
		registry.addInterceptor(inter);
		registry.addInterceptor(promoCodeInterceptor()).addPathPatterns("/**/products/specialOffer");
	}
	
	@Bean
	public LocaleResolver localeResolver()
	{
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		return resolver;
	}
	
	@Bean
	public HandlerInterceptor promoCodeInterceptor() {
		
		PromoCodeInterceptor interceptor = new PromoCodeInterceptor();
		interceptor.setPromoCode("OFF3R");
		interceptor.setOfferRedirect("products");
		interceptor.setErrorRedirect("invalid/promocode");
		
		return interceptor;
	}
	
	@Bean(name="validator")
	public LocalValidatorFactoryBean validator()
	{
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}
	
	@Override
	public org.springframework.validation.Validator getValidator()
	{
		return validator();
	}
	
	
	
	

}
