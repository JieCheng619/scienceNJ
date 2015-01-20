/*
 * ClassName 用户数据集
 */
 Ext.define("core.category.store.CategoryStore",{
 	extend:'Ext.data.TreeStore',
	defaultRootId:"root",
	//autoSync:true,//与服务器同步
//	proxy:{
//		api:{
//		},
//		type:"ajax",
//		url:"./category/list_category.do",
//		reader:{
//			type:"json"
//		},
//		writer:{
//			type:"json"
//		}
//	},
//	autoLoad:true	
	root: {
        expanded: true,
        children: [
            { text: "detention", leaf: true },
            { text: "homework", expanded: true, children: [
                { text: "book report", leaf: true },
                { text: "alegrbra", leaf: true}
            ] },
            { text: "buy lottery tickets", leaf: true }
        ]
    }
 });