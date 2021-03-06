
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.core.BusinessService;


public class TestAOP {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/aop/config/aop.xml");
		
		BusinessService service = (BusinessService)context.getBean("businessService");
		service.businessMethodBefore1();
		System.out.println("--------------------");
		service.businessMethodBefore2("홍길동");
		System.out.println("-----------------------------------");
		String ret = service.businessMethodReturn();
		System.out.println("---main() : 호출결과 : "+ret);
		System.out.println("-----------------------------------");
		try {
			service.businessMethodThrow();
		} catch (Exception e) {
			System.out.println("메인메소드 - catch");
		}
	}
}
