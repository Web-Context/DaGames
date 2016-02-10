'use strict';

/**
 * @ngdoc function
 * @name staticApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the staticApp
 */
angular.module('staticApp')
  .controller('MainCtrl', ['$scope','Game', function ($scope, Game) {
	  Game.query(function(response) {
	      $scope.games = response._embedded.post ? response._embedded.post : [];
	  });
  }]);
