'use strict';

angular.module('myApp').controller('appctrl',["$scope", "httpService","$location","$window", function($scope,httpService,$location,$window){
	
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
                         $scope.carts = (sessionStorage.getItem('carts')!==null) ? JSON.parse(sessionStorage.getItem('carts')) : [];
                             /*Go  user cart*/
                        
                              /* Load application data */
                                $scope.userCart=function(){
                                  var carts = angular.fromJson( sessionStorage.getItem( 'carts' ) );
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
                                
                                
                                    $location.path('/home');

                            };
                           
                            $scope.toLogin=function(){
                                    
                                    $location.path('/toLogin');

                            };
                            
                               /*checkout*/
                            $scope.checkOut=function(){
                                    $location.path('/checkOut');

                            };
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
                                    
                    $scope.carts[i].productQuantity=parseInt($scope.carts[i].productQuantity)+1;
                    $scope.total += product.productPrice;
                    sessionStorage.setItem( 'total', angular.toJson( $scope.total ) );
                    sessionStorage.setItem( 'carts', angular.toJson( $scope.carts ) );
                    $scope.count +=1;
                     sessionStorage.setItem( 'count', angular.toJson( $scope.count ) ); 
                    return count;
                    $scope.addCard(carts); 
                }
            }
            if(!exist){
                
 
                  $scope.carts.push({productName: product.productName, 
                                   productPrice:product.productPrice,
                                   productQuantity:product.productQuantity});
                           }
                            /* Save application data */
                
                   sessionStorage.setItem( 'carts', angular.toJson( $scope.carts ) );
                   
                      $scope.total += product.productPrice;
                      sessionStorage.setItem( 'total', angular.toJson( $scope.total ) );
                      $scope.count +=1;
                    sessionStorage.setItem( 'count', angular.toJson( $scope.count ) ); 
                    $scope.addCard(carts); 
            };
                  
           // Add cart to database
           
           $scope.addCard = function(carts){
			var productId=carts.productId;
			var productName=carts.productName;
//                      var productImage=product.productImage;
                        var productPrice=carts.productPrice;
                        var productQuantity=carts.productQuantity;
                
                var fData ={  "productId": productId, 
                            "productName": productName, 
                            "productPrice":productPrice,
                            "productQuantity":productQuantity,
                            "emailAddress":$window.sessionStorage.getItem("emailAddress")
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
				
			};	
              
        //To Fetch Product List		 
        $scope.getProducts = function(){
            /*var formdata={
                            "productId":$window.sessionStorage.getItem("productId")
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
//           $scope.$watch('count',function(newValue,oldValue){
//			$scope.count=$scope.carts.length;
//			console.log($scope.count+"**");
//			
//			
//		});
             $scope.count = (sessionStorage.getItem('count')!==null) ? JSON.parse(sessionStorage.getItem('count')) : "0";
           $scope.$watch('count1',function(newValue,oldValue){
			$scope.count1=$scope.wish.length;
			console.log($scope.count1+"**");
			
			
		});
                
       /* removing Item*/
      $scope.removecart = function(cart){
            if(cart){
            $scope.carts.splice($scope.carts.indexOf(cart), 1);
            sessionStorage.setItem('carts', JSON.stringify($scope.carts));
            $scope.total -= (cart.productPrice * cart.productQuantity);
            $scope.count =$scope.count - cart.productQuantity;
            sessionStorage.setItem( 'count', angular.toJson( $scope.count ) );
            sessionStorage.setItem( 'total', angular.toJson( $scope.total ) );
            }
	};
            /*Adding Quantity*/
        $scope.addquantity = function(product){
            var exist=false;
            for(var i=0; i < $scope.carts.length;i++){
                if($scope.carts[i].productName===product.productName)  
                {                   
                    
                    $scope.carts[i].productQuantity=parseInt($scope.carts[i].productQuantity)+1;
                    sessionStorage.setItem('carts', JSON.stringify($scope.carts));
                    $scope.total += product.productPrice;
                    sessionStorage.setItem( 'total', angular.toJson( $scope.total ) ); 
                    $scope.count +=1;
                    sessionStorage.setItem( 'count', angular.toJson( $scope.count ) ); 
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
                    sessionStorage.setItem('carts', JSON.stringify($scope.carts));
                    $scope.total -= product.productPrice;
                    sessionStorage.setItem( 'total', angular.toJson( $scope.total ) ); 
                    $scope.count -=1;
                    sessionStorage.setItem( 'count', angular.toJson( $scope.count ) ); 
                    return count;
                         exist=true;
                     };
                }
            }                      
	};

        $scope.total = (sessionStorage.getItem('total')!==null) ? JSON.parse(sessionStorage.getItem('total')) : "0";
	   
                
            $scope.setTotals = function(){
               
                angular.forEach($scope.carts,function(cart)
                {
                    total += this.this.toNumber(cart.productQuantity * cart.productPrice);
                });
                sessionStorage.setItem( 'total', angular.toJson( $scope.total ) ); 
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
		
			$window.sessionStorage.setItem("emailAddr",data.emailAddr);
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
			$scope.logged=$window.sessionStorage.getItem("emailAddress");
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


