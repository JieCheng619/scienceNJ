package test;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.science.basics.domain.SaleItem;
import com.science.basics.domain.SalesOrder;
import com.science.basics.service.SalesOrderService;
import com.science.hibernateUtil.FileEveryDaySerialNumber;
import com.science.hibernateUtil.QshSerialNumber;

public class TestSalesOrderServiceImpl {
	@Test
	public void testAdd(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
		SalesOrderService salesOrderService = (SalesOrderService)ctx.getBean("salesOrderService");
		SalesOrder order = new SalesOrder();
		QshSerialNumber serial = new FileEveryDaySerialNumber(5,"EverDayNumberSerial.dat");
		order.setOrderCode(serial.getSerialNumber());
		order.setUser("奥巴马");
		order.setAddr("白宫");
		order.setPhone("1388888888");
		
		order.setOdate(new Timestamp(System.currentTimeMillis()));
		
		Set<SaleItem> saleItems = new HashSet<SaleItem>();
		SaleItem si1 = new SaleItem();
		si1.setProductName("牛肉");
		si1.setPrice(123.12);
		si1.setNumber(33);
		SaleItem si2 = new SaleItem();
		si2.setProductName("糖啊");
		si2.setPrice(555.12);
		si2.setNumber(55);
		saleItems.add(si1);
		saleItems.add(si2);
		
		
		order.setSaleItems(saleItems);
		if(salesOrderService.add(order)){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	}
	
	@Test
	public void testFindAll(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
		
		SalesOrderService salesOrderService = (SalesOrderService)ctx.getBean("salesOrderService");
		
		List<SalesOrder> list = salesOrderService.findAll();
	
		System.out.println(list.size());
		for(SalesOrder order: list){
			System.out.println("定单号"+order.getOrderCode());
			Set<SaleItem> items =order.getSaleItems();
			for(SaleItem item : items){
				System.out.println("定单所对应产品名称："+item.getProductName());
			}
		}
	}
	
	@Test
	public void testFindAllPage(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
		
		SalesOrderService salesOrderService = (SalesOrderService)ctx.getBean("salesOrderService");
		
		List<SalesOrder> list = salesOrderService.findAll(1,2);
	
		System.out.println(list.size());
		for(SalesOrder order: list){
			System.out.println("定单号："+order.getOrderCode());
			Set<SaleItem> items =order.getSaleItems();
			for(SaleItem item : items){
				System.out.println("定单所对应产品名称："+item.getProductName());
			}
		}
	}
	
	@Test
	public void testFindByOderCode(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
		
		SalesOrderService salesOrderService = (SalesOrderService)ctx.getBean("salesOrderService");
		
		String orderCode="2014120900002";
		List<SalesOrder> list = salesOrderService.findByOderCode(orderCode);
		System.out.println(list.size());
		for(SalesOrder order: list){
			System.out.println("定单号："+order.getOrderCode());
			Set<SaleItem> items =order.getSaleItems();
			for(SaleItem item : items){
				System.out.println("定单所对应产品名称："+item.getProductName());
			}
		}
	}
	
	@Test
	public void testRemove(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
		
		SalesOrderService salesOrderService = (SalesOrderService)ctx.getBean("salesOrderService");
		
		SalesOrder order = new SalesOrder();
		order.setId(1);
		if(salesOrderService.remove(order)){
			System.out.println("定单作废成功！");
		}else{
			System.out.println("定单作废不成功！");
		}
		
	}
	
	@Test 
	public void testVerify(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_config/springbean.xml");
		
		SalesOrderService salesOrderService = (SalesOrderService)ctx.getBean("salesOrderService");
		
		int id=1;
		if(salesOrderService.verify(id)){
			System.out.println("定单审核成功！");
		}else{
			System.out.println("定单审核不成功！");
		}
	}
}
