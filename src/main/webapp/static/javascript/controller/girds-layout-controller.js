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
    	
    	$scope.initGirds = function(){
    		if(!$scope.param.vTopId){
    			$scope.listGirds();
    		}else{
    			$scope.listGirdsByTopNav($scope.param);
    		}
    	}
    	
    	/**
    	 * 触发获取指定菜单下的视频列表的方法
    	 */
    	$scope.listGirdsByTopNav = function (param){
    		param.curPage = 1;
    		var url = 'home/listByNav';
    		$scope.listGirdsAction(url,param);
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
    			$scope.navsAndVideos = res.data;
    	    	
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	
    });
