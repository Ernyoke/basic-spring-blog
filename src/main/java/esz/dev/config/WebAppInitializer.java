package esz.dev.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {
    private static final String DISPATCHER_SERVLET_NAME = "esz.dev.dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create Spring application context
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(WebConfig.class);
        // Create the dispatcher servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
