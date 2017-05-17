'use strict';

/**
 * @ngdoc function
 * @name vShow.controller: GirdsLayoutCtrl
 * @description
 * # GirdsLayoutCtrl
 * Controller of the vShow
 */
angular.module('vShow')
    .controller('GirdsLayoutCtrl', function ($scope, $rootScope,commonservice,$state) {
    	this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    	
    	/**
    	 * 初始化 内容页
    	 */
    	$scope.initGirds = function(){
    		$scope.listGirds();
    	}
    	
    	/**
    	 * 触发获取所有菜单以及每个菜单下部分视频列表的方法
    	 */
    	$scope.listGirds = function (){
    		var url = 'home/list/json';
    		var param = {};
    		$scope.listGirdsAction(url,param);
    	}
    	
    	/**
    	 * 列举 获取的菜单以及视频列表
    	 */
    	$scope.listGirdsAction = function(url,param){
    		
    		commonservice.postData(url,param).then(function(res){
    			console.log(res.data);
    			$scope.navsAndVideos = [];
				
    			angular.forEach(res.data,function(data,index,array){
    				data.curIndex = 0;
    				data.maxIndex = 4;
    				data.dropList = [];
    				data.leftList = [];
    				if(data.secList.length >= data.maxIndex){
    					for(var i = data.maxIndex ;i<data.secList.length;i++){
    						data.dropList.push(data.secList[i]);
    					}
    				}
    				for(var i = 0 ;i<data.maxIndex;i++){
    					data.leftList.push(data.secList[i]);
					}	
    				
    				$scope.navsAndVideos.push(data);
    			});
    			
//    			console.log($scope.navsAndVideos);
    			
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	/**
    	 * 修改当前显示的视频列表
    	 */
    	$scope.changeVideos = function(navAndVideos,index){
    		console.info("args:",navAndVideos,index);
    		navAndVideos.curIndex = index;
    		console.info(navAndVideos.secList[navAndVideos.curIndex].videos);
    		return false;
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
