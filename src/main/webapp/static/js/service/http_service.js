 	'use strict';
angular.module("myApp").factory("httpService",['$http',function($http){
           
//        this.uploadFileToUrl = function(detail){
//                
//                var fd = new FormData();
//                fd.append('productId', details.getFormData.productId);
//                fd.append('productImage', details.getFormData.productImage);
//                fd.append('productName', details.getFormData.productName);
//                fd.append('productPrice', details.getFormData.productPrice);
//                fd.append('productQuantity', details.getFormData.productQuantity);
//                $http.post(detail.getUrl, detail.getFormD, {
//                    
//                    headers: {'Content-Type': undefined},
//                    transformRequest: angular.identity
//                })
//                .success(function(){
//                })
//                .error(function(){
//                });
//            };

                this.uploadFileToUrl = function(productImage, uploadUrl){
                    var fd = new FormData();
                    fd.append('productImage', productImage);
                    $http.post(uploadUrl, fd, {
                        transformRequest: angular.identity,
                        headers: {'Content-Type': undefined}
                    })
                    .success(function(){
                    })
                    .error(function(){
                    });
                };
		 var getDataByForm = function(details) {
                     
                 return $http.post(details.getUrl, details.getFormData)
                    .then(

                        function(response) {
                                return response.data;
                        });
		};
                 var getDataByFrm = function(details) {
			return $http.put(details.getUrl, details.getFormData).then(
		
                            function(response) {
                                    return response.data;
                            });
		};
		var getData = function(details) {
			return $http.post(details.getUrl).then(
					function(response) {
						return response.data;
					});
		};
                var getDataById = function(details) {
			return $http.delete(details.getUrl, details.fdt).then(
					function(response) {
						return response.data;
					});
		};
		var getDataByFile = function(details) {
			return $http.post(details.getUrl,details.getFormData,{
			    headers: { 'Content-Type': undefined},
			    transformRequest:  function(data, headersGetterFunction) {
			        return data;
			    }
			}).then(
					function(response) {
						return response.data;	


					});
		};
		var getDataByFileAlone = function(details) {
			alert(details.getUrl);
			alert(details.getFormData);
			return $http.post(details.getUrl,details.getFormData,{
				
                                headers: {'Content-Type': undefined},
                                transformRequest: angular.identity
			}).then(
					function(response) {
						return response.data;
					});
		};
		function setEmailAddress(data) {
			saveUserData = data;
		}
		function getEmailAddress() {
			return saveUserData;
		}
                function setEmailAddr(data) {
			saveAdminData = data;
		}
		function getEmailAddr() {
			return saveAdminData;
		}
                function setProductId(data) {
			saveProductData = data;
		}
		function getProductId() {
			return saveProductData;
		}
                
		return {
                        getDataById :getDataById,
			getData : getData,
			getDataByForm : getDataByForm,
                        getDataByFrm : getDataByFrm,
			getDataByFile  : getDataByFile,
			getDataByFileAlone : getDataByFileAlone,
			setEmailAddress : setEmailAddress,
			getEmailAddress : getEmailAddress,
                        setEmailAddr : setEmailAddr,
			getEmailAddr : getEmailAddr,
                        setProductId : setProductId,
                        getProductId : getProductId
                        
		};
	}]);

