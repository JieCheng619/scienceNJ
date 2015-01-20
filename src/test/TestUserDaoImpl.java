package test;

import java.util.List;

import org.junit.Test;

import com.science.basics.dao.UserDao;
import com.science.basics.dao.impl.UserDaoImpl;
import com.science.basics.domain.User;

public class TestUserDaoImpl {
    @Test
	public void testSave(){
		UserDao dao = new UserDaoImpl();
		User u = new User();
		u.setUserName("奥巴马");
		u.setPassword("123123");
		u.setEmail("www.163.com");
		u.setPhone(32131313);
		dao.save(u);
		//System.out.println("用户的Id:"+dao.save(u));
	}
    
	@Test
	public void testDelete(){
		UserDao dao = new UserDaoImpl();
		if(dao.delete(1)){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
	}
	
	@Test
	public void testFindAll(){
		UserDao dao = new UserDaoImpl();
		List list = dao.findAll();
		for(int i=0;i<list.size();i++){
			User u = (User)list.get(i);
			System.out.println("姓名："+ u.getUserName());
		}
	}
	@Test
	public void login(){
		UserDao dao = new UserDaoImpl();
		User u = dao.login("奥巴马", "123123");
		if(u!=null){
			System.out.println("登陆成功");
		}else{
			System.out.println("登陆失败");
		}
	}
	@Test
	public void testUpdate(){
		UserDao dao = new UserDaoImpl();
		User user = new User();
		user.setUserName("金三胖");
		user.setId(2);
		if(dao.update(user)){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
	}
}
