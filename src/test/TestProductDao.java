package test;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.science.basics.dao.ProductDao;
import com.science.basics.domain.Category;
import com.science.basics.domain.Product;

public class TestProductDao {
	@Test
	public void testSave(){
		ApplicationContext cfx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
		
		ProductDao dao = (ProductDao)cfx.getBean("productDao");
		
		for(int i=0;i<26;i++){
		Product product = new Product();
		product.setName("ţ��"+i);
		product.setDescr("�óԵ�ţ��");
		product.setNormaPrice(12.23);
		product.setMemberPrice(11.11);
		product.setPdate(new Timestamp(System.currentTimeMillis()));
		
		Category category = new Category();
		category.setId(1);
		product.setCategory(category);
		product.setPhoto("product1.jpg");
		
		
		System.out.println("productID:"+dao.save(product).getId());
		}
	}
	
	@Test
	public void testDelete(){
		ApplicationContext cfx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
		
		ProductDao dao = (ProductDao)cfx.getBean("productDao");
		
		if(dao.delete(3)){
			System.out.println("ɾ���ɹ���");
		}else{
			System.out.println("ɾ�����ɹ���");
		}
	}
	
	@Test
	public void testUpdate(){
		ApplicationContext cfx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
		
		ProductDao dao = (ProductDao)cfx.getBean("productDao");
		
		Product product = new Product();
		product.setId(4);
		product.setName("�й�8");
		//product.setNormaPrice(888888888.5);
		if(dao.update(product)){
			System.out.println("�޸ĳɹ���");
		}else{
			System.out.println("�޸Ĳ��ɹ���");
		}
	}
	
	@Test
	public void testFindAll(){
		ApplicationContext cfx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
		
		ProductDao dao = (ProductDao)cfx.getBean("productDao");
		
		List<Product> list = dao.findAll();
		
		for(Product p : list){
			System.out.println("��Ʒ����"+p.getName() +" ���г���:"+p.getNormaPrice());
		}
	}
	
	@Test
	public void testFindByKeyword(){
		ApplicationContext cfx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
		
		ProductDao dao = (ProductDao)cfx.getBean("productDao");
		
		String keyword="ţ";
		List<Product> list = dao.findByKeyword(keyword);
		
		for(Product p : list){
			System.out.println("��Ʒ����"+p.getName() +" ���г���:"+p.getNormaPrice());
		}
	}
	
	@Test
	public void testFindByCategory(){
		ApplicationContext cfx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
		ProductDao dao = (ProductDao)cfx.getBean("productDao");
		String categoryId="2";
		List<Product> list = dao.findByKeyword(categoryId);
		
		System.out.println(list.size());
		for(Product p : list){
			System.out.println("��Ʒ����"+p.getName() +" ���г���:"+p.getNormaPrice());
		}
	}
}
