angular.module('staticApp',[])
  .controller('SearchCtrl', ['$scope','PostSearch', function ($scope, PostSearch) {
	  var type  = $scope.type;
	  var title = $scope.title;
	  $scope.search = function(){
		  PostSearch.findByTypeAndTitleLike({'type':type,'title':title},function(response) {
		      $scope.results = response._embedded.post ? response._embedded.post : [];
		  });	  
	  };
  }]);