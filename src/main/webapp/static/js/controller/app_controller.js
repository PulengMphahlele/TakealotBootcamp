'use strict';

angular.module('myApp').controller('appctrl',["$scope", "httpService","$location","$window", function($scope,httpService,$location,$window){
	
	/*To Validate the User when logging in*/
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
                        alert("successfuly logged in");
			$window.sessionStorage.setItem("emailAddress",data.emailAddress);
                        //$scope.logged=data.username;
			//console.log($scope.logged);
			$location.path('/goToHome');
                       };
                       $scope.toLogin=function(){
                       $location.path('/toLogin');

                                    };
		var onError = function(reason) {
			alert("Invalid Login");
			
		};

                    /*To display Logged in User*/
                    $scope.$watch('logged',function(newValue,oldValue){
                    $scope.logged=$window.sessionStorage.getItem("emailAddress");
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
                    $scope.carts = (localStorage.getItem('carts')!==null) ? JSON.parse(localStorage.getItem('carts')) : [];

                      /* Load user Cart data */
                        $scope.userCart=function(){
                          var carts = angular.fromJson( localStorage.getItem( 'carts' ) );
                          if ( carts ) {
                            $scope.carts = [];
                            for (var i = 0; i < carts.length; i++) {
                              if (carts[i]) {
                                $scope.carts.push(carts[i]);
                              }
                            }
                          }
                          $location.path('/userCart');
                        };

                    /*Go to Home*/
                    $scope.goToHome=function(){
                        $location.path('/home');

                    };
                    $scope.logOut=function(){
         
                        $window.localStorage.clear();
                        $scope.total=0;
                        $scope.count=0;
                        localStorage.setItem( 'count', angular.toJson( $scope.count ) ); 
                        localStorage.setItem( 'total', angular.toJson( $scope.total ) ); 
                        $location.path('/home');

                    };

                    $scope.toLogin=function(){

                            $location.path('/toLogin');

                    };

                       /*checkout*/
                    $scope.checkOut=function(){
                            $location.path('/checkOut');

                    };

                       /*printing Order Details*/
                    $scope.receipt=function(){
                            $location.path('/receipt');

                    };   
                   $scope.randdom = (Math.floor((Math.random() * 10000) + 1)); 
                    /*updating cart*/

                    $scope.updateCart=function(){
                            $location.path('/addToCart');

                    };
                            
//        $scope.carts = []; 
        $scope.wish = []; 
       
        $scope.addToCart = function(product){
           
            var exist=false;
            for(var i=0; i < $scope.carts.length;i++){
                if($scope.carts[i].productName===product.productName)
                {
                   exist=true; 
                     $scope.updateC(product);               
                    $scope.carts[i].productQuantity=parseInt($scope.carts[i].productQuantity)+1;
                    $scope.total += product.productPrice;
                    localStorage.setItem( 'total', angular.toJson( $scope.total ) );
                    localStorage.setItem( 'carts', angular.toJson( $scope.carts ) );
                    $scope.count +=1;
                    localStorage.setItem( 'count', angular.toJson( $scope.count ) ); 
                    return count;
                                  
                }
            }
            if(!exist){
                
            $scope.addCart(product);
            $scope.carts.push(
                    { productName: product.productName, 
                      productPrice:product.productPrice,
                      productQuantity:product.productQuantity});
                     }
                      /* Save application data */

                      localStorage.setItem( 'carts', angular.toJson( $scope.carts ) );
                      $scope.total += product.productPrice;
                      localStorage.setItem( 'total', angular.toJson( $scope.total ) );
                      $scope.count +=1;
                      localStorage.setItem( 'count', angular.toJson( $scope.count ) ); 
               
            };
                  
           // Add cart to database
           
           $scope.addCart = function(product){
          
                       
                            var productId=product.productId;
                            var productName=product.productName;
//                          var productImage=product.productImage;
                            var productPrice=product.productPrice;
                            var productQuantity=product.productQuantity;
                        var fData ={  
                                "productId": productId, 
                                "productName": productName, 
                                "productPrice":productPrice,
                                "productQuantity":productQuantity,
                                "emailAddress":$window.sessionStorage.getItem("emailAddress")
                        };
                       
                        var detail={
                                getUrl:"rest/addToCart",
                                getFormData:fData
                        };
                   
                        httpService.getDataByForm(detail).then(onSuccess, onError);
                        
                         
                       };
                         // Add cart to database
           
           $scope.updateC = function(){
            
                            var productId=$scope.carts.productId;
                            var productName=$scope.carts.productName;
//                          var productImage=$scope.fCart.productImage;
                            var productPrice=$scope.carts.productPrice;
                            var productQuantity=$scope.carts.productQuantity;
                        var fData ={  
                                "productId": productId, 
                                "productName": productName, 
                                "productPrice":productPrice,
                                "productQuantity":productQuantity,
                                "emailAddress":$window.sessionStorage.getItem("emailAddress")
                        };
                       
                        var detail={
                                getUrl:"rest/updateCart",
                                getFormData:fData
                        };
                   
                        httpService.getDataByFrm(detail).then(onSuccess, onError);
                        
                         
                            };
			var onError = function(reason) {
                                alert("Error updating Item");
					
                        };
                        var onSuccess = function(data) {
                                 alert("Cart Updated");
                            		
                        };
            //To Fetch Product List		 
            $scope.getProducts = function(){
           
                        var details={
                                getUrl:"rest/getAllProducts"
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
                        $scope.count = (localStorage.getItem('count')!==null) ? JSON.parse(localStorage.getItem('count')) : "0";
                        $scope.$watch('count1',function(newValue,oldValue){
                        $scope.count1=$scope.wish.length;
                        console.log($scope.count1+"**");
			
		});
                
                /* removing Item*/
            $scope.removecart = function(cart){
                if(cart){
                $scope.carts.splice($scope.carts.indexOf(cart), 1);
                localStorage.setItem('carts', JSON.stringify($scope.carts));
                $scope.total -= (cart.productPrice * cart.productQuantity);
                $scope.count =$scope.count - cart.productQuantity;
                localStorage.setItem( 'count', angular.toJson( $scope.count ) );
                localStorage.setItem( 'total', angular.toJson( $scope.total ) );
                }
            };
            /*Adding Quantity*/
            $scope.addquantity = function(product){
                var exist=false;
                for(var i=0; i < $scope.carts.length;i++){
                    if($scope.carts[i].productName===product.productName)  
                        {                   

                            $scope.carts[i].productQuantity=parseInt($scope.carts[i].productQuantity)+1;
                            localStorage.setItem('carts', JSON.stringify($scope.carts));
                            $scope.total += product.productPrice;
                            localStorage.setItem( 'total', angular.toJson( $scope.total ) ); 
                            $scope.count +=1;
                            localStorage.setItem( 'count', angular.toJson( $scope.count ) ); 
                            return count;
                                 exist=true;
                        }
                }                      
            };

    /*Removing Quantity*/
    $scope.removequantity = function(product){
        var exist=false;
        for(var i=0; i < $scope.carts.length;i++){
            if($scope.carts[i].productName===product.productName)
                {      
                    if($scope.carts[i].productQuantity>0){ 

                        $scope.carts[i].productQuantity=parseInt($scope.carts[i].productQuantity)-1;
                        localStorage.setItem('carts', JSON.stringify($scope.carts));
                        $scope.total -= product.productPrice;
                        localStorage.setItem( 'total', angular.toJson( $scope.total ) ); 
                        $scope.count -=1;
                        localStorage.setItem( 'count', angular.toJson( $scope.count ) ); 
                        return count;
                        exist=true;
                    };
                }
            }                      
	};

        $scope.total = (localStorage.getItem('total')!==null) ? JSON.parse(localStorage.getItem('total')) : "0";
	$scope.setTotals = function(){
               
                angular.forEach($scope.carts,function(cart)
                {
                    total += this.this.toNumber(cart.productQuantity * cart.productPrice);
                });
                localStorage.setItem( 'total', angular.toJson( $scope.total ) ); 
                return total;
		
	} ;   
        /* saving Order details */
        	$scope.saveOrder= function(){
         
                        var orderId=$scope.orderId;
                        var cardNumber=$scope.cardNumber;
			var accountNo=$scope.accountNo;
			var sAdddress=$scope.sAdddress;
                        var city=$scope.city;
                        var phone=$scope.phone;
                        var pCode=$scope.pCode;
			
		var formdat={  
                                "orderId":orderId,
				"cardNumber":cardNumber,
                                "accountNo":accountNo,
				"sAdddress":sAdddress,
                                "phone":phone,
                                "city":city,
                                "pCode":pCode
				
						
			};
                       
			var details={
					
					getUrl:"rest/saveorderD",
					getFormData:formdat
					
			};
			
			httpService.getDataByForm(details).then(onSuccessOrder, onErrOrder);
		 };
		 var onErrOrder = function(reason) {
				alert("Order unseccessful");
				
			};
			
			var onSuccessOrder = function(data) {
			alert("successfully ordered");
			$location.path('/receipt');
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
			var productImage =$scope.productImage;
                        var productPrice=$scope.productPrice;
                        var productQuantity=$scope.productQuantity;
			
		  
                var fd = new FormData();
                fd.append('productId', productId);
                fd.append('productImage',productImage);
                fd.append('productName', productName);
                fd.append('productPrice', productPrice);
                fd.append('productQuantity', productQuantity);
               
                       
			var details={
					
					getUrl:"rest/uploadFile",
					getFormData:fd
					
			};
			alert(productImage +''+ productName +''+ productPrice);
			httpService.uploadFileToUrl(details).then(onSuccessR, onErrorProduct);
		 };
		 var onErrorProduct = function(reason) {
				alert("Product is not added");
				
			};
			
			var onSuccessR = function(data) {
			alert("Product successfully Added");
			$location.path('/adminPanel');
			};
			
	
     }
]);

angular.module('myApp').directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);
//.directive("fileinput", [function() {
//    return {
//      scope: {
//        fileinput: "=",
//        filepreview: "="
//      },
//      link: function(scope, element, attributes) {
//        element.bind("change", function(changeEvent) {
//          scope.fileinput = changeEvent.target.files[0];
//          var reader = new FileReader();
//          reader.onload = function(loadEvent) {
//            scope.$apply(function() {
//              scope.filepreview = loadEvent.target.result;
//            });
//          };
//          reader.readAsDataURL(scope.fileinput);
//        });
//      }
//    };
//  }]);
        
