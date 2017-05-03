'use strict';

/**
 * @ngdoc overview
 * @name workbenchApp
 * @description
 * # workbenchApp
 *
 * Main module of the application.
 */
angular.module(
		'vShow',
		[
				'ngResource', 'smart-table', 'ui.tree', 'ngDialog', 'angular-loading-bar', 'http-auth-interceptor', 'ngFileUpload', 'ngCookies',
				'ngSanitize', 'ui.router', 'ngAnimate', 'ui.bootstrap', 'ng.ueditor','ui-notification','tm.pagination',
				
				// 视频插件模块
				//'ngSanitize',
				'com.2fdevs.videogular',
				'com.2fdevs.videogular.plugins.controls',
				'com.2fdevs.videogular.plugins.overlayplay',
				'com.2fdevs.videogular.plugins.poster'
		]).config(function($stateProvider, $urlRouterProvider, $httpProvider){

	$stateProvider
	/**
	 * 主要内容页 路由配置
	 */
	.state('maincontent', {
		url : '/maincontent',
		views:{
			'maincontent':{
				templateUrl : 'views/maincontent.html',
				controller : 'MaincontentCtrl',
				controllerAs : 'maincontentCtrl'
			}
		}
		
	})
	/**
	 * 内容页右侧 视频概览显示 路由配置
	 */
	.state('maincontent.girdslayout', {
		url : '/girdslayout?:vTopId',
		cache:false, 
		templateUrl : 'views/show-girds-layout.html',
		controller : 'GirdsLayoutCtrl',
		controllerAs : 'girdsLayoutCtrl'
	})
	/**
	 * 内容页右侧 按类别显示视频 路由配置
	 */
	.state('maincontent.listbytop', {
		url : '/listbytop?:vTopId',
		cache:false, 
		templateUrl : 'views/list-videos-bytop.html',
		controller : 'ListByTopCtrl',
		controllerAs : 'listByTopCtrl'
	})
	/**
	 * 内容页右侧 搜索结果页 路由配置
	 */
	.state('maincontent.result', {
		url : '/result?:keywords&:curPage',
		cache:false, 
		views:{
			'':{
				templateUrl : 'views/result.html',
				controller : 'ResultCtrl',
				controllerAs : 'resultCtrl'
			}
		
		}
		
	})
	/**
	 * 视频详情 路由配置
	 */
	.state('maincontent.detail', {
		url : '/detail?:vId&:vSecId',
		cache:false, 
		views:{
			'':{
				templateUrl : 'views/show-detail.html',
				controller : 'DetailCtrl',
				controllerAs : 'DetailCtrl'
			}
		
		}
		
	});
	

	$urlRouterProvider.otherwise('maincontent/girdslayout');
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
})
.config(function(NotificationProvider){
	NotificationProvider.setOptions({
            maxCount:3
        });
});