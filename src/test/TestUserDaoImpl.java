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
		u.setUserName("�°���");
		u.setPassword("123123");
		u.setEmail("www.163.com");
		u.setPhone(32131313);
		dao.save(u);
		//System.out.println("�û���Id:"+dao.save(u));
	}
    
	@Test
	public void testDelete(){
		UserDao dao = new UserDaoImpl();
		if(dao.delete(1)){
			System.out.println("ɾ���ɹ�");
		}else{
			System.out.println("ɾ��ʧ��");
		}
	}
	
	@Test
	public void testFindAll(){
		UserDao dao = new UserDaoImpl();
		List list = dao.findAll();
		for(int i=0;i<list.size();i++){
			User u = (User)list.get(i);
			System.out.println("������"+ u.getUserName());
		}
	}
	@Test
	public void login(){
		UserDao dao = new UserDaoImpl();
		User u = dao.login("�°���", "123123");
		if(u!=null){
			System.out.println("��½�ɹ�");
		}else{
			System.out.println("��½ʧ��");
		}
	}
	@Test
	public void testUpdate(){
		UserDao dao = new UserDaoImpl();
		User user = new User();
		user.setUserName("������");
		user.setId(2);
		if(dao.update(user)){
			System.out.println("�޸ĳɹ�");
		}else{
			System.out.println("�޸�ʧ��");
		}
	}
}
