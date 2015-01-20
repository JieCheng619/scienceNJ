/**���˵�*/
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
	title : "����ģ�鵼��",
	layout : 'accordion',
	layoutConfig : {
		titleCollapse : false,
	    animate : true,
	    activeOnTop :true
	},
	items : [{
		title : "�û�����",
		items : [{
			xtype : "treepanel",
			rootVisible : false,
			displayField : "text",
			border : 0 ,
			root : {
				expanded : true,
				children : [{
					id : "usermanage",
					text : "�û�������Ϣ",
					leaf :true
				}]
			}
		}]
	},
	{
		title : "��Ʒ������",
		items : [{
			xtype : "treepanel",
			rootVisible : false,
			displayField : "text",
			border : 0 ,
			root : {
				expanded : true,
				children : [{
					id : "caregorymanage",
					text : "��Ʒ���",
					leaf :true
				}]
			}
		}]
	}]
});