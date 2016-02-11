angular.module('staticApp').factory('PostSearch', [ '$resource', function($resource) {
	return $resource('/api/post/search/findByTypeAndTitleLike?type=:type&title=:title', {
		id : '@id',
		type: '@type'
	}, {
		'findByTitleLike' : {
			method : 'GET',
			action :'findByTypeAndTitleLike',
			transformResponse : function(data) {
				return angular.fromJson(data);
			}
		}
	}, {
	});
} ]);