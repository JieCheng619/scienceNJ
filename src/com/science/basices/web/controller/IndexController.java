package com.science.basices.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.science.basics.domain.Cart;
import com.science.basics.domain.CartItem;
import com.science.basics.domain.Category;
import com.science.basics.domain.OrderFormDto;
import com.science.basics.domain.Product;
import com.science.basics.domain.SaleItem;
import com.science.basics.domain.SalesOrder;
import com.science.basics.domain.User;
import com.science.basics.service.CategoryService;
import com.science.basics.service.ProductService;
import com.science.basics.service.SalesOrderService;
import com.science.basics.service.UserService;
import com.science.hibernateUtil.FileEveryDaySerialNumber;
import com.science.hibernateUtil.QshSerialNumber;
@Controller
public class IndexController {
	private CategoryService categoryService;
	private ProductService productService;
	private UserService userService;
	private SalesOrderService salesOrderService;
	List<Product> productList;
	List<Product> productList25Last;
	List<Category> categoryList;
	public SalesOrderService getSalesOrderService() {
		return salesOrderService;
	}
	@Resource
	public void setSalesOrderService(SalesOrderService salesOrderService) {
		this.salesOrderService = salesOrderService;
	}
	public ProductService getProductService() {
		return productService;
	}
	@Resource
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
    @Resource
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**index.jsp最初请求*/
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		List<Category> categoryList = categoryService.findAll();
		
