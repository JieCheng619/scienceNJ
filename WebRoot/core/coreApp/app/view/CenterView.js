/**ÖÐ²¿*/
Ext.define("core.app.view.CenterView",{
 extend : "Ext.tab.Panel",
 alias : "widget.centerview",
 id : "centerid",
 border : 0,
 bodyStyle : "padding:0px",
 menuAlign:"center",
 items:[{
	 title:"<center height=40>Ê×Ò³</center>",
	 bodypadding:5,
	 layout:"fit",
	 items:{},
	 tabConfig : {
		 
	 }
 }],
 initComponent:function(){
	 this.callParent(arguments);
 }
});


