'use strict';

/**
 * @ngdoc function
 * @name vShow.controller: GirdsLayoutCtrl
 * @description
 * # GirdsLayoutCtrl
 * Controller of the vShow
 */
angular.module('vShow')
    .controller('GirdsLayoutCtrl', function ($scope, $rootScope,$stateParams,commonservice) {
    	this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    	$scope.param = $stateParams;
    	console.log($scope.param);
    	
    	/**
    	 * 初始化 内容页
    	 */
    	$scope.initGirds = function(){
    		if(!$scope.param.vTopId){
    			$scope.listGirds();
    		}
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
    				data.minIndex = 0;
    				data.maxIndex = 4;
    				data.navPageSize = 4;
    				data.preDisabled = true;
    				if(data.maxIndex > data.secList.length-1){
//    					alert("禁止下一页");
    					data.nextDisabled = true;
    				}else{
    					data.nextDisabled = false;
    				}
    				$scope.navsAndVideos.push(data);
    			});
    			
    	    	
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	/**
    	 * 修改 二级菜单的显示
    	 */
    	$scope.changeSecNavShow = function(navAndVideos,type){
    		
    		switch(type){
    			case 1:
    				
    				var min = navAndVideos.minIndex + navAndVideos.navPageSize;
    				var max = navAndVideos.maxIndex + navAndVideos.navPageSize;
    				
    				if(max > navAndVideos.secList.length-1){
//    					alert("禁止下一页");
    					navAndVideos.nextDisabled = true;
    					navAndVideos.preDisabled = false;
    				}else{
    					navAndVideos.nextDisabled = false;
    					navAndVideos.preDisabled = false;
    				}
    				
    				navAndVideos.minIndex = min;
					navAndVideos.maxIndex = max;
					
    				break;
    			case 0:
    				var min = navAndVideos.minIndex - navAndVideos.navPageSize;
    				var max = navAndVideos.maxIndex - navAndVideos.navPageSize;
    				
    				if(min <= 0){
//    					alert("禁止上一页");
    					navAndVideos.preDisabled = true;
    					navAndVideos.nextDisabled = false;
    				}else{
    					navAndVideos.preDisabled = false;
    					navAndVideos.nextDisabled = false;
    				}
    				navAndVideos.minIndex = min;
					navAndVideos.maxIndex = max;
    				
    				break;
    		}
    		
    		return false;
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
    	
    	
    });
