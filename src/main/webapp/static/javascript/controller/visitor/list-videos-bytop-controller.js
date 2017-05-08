'use strict';

/**
 * @ngdoc function
 * @name vShow.controller: ListByTopCtrl
 * @description # ListByTopCtrl Controller of the vShow
 */
angular.module('vShow').controller('ListByTopCtrl',
		function($scope, $rootScope, $stateParams, commonservice,$state) {
			this.awesomeThings = [ 'HTML5 Boilerplate', 'AngularJS', 'Karma' ];
			$scope.param = $stateParams;
			console.log($scope.param);

			/**
		     * 分页插件配置
		     */
		    $scope.paginationConf = {
		            currentPage: 1,//当前页
		            totalItems: 0,//所有的记录数
		            itemsPerPage: 4,//每页的记录数
		            pagesLength: 15,// 用于计算可被点击的总页数
		            perPageOptions: [4],// 用于选择的 每页显示的记录数 数组
		            onChange: function(){
		            	
		            	var curPage = $scope.paginationConf.currentPage;
		            	var vSecId = $scope.param.vSecId;
		            	$scope.listGirdsByTopAndSecNav(vSecId,curPage);
		            }
		        };
			
			$scope.initGirds = function() {
				$scope.listGirdsByTopNav($scope.param);
			}

			/**
			 * 触发获取指定一级菜单下的第一页的视频列表的方法
			 */
			$scope.listGirdsByTopNav = function(param) {
				param.vSecId = '';
				param.curPage = 1;
				var url = 'home/listByNav';
				$scope.listGirdsAction(url, param);
			}

			/**
			 * 获取指定的 一级菜单，二级菜单的 指定页数据
			 */
			$scope.listGirdsByTopAndSecNav = function(secId,curPage){
				$scope.param.vSecId = secId;
				$scope.param.curPage = curPage;
				var url = 'home/listByNav';
				$scope.updateGirdsAction(url, $scope.param);
				
				return false;
			}
			
			/**
			 * 更换 视频列表
			 */
			$scope.updateGirdsAction = function(url, param) {

				commonservice.postData(url, param).then(function(res) {
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
			 * 列举 获取的菜单以及视频列表
			 */
			$scope.listGirdsAction = function(url, param) {

				commonservice.postData(url, param).then(function(res) {
					console.log(res.data);
					$scope.data = res.data;
					$scope.param.vSecId = $scope.data.top.secList[0].vSecId;

					$scope.data.top.minIndex = 0;
					$scope.data.top.maxIndex = 4;
					$scope.data.top.navPageSize = 4;

					$scope.data.top.preDisabled = true;
					if($scope.data.top.maxIndex > $scope.data.top.secList.length-1){
//    					alert("禁止下一页");
						$scope.data.top.nextDisabled = true;
    				}else{
    					$scope.data.top.nextDisabled = false;
    				}
					
					$scope.list = $scope.data.list;

					if($scope.list[0] == null){
						$scope.paginationConf.totalItems = 0;
					}else{
						$scope.paginationConf.totalItems = $scope.data.count;
					}
					
				}, function(res) {
					alert(res.status);
				});
			}

			/**
			 * 修改二级菜单的显示
			 */
			$scope.changeSecNavShow = function(top, type) {

				switch (type) {
				case 1:
					
					var min = top.minIndex + top.navPageSize;
					var max = top.maxIndex + top.navPageSize;

					if (max > top.secList.length-1) {
						// alert("禁止下一页");
						top.nextDisabled = true;
						top.preDisabled = false;
					} else {
						top.nextDisabled = false;
						top.preDisabled = false;
					}
					top.minIndex = min;
					top.maxIndex = max;

					break;
				case 0:
					var min = top.minIndex - top.navPageSize;
					var max = top.maxIndex - top.navPageSize;

					if (min <= 0) {
						// alert("禁止上一页");
						top.preDisabled = true;
						top.nextDisabled = false;
					} else {
						top.preDisabled = false;
						top.nextDisabled = false;
					}
					top.minIndex = min;
					top.maxIndex = max;

					break;
				}

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
