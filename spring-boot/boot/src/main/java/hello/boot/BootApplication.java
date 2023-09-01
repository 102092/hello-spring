package hello.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {
		// BootApplication.class -> 메인 설정 정보를 넘겨주시는 것
		// @ComponentScan, 기본은 현재 위치와 그 하위 모든 패키지가 컴포넌트 스캔의 대상
		SpringApplication.run(BootApplication.class, args);

		// 주요 기능은..
		// 1. 스프링 컨테이너 생성
		// 2. 내장 톰켓 실행
	}

}
