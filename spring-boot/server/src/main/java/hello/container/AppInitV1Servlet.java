package hello.container;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

public class AppInitV1Servlet implements AppInit {
    @Override
    public void onStartUp(ServletContext servletContext) {
        System.out.println("AppInitV1Servlet.onStartUp");

        // 순수 서블릿 코드 등록
        ServletRegistration.Dynamic helloServlet = servletContext.addServlet("helloServlet", new HelloServlet());

        // 서블릿을 등록하면 반환 결과를 통해 바로 맵핑할 수 있음
        helloServlet.addMapping("/hello-servlet");
    }
}
