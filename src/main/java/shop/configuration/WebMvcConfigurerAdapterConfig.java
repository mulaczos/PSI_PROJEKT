package shop.configuration;


import java.io.IOException;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfigurerAdapterConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler(
                "/**/*.css",
                "/**/*.js",
                "/**/*.html",
                "/**/*.json",
                "/**/*.bmp",
                "/**/*.jpeg",
                "/**/*.jpg",
                "/**/*.png",
                "/**/*.gif",
                "/**/*.ttf",
                "/**/*.eot",
                "/**/*.svg",
                "/**/*.woff",
                "/**/*.woff2",
                "/**/*.map"
        ).addResourceLocations("classpath:/public/");

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/public/index.html")
                .resourceChain(false)
                .addResolver(new PathResourceResolver() {
                    @Override
                    protected Resource getResource(String resourcePath,
                                                   Resource location) throws IOException {
                        return location.exists() && location.isReadable() ? location : null;
                    }
                });
    }
}
