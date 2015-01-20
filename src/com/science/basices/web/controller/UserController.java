package com.science.basices.web.controller;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.science.basics.domain.User;
import com.science.basics.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
    @Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * ��ҳ��ʾ�����û���Ϣ
	 */
	@RequestMapping(value="/list_user",method=RequestMethod.GET)
	public void listUser(HttpServletRequest request, PrintWriter writer) {
		String startStr = request.getParameter("start");
		String limitStr = request.getParameter("limit");
		//if(this.len == 0){
		List<User> users = userService.getPersons(Integer.parseInt(startStr), Integer.parseInt(limitStr));
			//this.setLen(users.size());
		//}
		int len = users.size();
		String preStr = "{totalCount:" + userService.getCount() + ",rows:[";
		String cenStr = "";
		int i=0;
		String douhao = ",";
		for(User user : users) {
			i++;
			cenStr += "{id:'"+user.getId()+"', " +
					"userName:'"+user.getUserName()+"'," +
					"password:'"+user.getPassword()+"'," +
					"sex:'"+user.isSex()+"'," +
					"phone:'"+user.getPhone()+"'," +
					"QQ:'"+user.getQQ()+"'," +
					"email:'"+user.getEmail()+"'," +
					"addr:'"+user.getAddr()+"'," +
					"regDate:'"+user.getRegDate()+"'," +
					"IP:'"+user.getIP()+"'" +
			"}";
			if(i < len){
				cenStr += douhao;
			}
		}
		String endStr = "]}";
		String resultStr = preStr + cenStr + endStr;
		System.out.println(cenStr);
		writer.write(resultStr);
	}
	/**����û�*/
	@RequestMapping(value="/add_user",method=RequestMethod.POST)
	public void addUserr(HttpServletRequest request,PrintWriter writer) {
		//û��uidΪ�ղ���ע��ΪUser�Ķ�����������Լ�������
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setPhone(Long.parseLong(request.getParameter("phone")));
		user.setAddr(request.getParameter("addr"));
		user.setQQ(request.getParameter("QQ"));
		user.setIP(request.getRemoteAddr());
		user.setRegDate(new Timestamp(System.currentTimeMillis()));
		try{
			if(null !=userService.register(user)){
				writer.write("{success:true, msg:'�����ɹ�!'}");
			}else{
				writer.write("{success:false, msg:'����ʧ��!'}");
			}
		}catch(Exception e){
			writer.write("{success:false, msg:'����ʧ��!'}");
		}
	}
	
	/**�޸��û�*/
	@RequestMapping(value="/update_user",method=RequestMethod.POST)
	public void updateUser(HttpServletRequest request, User user,PrintWriter writer) {
		
		user.setIP(request.getRemoteAddr());
		user.setRegDate(new Timestamp(System.currentTimeMillis()));
		
		if(userService.modify(user)){
			writer.write("{success:true,msg:'�޸ĳɹ�!'}");
		}else{
			writer.write("{success:false,msg:'�޸�ʧ��!'}");
		}
	}
	
	/**ɾ���û�*/
	@RequestMapping(value="/remove_user",method=RequestMethod.POST)
	public void deleteUser(HttpServletRequest request, PrintWriter writer) {
		
		String[] ids = request.getParameter("ids").replaceAll("\"", "").split(",");
		
		if(userService.remove(ids)){
			writer.write("{success:true,msg:'ɾ���ɹ�!'}");
		}else{
			writer.write("{success:false,msg:'ɾ��ʧ��!'}");
		}
	}
}
