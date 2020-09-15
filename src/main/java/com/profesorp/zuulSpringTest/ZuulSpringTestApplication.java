package com.profesorp.zuulSpringTest;

//import com.profesorp.zuulSpringTest.Filters.APIPreRewriteFilter;
//import com.profesorp.zuulSpringTest.Filters.PublicPreRewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulSpringTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulSpringTestApplication.class, args);
	}

//    @Bean
//    public APIPreRewriteFilter apiPreRewriteFilter() {
//        return new APIPreRewriteFilter();
//    }
//
//    @Bean
//    public PublicPreRewriteFilter publicPreRewriteFilter() {
//        return new PublicPreRewriteFilter();
//    }
}
