'use strict';

/**
 * @ngdoc function
 * @name staticApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the staticApp
 */
angular.module('staticApp')
  .controller('MainCtrl', ['$scope','Games', function ($scope, Games) {
  	$scope.games = Games.query();
  }]);
