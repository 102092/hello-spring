package hello.container;

import hello.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitV2Spring implements AppInit{
    @Override
    public void onStartUp(ServletContext servletContext) {
        System.out.println("AppInitV2Spring.onStartUp");

        // create spring container
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        // register HelloController to context
        context.register(HelloConfig.class);

        // create spring mvc dispatcher servlet and connect to spring container
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // register dispatcherServlet to servlet container
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherV2", dispatcherServlet);

        // request of '/spring/*' connected to DispatcherServlet
        servlet.addMapping("/spring/*");

        // 즉 저 URL로 요청이 들어오면,
        // 서블릿 컨테이너에서 어떤 서블릿으로 할당할 지 결정하는데, 이걸 디스패처 서블릿으로 할당하고,
        // 디스패처서블릿은, 요청 정보를 통해, 스프링 컨테이너에 있는 어떤 빈을 호출할지 결정하는 듯
    }
}
