/**北部*/
Ext.define("core.app.view.TopView",{
	extend : "Ext.panel.Panel",
	alias : "widget.topview",
	id : "topview",
	height : 50,
	bodyStyle : {
	background : "#157fcb",
		padding : "10px"
	},
	layout : "absolute",
	items : [{
		x : 0,//第一个点的位置
		y : 0,//
		width : 230,
	},{
	  x : 230,
	  y :0,
	  width : 450 ,
	  bodyStyle : {
		  background : "#157fcb"
	  },
	  border : 0 ,
	  padding : "2px",
	  html : "<h1><font color=white size=5>后台管理系统</font></h1>"
	},{
		x : 800,
		y : 20,
		ref : "logininfo",
		xtype : "displayfield",
		id : "displaylogin",
		value : "<font color=white>未登录</font>"
	},{
		x:960,
		y:20,
		xtype : "button",
		ref : "exit",
		text : "退出系统"
	}] 
});