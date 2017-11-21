 	'use strict';
angular.module("myApp").factory("httpService",['$http',function($http){
        
             this.uploadFileToUrl = function(formdata, uploadUrl){
                var fd = new FormData();
                fd.append('formdata', formdata);
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
			return $http.post(details.getUrl, details.getFormData).then(
		
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
		}
		var getDataByFileAlone = function(details) {
			alert(details.getUrl);
			alert(details.getFormData);
			return $http.post(details.getUrl,details.getFormData,{
				transformRequest: angular.identity,
	            headers: {'Content-Type': undefined}
			}).then(
					function(response) {
						return response.data;
					});
		}
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

