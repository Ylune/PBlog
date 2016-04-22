var pBlogApp = {};

var APP = angular.module('pBlogApp', ['ngAnimate', 'ngRoute', 'ngSanitize', 'pBlogApp.filters', 'pBlogApp.services', 'pBlogApp.directives']).
    config(['$routeProvider',
        function ($routeProvider) {
            $routeProvider.when('/index', {
                templateUrl: '/index/layout',
                controller: IndexController
            });

            $routeProvider.when('/archives', {
                templateUrl: '/archives/layout',
                controller: ArchivesController
            });
    /*

        $routeProvider.when('/archives', {
            templateUrl: '',
            controller: ArchivesController
        });

        $routeProvider.when('/categores', {
            templateUrl: '',
            controller: CategoryController
        });

        $routeProvider.when('/read', {
            templateUrl: '',
            controller: ReadController
        });

        $routeProvider.when('/diary', {
            templateUrl: '',
            controller: DiaryController
        });
    */
        $routeProvider.otherwise({redirectTo: '/index'});
    }]);