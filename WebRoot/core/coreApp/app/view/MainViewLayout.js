/**
 * ��������沼��
 */
Ext.define("core.app.view.MainViewLayout",{
	extend : "Ext.panel.Panel",
	border : 0,
	layout : "border",
	alias : "widget.mainviewlayout",//����
	width : 10,
	height :10,
	items : [{
		region : "north",
		xtype : "topview"
	},{
		region : "west",
		xtype : "westview"
	},{
		region : "center",
		layout : "fit",
		margins : "2 0 0 0",//��������
		items : [{
			xtype : "centerview"
			//ʱ�����ѵ�gridpanel
		}]
	}],
	initComponent : function(){
		this.callParent(arguments);
	}
});