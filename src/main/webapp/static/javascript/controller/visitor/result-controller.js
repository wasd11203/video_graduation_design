'use strict';

/**
 * @ngdoc function
 * @name vShow.controller: ResultCtrl
 * @description
 * # ResultCtrl
 * Controller of the vShow
 */
angular.module('vShow')
    .controller('ResultCtrl', function ($scope, $stateParams,commonservice,$state) {
    	this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    	
    	var params = $stateParams;
    	
    	console.log(params);
    	
    	$scope.initCtrl = function(){
    		$scope.searchByKeywordsAction();
    	}
    	
    	/**
	     * 分页插件配置
	     */
	    $scope.paginationConf = {
            currentPage: 1,//当前页
            totalItems: 0,//所有的记录数
            itemsPerPage: 15,//每页的记录数
            pagesLength: 15,// 用于计算可被点击的总页数
            perPageOptions: [15],// 用于选择的 每页显示的记录数 数组
            onChange: function(){
            	
            	params.curPage = $scope.paginationConf.currentPage;
            	$scope.searchByKeywordsAction();
            }
        };
		
    	
    	$scope.searchByKeywordsAction = function(){
       		var url = "home/search";
    		commonservice.postData(url, params).then(function(res) {
    			console.log(res.data);
    			$scope.list = res.data.list;
    			
    			if($scope.list[0] == null){
    				$scope.paginationConf.totalItems = 0;
    			}else{
    				$scope.paginationConf.totalItems = res.data.count;
    			}
    			
    		}, function(res) {
    			alert(res.status);
    		});
    	}
    	
    	/**
    	 * 路由切换到 详情页
    	 */
    	$scope.toDetail = function(video){
    		var param = {"vId":video.vId,"vSecId":video.vSecId};
    		$state.go('maincontent.detail',param,{reload:true});
    		
    		return false;
    	}
    	
    });
