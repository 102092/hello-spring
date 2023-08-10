package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

// 이 어노테이션을 넣어주면 해당 인터페이스 구현체들이 Set<Class<?>> c 로 넘어옴
@HandlesTypes(AppInit.class)
public class MyContainerInitV2 implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("MyContainerInitV2.onStartUp");
        System.out.println("MyContainerInitV2 c = " + c);
        System.out.println("MyContainerInitV2 ctx = " + ctx);

//        MyContainerInitV2.onStartUp
//        MyContainerInitV2 c = [class hello.container.AppInitV1Servlet]
//        MyContainerInitV2 ctx = org.apache.catalina.core.ApplicationContextFacade@1d879e6b

        for (Class<?> appInitClass : c) {
            try {
                // new AppInitV1Servlet() 같은 코드
                AppInit appInit=  (AppInit) appInitClass.getDeclaredConstructor().newInstance();
                appInit.onStartUp(ctx);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
