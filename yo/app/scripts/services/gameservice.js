'use strict';

/**
 * @ngdoc service
 * @name staticApp.GameService
 * @description
 * # GameService
 * Service in the staticApp.
 */
angular.module('staticApp')
  .factory('Games',['$resource', function ($resource) {
	  return $resource('http://localhost:8080/api/post/:id', 
	  	{ id: '@id'}, 
	  	{ update: { method:'PUT' }
	  });
  }]);
