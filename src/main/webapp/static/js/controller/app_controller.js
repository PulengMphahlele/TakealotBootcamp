'use strict';

angular.module('myApp').controller('appctrl',["$scope", "httpService","$location","$window",function($scope,httpService,$location,$window){
	
	/*To Validate the User*/
	 $scope.validateuser=function(){
		var emailAddress=$scope.emailAddress;
		var password=$scope.password;
	var formdata={
				emailAddress:emailAddress,
				password:password
				
		};
		var details={
				
				getUrl:"rest/isvalid",
				getFormData:formdata
				
		};
		
		httpService.getDataByForm(details).then(onSuccessRetrival, onError);
	 };
		
		var onSuccessRetrival = function(data) {
		
			$window.localStorage.setItem("emailAddress",data.emailAddress);
			$scope.logged=data.emailAddress;
			console.log($scope.logged);
			
			$location.path('/home');
                       };
                       $scope.toLogin=function(){
                                    $location.path('/toLogin');

                                    };
		var onError = function(reason) {
			alert("Invalid Login");
			
		};
		
		/*To display Logged in User*/
		$scope.$watch('logged',function(newValue,oldValue){
			$scope.logged=$window.localStorage.getItem("emailAddress");
			console.log($scope.logged+"**");
			
			
		});
		/*To add the article*/
		
		$scope.createUser = function(){
         
                        
                        var userID=$scope.userID;
			var firstName=$scope.firstName;
			var lastName=$scope.lastName;
                        var emailAddress=$scope.emailAddress;
			var password=$scope.password;
                        var phone=$scope.phone;
			var gender=$scope.gender;
                        var birthdate=$scope.birthdate;
		var formdata={
				"userID":userID,
                                "firstName":firstName,
				"lastName":lastName,
                                "emailAddress":emailAddress,
				"password":password,
                                "phone":phone,
				"gender":gender,
                                "birthdate":birthdate
						
			};
                       
			var details={
					
					getUrl:"rest/createUser",
					getFormData:formdata
					
			};
			
			httpService.getDataByForm(details).then(onSuccessRetrivals, onErrorUser);
		 };
		 var onErrorUser = function(reason) {
				alert("User is not added");
				
			};
			
			var onSuccessRetrivals = function(data) {
			alert("User Added");
			$location.path('/home');
			};
			
			 $scope.newUser=function(){
				 $location.path('/newUser');
			
                             };
				 
                        $scope.userCart=function(){
                                $location.path('/userCart');

                             };
                             
               
		
                            /*Go to Home*/
                            $scope.goToHome=function(){
                                    $location.path('/home');

                            };
		 
	
        }
	
]);
angular.module('myApp').controller('adminctrl',["$scope", "httpService","$location","$window",function($scope,httpService,$location,$window){
	
        
	/*To Validate the Admin*/
	 $scope.validateAdmin=function(){
		var emailAddr=$scope.emailAddr;
		var password=$scope.password;
	var formdata={
				emailAddress:emailAddr,
				password:password
				
		};
		var details={
				
				getUrl:"rest/validAdmin",
				getFormData:formdata
				
		};
		
		httpService.getDataByForm(details).then(onSuccessRetrival, onError);
	 };
		
		var onSuccessRetrival = function(data) {
		
			$window.localStorage.setItem("emailAddr",data.emailAddr);
			//$scope.logged=data.emailAddress;
			//console.log($scope.logged);
			$location.path('/adminPanel');
			//$scope.getUserDetails();
			
		};
		
		var onError = function(reason) {
			alert("Invalid Login");
			
		};
		
		/*To display Logged in Admin*/
		$scope.$watch('logged',function(newValue,oldValue){
			$scope.logged=$window.localStorage.getItem("emailAddress");
			console.log($scope.logged+"**");
			
			
		});
                $scope.adminLogin=function(){
                        $location.path('/admin');

                };
               
		
                            /*Go to Home*/
                            $scope.goToHome=function(){
                                    $location.path('/home');

                            };
		 /*To add the Product*/
             
		
		$scope.addProduct = function(){
         
                        var productId=$scope.productId;
			var productName=$scope.productName;
			var productImage=$scope.productImage;
                        var productPrice=$scope.productPrice;
			
		var formdata={
				"productId":productId,
                                "productName":productName,
				"productImage":productImage,
                                "productPrice":productPrice
				
						
			};
                       
			var details={
					
					getUrl:"rest/addProduct",
					getFormData:formdata
					
			};
			alert(productImage +''+ productName +''+ productPrice);
			httpService.getDataByForm(details).then(onSuccessRetrivals, onErrorProduct);
		 };
		 var onErrorProduct = function(reason) {
				alert("Product is not added");
				
			};
			
			var onSuccessRetrivals = function(data) {
			alert("Product successfully Added");
			$location.path('/adminPanel');
			};
			
	 $scope.productImage = null;
        
        $scope.resetFile = function () {
            $scope.productImage = null;
        };
   
     }
]);
// .directive('bindFile', [function () {
//    return {
//        require: "ngModel",
//        restrict: 'A',
//        link: function ($scope, el, attrs, ngModel) {
//            el.bind('change', function (event) {
//                ngModel.$setViewValue(event.target.files[0]);
//                $scope.$apply();
//            });
//            
//            $scope.$watch(function () {
//                return ngModel.$viewValue;
//            }, function (value) {
//                if (!value) {
//                    el.val("");
//                }
//            });
//        }
//    };
//}]);

angular.module('myApp').controller('cartctrl',["$scope", "httpService","$location","$window",function($scope,httpService,$location,$window){
	
        
	//To Fetch Product List		 

            $scope.getProducts = function(){
                          /*var formdata={
                                          "productId":$window.localStorage.getItem("productId")
                                  };*/
                          var details={

                                          getUrl:"rest/getAllProducts",
                                          /*getFormData:formdata*/

                          };

                          httpService.getData(details).then(successart, artfailure);
           };

           var successart=function successCallback(data) {

                         
                             $scope.productList=data;

                            };

                            var artfailure=function errorCallback(reason) {
                                    alert('Not Able to Fetch Product');
                            };


                            $scope.getProducts();
                            /*To show Products*/

           
		$scope.cart = [];
               
                
		$scope.addToCart = function (product) {
			
				$scope.cart.push(product);
			
		};
                 $scope.removeCartItem = function(product){
                    var index = $scope.cart.indexOf(product);
                    $scope.cart.splice(index, 1);
                } ;
                
                  $scope.getCartTotal = function(){
                        var total = 0;
                        for(var i = 0; i < $scope.cart.length; i++){
                            var cartItem = $scope.cart[i];
                            total += (cartItem.price);
                        }
                        return total;
                    };
//
//		$scope.getCartPrice = function () {
//			var total = 0;
//			$scope.cart.forEach(function (product) {
//				total += product.price * product.quantity;
//			});
//			return total;
//		};
//                
                $scope.getCartItemNo = function () {
                        
			var cartCnt = $scope.cart.length ;
                      
			return cartCnt;
		};
                
      /*Go to Home*/
      $scope.goToHome=function(){
              $location.path('/home');

      };

}]);