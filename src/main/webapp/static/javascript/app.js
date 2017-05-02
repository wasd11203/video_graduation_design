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
				'ngSanitize', 'ui.router', 'ngAnimate', 'ui.bootstrap', 'ng.ueditor','ui-notification','tm.pagination'
		]).config(function($stateProvider, $urlRouterProvider, $httpProvider){

	$stateProvider
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
	.state('maincontent.girdslayout', {
		url : '/girdslayout?:vTopId',
		cache:false, 
		templateUrl : 'views/show-girds-layout.html',
		controller : 'GirdsLayoutCtrl',
		controllerAs : 'girdsLayoutCtrl'
	})
	.state('maincontent.listbytop', {
		url : '/listbytop?:vTopId',
		cache:false, 
		templateUrl : 'views/list-videos-bytop.html',
		controller : 'ListByTopCtrl',
		controllerAs : 'listByTopCtrl'
	})
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
		
	});
	

	$urlRouterProvider.otherwise('maincontent/girdslayout');
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
})
.config(function(NotificationProvider){
	NotificationProvider.setOptions({
            maxCount:3
        });
});