package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.science.basics.domain.User;
import com.science.basics.service.UserService;
import com.science.hibernateUtil.MyException;

public class TestUserServiceImpl {
@Test
public void testgetPersons(){
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
	UserService userService = (UserService)ctx.getBean("userService");
	User user = new User();
	user.setUserName("ÕÅÈý1");
	user.setPassword("123123");
	try {
		userService.register(user);
	} catch (MyException e) {
		System.out.println(e);
	}
}
}
