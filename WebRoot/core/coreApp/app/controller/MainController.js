/**主控制器*/
Ext.define("core.app.controller.MainController",{
	extend : "Ext.app.Controller",
	init : function(){
		var self = this;
		//创建子窗体的公用方法
		this.addChildView = function(childObject){
			if(childObject){
				var mainView = childObject.mainView;
				var cPanel = mainView.down(childObject.cViewXtype);
				if(!cPanel){
					//self.application.getController(childObject.cController).init();调用init会执行2次，应为getController本身就会初始化
					self.application.getController(childObject.cController);
					cPanel=Ext.create(childObject.cViewName);
					mainView.add(cPanel);
					mainView.setActiveTab(cPanel);
				}else{									
					mainView.setActiveTab(cPanel);
				}
			}
		}
		//查找也页面中的某一个元素
		this.control({
			//找到westview下为 treepanel的元素
			"westview treepanel":{
				//点击事件tree:指向的view,record:属于选项的记录，index:选项索引,e:事件对象，eOpts:The options object passed to Ext.util.Observable.addListener.
				itemclick:function(tree,record,index,e,eOpts){
					//up:查找指定的元素,down:检索容器的第一层子组件
					var mainView = tree.up("mainviewlayout").down("centerview");
					/*用户管理*/
					if(record.data["id"]=="usermanage"){
						self.addChildView({
							mainView:mainView,
							cViewXtype:"userlayout",
							cController:"core.user.controller.UserController",
							cViewName:"core.user.view.UserLayout"
						});
					}else if(record.data["id"]=="caregorymanage"){
						alert("aaa");
						self.addChildView({
							mainView:mainView,
							cViewXtype:"categorylayout",
							cController:"core.category.controller.CategoryController",
							cViewName:"core.category.view.CategoryLayout"
						});
						
					}
				}//itemclick end 
			}//westview treepanel end 
		});
	},
	views : ["core.app.view.TopView",
	         "core.app.view.WestView",
	         "core.app.view.CenterView",
	         "core.app.view.MainViewLayout"
	         ],
	 store : [],
	 model : []
});