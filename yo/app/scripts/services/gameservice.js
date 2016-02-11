'use strict';

/**
 * @ngdoc service
 * @name staticApp.GameService
 * @description # GameService Service in the staticApp.
 */
angular.module('staticApp').factory('Game', [ '$resource', function($resource) {
	return $resource('/api/post/search/findByType?type=:type', {
		id : '@id',
		type: '@type'
	}, {
		'findByTitleLike' : {
			method : 'GET',
			action :'findByTypeAndTitleLike',
			transformResponse : function(data) {
				return angular.fromJson(data);
			}
		},
		'query' : {
			method : 'GET',
			transformResponse : function(data) {
				return angular.fromJson(data);
			}
		},
		'update' : {
			method : 'PUT',
			transformResponse : function(data) {
				return angular.fromJson(data);
			}
		},
		'remove' : {
			method : "DELETE"
		},
		'save' : {
			method : 'POST',
			transformRequest : function(data) {
				return angular.toJson(data);
			}
		}
	}, {
	});
} ]);
