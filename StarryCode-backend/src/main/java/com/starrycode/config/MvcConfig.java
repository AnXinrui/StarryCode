package com.starrycode.config;

import com.starrycode.utils.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author axr
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    private final String[] knife4fExcludePatterns = new String[]{"/swagger-resources/**", "/webjars/**", "/v3/**", "/swagger-ui.html/**",
            "/api", "/api-docs", "/api-docs/**", "/doc.html/**"};
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns(
                        "/user/login",
                        "/user/hi",
                        "/user/register"
                )
                .excludePathPatterns(knife4fExcludePatterns);
    }
}
