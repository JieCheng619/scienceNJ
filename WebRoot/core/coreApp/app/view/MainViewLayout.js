/**
 * 主程序界面布局
 */
Ext.define("core.app.view.MainViewLayout",{
	extend : "Ext.panel.Panel",
	border : 0,
	layout : "border",
	alias : "widget.mainviewlayout",//别名
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
		margins : "2 0 0 0",//上右下左
		items : [{
			xtype : "centerview"
			//时间提醒的gridpanel
		}]
	}],
	initComponent : function(){
		this.callParent(arguments);
	}
});