'use strict';

angular.module('myApp').controller('appctrl',["$scope", "httpService","$location","$window",function($scope,httpService,$location,$window){
	
	/*To Validate the User*/
	 $scope.validateuser=function(){
		var emailAddress=$scope.emailAddress;
		var password=$scope.password;
	var formdata1={
				emailAddress:emailAddress,
				password:password
				
		};
		var details={
				
				getUrl:"rest/isvalid",
				getFormData:formdata1
				
		};
		
		httpService.getDataByForm(details).then(onSuccessRetrival, onError);
	 };
		
		var onSuccessRetrival = function(data) {
                        alert("successfuly logged in")
			$window.localStorage.setItem("emailAddress",data.emailAddress);	
                        //$scope.logged=data.username;
			//console.log($scope.logged);
			$location.path('/onsuccess');
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
		/*To add the User*/
		
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
                             /*Go  user cart*/
                        $scope.goToHome=function(){
                                $location.path('/userCart');

                        };

                            /*Go to Home*/
                            $scope.goToHome=function(){
                                    $location.path('/home');

                            };
                            
        $scope.carts = []; 
        $scope.wish = []; 
       
        $scope.addToCart = function(product){
           
//            var exist=false;
//            for(var i=0; i < $scope.carts.length;i++){
//                if($scope.carts[i].productName===product.productName)
//                {
//                   exist=true; 
//                    
//                }
//            }
//            if(!exist){
//                
//                $scope.addCard = function(product){
                        var productId=product.productId;
			var productName=product.productName;
//			var productImage=product.productImage;
                        var productPrice=product.productPrice;
                        var productQuantity=product.productQuantity;
                
                var fData ={  "productId": productId, 
                            "productName": productName, 
                            "productPrice":productPrice,
                            "productQuantity":productQuantity,
                            "emailAddress":$window.localStorage.getItem("emailAddress")
                    };
                    
                var detail={
					
					getUrl:"rest/addToCart",
					getFormData:fData
					
			};
                   alert(productName + " " + productPrice + " " + productQuantity + " " + productId + " " + emailAddress);
                 httpService.getDataByForm(detail).then(onSuccess, onError);
		 };
		 var onError = function(reason) {
				alert("Error adding Item");
				
			};
			
			var onSuccess = function(data) {
			alert("Cart Updated");
			$location.path('/userCart');
			
		};	

//                  $scope.carts.push({productName: product.productName, 
//                                   productPrice:product.productPrice,
//                                   productQuantity:product.productQuantity});
//                           }
//                      
              
//            };
              
        //To Fetch Product List		 
        $scope.getProducts = function(){
            /*var formdata={
                            "productId":$window.localStorage.getItem("productId")
                    };*/
            var details={

                            getUrl:"rest/getAllProducts"
                            /*getFormData:formdata*/

            };

                httpService.getData(details).then(successProd, prodFailure);
           };

           var successProd=function successCallback(data) {


            $scope.productList=data;

           };

           var prodFailure=function errorCallback(reason) {
                   alert('Not Able to Fetch Product');
           };


           $scope.getProducts();
           /*Add product to cart*/
           $scope.$watch('count',function(newValue,oldValue){
			$scope.count=$scope.carts.length;
			console.log($scope.count+"**");
			
			
		});
           $scope.$watch('count1',function(newValue,oldValue){
			$scope.count1=$scope.wish.length;
			console.log($scope.count1+"**");
			
			
		});
                
       /* removing Item*/
      $scope.removecart = function(cart){
            if(cart){
            $scope.carts.splice($scope.carts.indexOf(cart), 1);
            $scope.total -= cart.productPrice;
             $scope.count =$scope.count - 1;
            }
	};
            /*Adding Quantity*/
        $scope.addquantity = function(product){
            var exist=false;
            for(var i=0; i < $scope.carts.length;i++){
                if($scope.carts[i].productName===product.productName)                {                   
                    $scope.carts[i].productQuantity=parseInt($scope.carts[i].productQuantity)+1;
                   
                         exist=true;
                }
            }                      
	};
        
        /*Removing Quantity*/
        $scope.removequantity = function(product){
            var exist=false;
            for(var i=0; i < $scope.carts.length;i++){
                if($scope.carts[i].productName===product.productName)
                {      if($scope.carts[i].productQuantity>0){             
                    $scope.carts[i].productQuantity=parseInt($scope.carts[i].productQuantity)-1;
                         exist=true;
                     };
                }
            }                      
	};

        $scope.total = 0;
	   
                
            $scope.setTotals = function(){
               
                angular.forEach($scope.carts,function(cart)
                {
                    total+=cart.productQuantity * cart.productPrice;
                });
                return total;
		/*if(cart){
                    $scope.total += cart.productPrice;
                   
		}*/
	} ;    
	
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
                        var productQuantity=$scope.productQuantity;
			
		var formdata={
				"productId":productId,
                                "productName":productName,
				"productImage":productImage,
                                "productPrice":productPrice,
                                "productQuantity":productQuantity
				
						
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

