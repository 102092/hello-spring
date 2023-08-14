package hello.embed;

import hello.spring.HelloConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class EmbedTomcatSpringMain {

    public static void main(String[] args) throws LifecycleException {
        // create tomcat and connect to 8080 port
        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8080);
        tomcat.setConnector(connector);

        // create spring container
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();

        // register bean of helloController
        applicationContext.register(HelloConfig.class);

        // in spring mvc, create dispatcher servlet and connect to spring container
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);

        Context context = tomcat.addContext("", "/");

        // add servlet to tomcat
        tomcat.addServlet("", "dispatcher", dispatcherServlet);

        // add connection if root pattern ("/"), which servlet will have served (dispatcher)
        context.addServletMappingDecoded("/", "dispatcher");

        tomcat.start();
    }
}
