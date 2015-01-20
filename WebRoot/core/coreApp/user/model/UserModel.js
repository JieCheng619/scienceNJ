/*
 * 用户实体类
 */
 Ext.define("core.user.model.UserModel",{
 	extend:"Ext.data.Model",
 	fields:[
 		{name:"id",type:"int",srotable:true},
 		{name:"userName",type:"string",srotable:true},
 		{name:"password",type:"string",srotable:true},
 		{name:"sex",type:"boolean",srotable:true},
 		{name:"phone",type:"long",srotable:true},
 		{name:"QQ",type:"string",srotable:true},
 		{name:"email",type:"string",srotable:true},
 		{name:"addr",type:"string",srotable:true},
 		{name:"regDate",type:"string",srotable:true},
 		{name:"IP",type:"string",srotable:true}
 	]
 });