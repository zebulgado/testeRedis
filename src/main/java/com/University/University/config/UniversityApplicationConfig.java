package com.University.University.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.University.University.model.Student;

@Configuration
@ComponentScan
public class UniversityApplicationConfig {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedMethods("*")
				.allowedOrigins("*");
			}
		};
	}

	
//	@Bean
//	  public LettuceConnectionFactory redisConnectionFactory() {
//
//	    return new LettuceConnectionFactory(new RedisStandaloneConfiguration("127.0.0.1", 6379));
//	  }
	
   //Creating Connection with Redis
   @Bean
   public RedisConnectionFactory redisConnectionFactory() {
       return new LettuceConnectionFactory();
   }

   //Creating RedisTemplate for Entity 'Employee'
   @Bean
   public RedisTemplate<String, Student> redisTemplate(RedisConnectionFactory redisConnectionFactory){
      RedisTemplate<String, Student> studentTemplate = new RedisTemplate<>();
      studentTemplate.setConnectionFactory(redisConnectionFactory);
      return studentTemplate;
   }
}