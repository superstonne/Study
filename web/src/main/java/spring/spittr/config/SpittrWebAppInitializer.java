package spring.spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;
import java.io.IOException;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {new Filter() {
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                System.out.println("Hi DispatcherServlet, you have been filtered by me.");
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }};
    }
}
