/**��������*/
Ext.define("core.app.controller.MainController",{
	extend : "Ext.app.Controller",
	init : function(){
		var self = this;
		//�����Ӵ���Ĺ��÷���
		this.addChildView = function(childObject){
			if(childObject){
				var mainView = childObject.mainView;
				var cPanel = mainView.down(childObject.cViewXtype);
				if(!cPanel){
					//self.application.getController(childObject.cController).init();����init��ִ��2�Σ�ӦΪgetController����ͻ��ʼ��
					self.application.getController(childObject.cController);
					cPanel=Ext.create(childObject.cViewName);
					mainView.add(cPanel);
					mainView.setActiveTab(cPanel);
				}else{									
					mainView.setActiveTab(cPanel);
				}
			}
		}
		//����Ҳҳ���е�ĳһ��Ԫ��
		this.control({
			//�ҵ�westview��Ϊ treepanel��Ԫ��
			"westview treepanel":{
				//����¼�tree:ָ���view,record:����ѡ��ļ�¼��index:ѡ������,e:�¼�����eOpts:The options object passed to Ext.util.Observable.addListener.
				itemclick:function(tree,record,index,e,eOpts){
					//up:����ָ����Ԫ��,down:���������ĵ�һ�������
					var mainView = tree.up("mainviewlayout").down("centerview");
					/*�û�����*/
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