package hello.container;

import jakarta.servlet.ServletContext;

// 어플리케이션 초기화와 서블릿 초기화는 다름
// 아래는 어플리케이션 초기화
public interface AppInit {

    void onStartUp(ServletContext servletContext);
}