		//商品的列表
		List<Product> productList =productService.findAll() ;
		List<Product> productList25Last = new ArrayList<Product>();
		Collections.reverse(productList25Last);
		for(int i=0;i<productList.size();i++){
			if(i<25){
				productList25Last.add(productList.get(i));
			}else{
				break;
			}
		}
		mav.setViewName("index");
		mav.addObject("categoryList", categoryList);
		mav.addObject("productList", productList);
		mav.addObject("productList25Last", productList25Last);
		return mav;
	}
	/**用户登录*/
	@RequestMapping("/login")
	public ModelAndView userLogin(HttpServletRequest request,HttpSession session){
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		ModelAndView mav = new ModelAndView();
		if(username != null && !username.equals("") || password != null&&!password.equals("")){
			User u = userService.login(username, password);
			if(u!=null){
				u.setUserName(username);
				session.setAttribute("user", u);
			}else{
				mav.addObject("username", "用户名和密码错误!");
			}
		}
		mav.setViewName("index");
		return mav;
	}
	
	/**
	 * 用户注销
	 */
	@RequestMapping("/unlogin")
	public ModelAndView unLogin(HttpServletRequest request,HttpSession session){
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("user");
		session.removeAttribute("orderCode");
		session.removeAttribute("serial");
		mav.setViewName("index");
		return mav;
	}
	
	/**
	 * 购买商品
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/buy")
	public ModelAndView buy(HttpServletRequest request,HttpSession session,CartItem cartItem) throws UnsupportedEncodingException{
		ModelAndView mav = new ModelAndView();
		User u = (User)session.getAttribute("user");
		if(null==u){
			mav.setViewName("register");
			return mav;
		}
		List<CartItem> cartList;
		Cart cart = (Cart)session.getAttribute("cart");
		if(null==cart){
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		CartItem cartItem1 = new CartItem();
		cartItem1.setProductId(cartItem.getProductId());
		String productName = new String(cartItem.getProductName().getBytes("ISO-8859-1"),"UTF-8");
		cartItem1.setProductName(productName);
		cartItem1.setCount(1);
		cartItem1.setPrice(Math.round(cartItem.getPrice() * 100)/100.0);
		cart.add(cartItem1);
		cartList = cart.getList();
		mav.setViewName("cart");
		mav.addObject("cartList", cartList);
		mav.addObject("size", cartList.size());
		mav.addObject("totalPrice",Math.round(cart.getTotalPrice() * 100)/100.0);
		return mav;
	}
	
	/**
	 * 修改数量
	 */
	/**修改数量*/
	@RequestMapping("/buy_update")
	public ModelAndView buyUpdate(HttpServletRequest request,CartItem itemdto,HttpSession session) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		List<CartItem> list;
		Cart cart = (Cart)session.getAttribute("cart");
		list = cart.getList();
		for(int i=0;i<list.size();i++){
			//获得对应id产品的数量，只能这样做,这是技巧
			CartItem ci = list.get(i);
			String strCount = request.getParameter("p"+ci.getProductId());
			if(strCount != null && !strCount.trim().equals("")){
				ci.setCount(Integer.parseInt(strCount));
			}
		}
		
		QshSerialNumber serial = (QshSerialNumber)session.getAttribute("serial");
		if(serial == null){
			serial =new FileEveryDaySerialNumber(4, "EveryDaySerialNumber.dat");
			session.setAttribute("serial", serial);
		}
		String orderCode = (String)session.getAttribute("orderCode");
		if(orderCode == null || orderCode.equals("")){
			orderCode=serial.getSerialNumber();
			session.setAttribute("orderCode", orderCode);
		}
		//下定单
		String confirm = request.getParameter("confirm");
		if(null!= confirm && !confirm.equals("")){
			User user = (User)session.getAttribute("user");
			mav.setViewName("confirm");
			mav.addObject("cartList", list);
			mav.addObject("size",list.size());
			mav.addObject("user",user);
			mav.addObject("orderCode",orderCode);
			SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			mav.addObject("date", sft.format(new Date(System.currentTimeMillis())));
			mav.addObject("totalPrice",Math.round(cart.getTotalPrice() * 100)/100.0);
			return mav;
		}
		
		mav.setViewName("cart");
		mav.addObject("cartList", list);
		mav.addObject("msg", "修改成功");
		mav.addObject("totalPrice",Math.round(cart.getTotalPrice() * 100)/100.0);
		mav.addObject("size",list.size());
		return mav;
	}
	
	/**确定定单confirm_order.do*/
	@RequestMapping("/confirm_order")
	public ModelAndView confirmOrder(HttpServletRequest request,OrderFormDto orderFormDto,HttpSession session) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		SalesOrder order = new SalesOrder();
		order.setUser(request.getParameter("user"));
		order.setOrderCode(request.getParameter("orderCode"));
		order.setOdate(new Timestamp(System.currentTimeMillis()));
		order.setPhone(request.getParameter("phone"));
		order.setQQ(request.getParameter("qq"));
		order.setAddr(request.getParameter("address"));
		order.setRemark(request.getParameter("remark"));
		Set<SaleItem> saleItems = new HashSet<SaleItem>();
		List<SaleItem> items = orderFormDto.getSaleitems();
		for(SaleItem item : items){
			//item.setProductId(item.g)
			saleItems.add(item);
		}
		order.setSaleItems(saleItems);
		if(salesOrderService.add(order)){
			mav.setViewName("orderend");
			//那么就清空购物车
			session.removeAttribute("cart");
			session.removeAttribute("serial");
		}else{
			mav.setViewName("confirm");
			mav.addObject("msg", "定单没有提交成功！请检查你的网络再试");
		}
		return mav;
	}
	
	/**用户名检查usernameValidate.do
	 * @throws IOException */
	@RequestMapping("/usernameValidate")
	public void usernameValidate(HttpServletResponse response,HttpServletRequest request,HttpSession session) throws IOException {
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-store");//HTTP 1.1
		response.setHeader("Pragma", "no-store");//HTTP 1.0
		response.setDateHeader("Expires", 0);//prevents caching at the proxy server
		//true就是用户名存在，false就是不存在
		String username = request.getParameter("username");
		
		if(userService.checkUserName(username)){
			response.getWriter().write("<msg>true</msg>");
		}else{
			response.getWriter().write("<msg>false</msg>");
		}
		
	}
	/**用户注册user_register.do
	 * @throws Exception */
	@RequestMapping("/user_register")
	public ModelAndView userRegister(HttpServletRequest request,HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		User user = new User();
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setPhone(Long.parseLong(request.getParameter("phone")));
		if(!request.getParameter("email").equals("")){
			user.setEmail(request.getParameter("email"));
		}
		user.setSex(Boolean.parseBoolean(request.getParameter("sex")));
		user.setIP(request.getRemoteAddr());
		user.setRegDate(new Timestamp(System.currentTimeMillis()));
		
		if(userService.checkUserName(request.getParameter("username"))){
			mav.setViewName("register");
			mav.addObject("msg", "此用户名已存在！注册失败！");
			return mav;
		}
		
		if(null != userService.register(user)){
			mav.setViewName("index");
			session.setAttribute("user", user);
		}else{
			mav.setViewName("register");
			mav.addObject("msg", "注册失败");
		}
		return mav;
	}
	
	/**根据关键字查询searchKeyword.do*/
	@RequestMapping("/searchKeyword")
	public ModelAndView searchKeyword(HttpServletRequest request,OrderFormDto orderFormDto,HttpSession session) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		
		String keyword = request.getParameter("keyword");
		List<Product> productList25Last=productService.findByKeyword(keyword);
		//展示分类
		categoryList = categoryService.findAll();
		//展示商品
		productList = productService.findAll();
		mav.setViewName("index");
		mav.addObject("categoryList", categoryList);
		mav.addObject("productList", productList);
		mav.addObject("productList25Last", productList25Last);
		return mav;
	}
	
	/**根据类别查询searchCategory.do*/
	@RequestMapping("/searchCategory")
	public ModelAndView searchCategory(HttpServletRequest request,OrderFormDto orderFormDto,HttpSession session) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();
		
		String categoryId = request.getParameter("categoryId");
		System.out.println("-----:"+categoryId);
		List<Product> productList25Last=new LinkedList<Product>();
		//productList25Last.clear();
		//展示分类
		categoryList = categoryService.findAll();
		//展示商品
		productList = productService.findAll();
		for(Product p : productList){
			if(p.getCategory().getId() == Integer.parseInt(categoryId)){
				productList25Last.add(p);
			}
		}
		mav.setViewName("index");
		mav.addObject("categoryList", categoryList);
		mav.addObject("productList", productList);
		mav.addObject("productList25Last", productList25Last);
		return mav;
	}
	
	/**根据用户名查询对应的定单searchOrderByUsername.do?username=${user.name }*/
	@RequestMapping("/searchOrderByUsername")
	public ModelAndView searchOrderByUsername(HttpServletRequest request,HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String username = request.getParameter("username");
		List<SalesOrder> orders = this.salesOrderService.findByOderUser(username);
		try{
			SalesOrder order = orders.get(0);
			Set<SaleItem> items =order.getSaleItems();
			double totalPrice=0.0;
			for(SaleItem item:items){
				totalPrice += item.getNumber()*item.getPrice();
			}
			
			if(orders != null){
				mav.addObject("orders", orders);
				mav.addObject("totalPrice", totalPrice);
				mav.setViewName("order");
			}
		}catch(IndexOutOfBoundsException e){
			mav.setViewName("order");
			return mav;
		}
		return mav;
	}
	
	/**查询定单详细信息orderDetail.do*/
	@RequestMapping("/orderDetail")
	public ModelAndView orderDetail(HttpServletRequest request,HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String orderCode = request.getParameter("orderCode");
		List<SalesOrder> orders = salesOrderService.findByOderCode(orderCode);
		
		SalesOrder order = orders.get(0);
		Set<SaleItem> items =order.getSaleItems();
		double totalPrice=0.0;
		for(SaleItem item:items){
			totalPrice += item.getNumber()*item.getPrice();
		}
		if(orders != null){
			mav.addObject("order", order);
			mav.addObject("items", items);
			mav.addObject("totalPrice", totalPrice);
			mav.setViewName("orderdetail");
		}
		return mav;
	}
}
