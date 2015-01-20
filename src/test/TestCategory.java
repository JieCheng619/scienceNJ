package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.science.basics.domain.Category;
import com.science.basics.service.CategoryService;
import com.science.hibernateUtil.MyException;

public class TestCategory {
@Test
public void testAdd(){
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
	CategoryService categoryService =(CategoryService)ctx.getBean("categoryService");
	String text ="��ʳƷ����";
	String description = "���з��������";
	categoryService.addTopCategory(text, description);
}
@Test
public void testAddChildCategory(){
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
	CategoryService categoryService =(CategoryService)ctx.getBean("categoryService");
	Category c = new Category();
	c.setText("�ɹ���");
	c.setDescription("Сʱ���ζ��");
	categoryService.addChileCategory(1, c);
}
@Test
public void testDeleteById() throws MyException{
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
	CategoryService categoryService =(CategoryService)ctx.getBean("categoryService");
	categoryService.deleteById(3,1);
}
@Test
public void testfindAll(){
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
	CategoryService categoryService =(CategoryService)ctx.getBean("categoryService");
	List<Category> list = categoryService.findAll();
	for(Category c:list){
		System.out.println(c.getText());
	}
}
@Test
public void testfindTopAll(){
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
	CategoryService categoryService =(CategoryService)ctx.getBean("categoryService");
	List<Category> list = categoryService.findTopAll();
	for(Category c:list){
		System.out.println(c.getText());
	}
}
}
