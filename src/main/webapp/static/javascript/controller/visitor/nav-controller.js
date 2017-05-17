'use strict';

/**
 * @ngdoc function
 * @name vShow.controller: NavCtrl
 * @description
 * # NavCtrl
 * Controller of the vShow
 */
angular.module('vShow')
    .controller('NavCtrl', function ($scope, commonservice,$state,$stateParams) {
    	this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    	
//    	console.log($stateParams);
    	var vTopId = $stateParams.vTopId;
    	
    	$scope.initCtrl = function(){
    		var url = "nav/list/top";
    		var param = {};
    		commonservice.postData(url,param).then(function(res){
    			console.log(res.data);
    			$scope.list = res.data;
    			if(vTopId){
    				angular.forEach($scope.list,function(data,index,array){
    					if(data.V_TOP_ID == vTopId){
    						$scope.list.curIndex = index;
    					}
    				});
    			}
    			
    		},function(res){
    			alert(res.status);
    		});
    		if($state.is("maincontent")||$state.is("maincontent.girdslayout")){
    			$state.go("maincontent.girdslayout",{"vTopId":''},[]);
    		}
    	}
    	
    	/**
    	 * 路由跳转时使用params传递参数。。无法实现刷新时保留参数
    	 */
    	$scope.go = function(vTopId,index){
    		var param = {"vTopId":vTopId};
    		
    		$scope.list.curIndex = index;
    		
    		$state.go("maincontent.listbytop",param,{reload:true});
    		console.log(vTopId);
    	}
    	
    });
