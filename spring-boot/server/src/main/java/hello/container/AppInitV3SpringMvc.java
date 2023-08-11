package hello.container;

import hello.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// WebApplicationInitializer 이 인터페이스만 구현하면,
// META-INF 부터 적용하던 부분이 자동으로 된다.
public class AppInitV3SpringMvc implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("AppInitV3SpringMvc.onStartUp");

        // create spring container
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        // register HelloController to context
        context.register(HelloConfig.class);

        // create spring mvc dispatcher servlet and connect to spring container
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // register dispatcherServlet to servlet container
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherV3", dispatcherServlet);

        // every request must go to DispatcherServlet
        servlet.addMapping("/");

        // 일반적으로는 하나의 디스패처 서블릿, 하나의 스프링 컨테이너만 만든다.


    }
}
