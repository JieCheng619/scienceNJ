/**
 * �ļ���ʼ
 */
Ext.onReady(function(){
	//��extjs����ʾ����
	//Ext.quickTips.init();
	//������̬����JS
//	Ext.Loader().setConfig({
//		enabled:true
//	});
	//��ʼִ�г���
	Ext.application({
		name : "core",//�����ռ䣬����core.view.LoginWindow����
		appFolder : "core/coreApp",//�ĵ���
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