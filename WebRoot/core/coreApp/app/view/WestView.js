/**左侧菜单*/
Ext.define("core.app.view.WestView",{
	extend : "Ext.panel.Panel",
	alias : "widget.westview",
	collapsible : true,
	split : true,
	defaults  : {
		bodyStyle : "padding : 2px"
	},
	border : 1,
	margin : "2 2 0 0",
	width : 225,
	minSize :100,
	maxSize :250,
	title : "功能模块导航",
	layout : 'accordion',
	layoutConfig : {
		titleCollapse : false,
	    animate : true,
	    activeOnTop :true
	},
	items : [{
		title : "用户管理",
		items : [{
			xtype : "treepanel",
			rootVisible : false,
			displayField : "text",
			border : 0 ,
			root : {
				expanded : true,
				children : [{
					id : "usermanage",
					text : "用户基本信息",
					leaf :true
				}]
			}
		}]
	},
	{
		title : "商品类别管理",
		items : [{
			xtype : "treepanel",
			rootVisible : false,
			displayField : "text",
			border : 0 ,
			root : {
				expanded : true,
				children : [{
					id : "caregorymanage",
					text : "商品类别",
					leaf :true
				}]
			}
		}]
	}]
});