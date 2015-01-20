/**
 * 文件开始
 */
Ext.onReady(function(){
	//打开extjs的提示功能
	//Ext.quickTips.init();
	//启动动态加载JS
//	Ext.Loader().setConfig({
//		enabled:true
//	});
	//开始执行程序
	Ext.application({
		name : "core",//命名空间，例如core.view.LoginWindow调用
		appFolder : "core/coreApp",//文档宝
		launch:function(){
			Ext.create("Ext.container.Viewport",{
				layout : "fit",
				border : 0,
				items : [{
					xtype:"mainviewlayout"
				}]
			});
		},
		controllers : ["core.app.controller.MainController"]
	});
});