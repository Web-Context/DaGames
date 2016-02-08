'use strict';

/**
 * @ngdoc service
 * @name staticApp.GameService
 * @description
 * # GameService
 * Service in the staticApp.
 */
angular.module('staticApp')
  .service('GameService',['$resource', function ($resource) {
	  var Game = $resource('/post/:id', {id:'@id'});
	  Game.get({id:123})
	      .$promise.then(function(user) {
	        $scope.user = user;
	      });
  }]);
