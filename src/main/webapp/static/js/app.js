'use strict';
 
var myApp = angular.module('myApp',['ngRoute']);
myApp.config(function($routeProvider,$httpProvider,$locationProvider){
	$routeProvider.when("/home",{
		templateUrl:"view/home.html",
		controller:"appctrl"
		
		
	}).when("/newUser",{
	
		templateUrl:"view/register.html",
		controller:"appctrl"
                
	}).when("/onsuccess",{
	
		templateUrl:"view/onsuccess.html",
		controller:"appctrl"
                
	}).when("/admin",{
	
		templateUrl:"view/loginAdmin.html",
		controller:"adminctrl"
                
	}).when("/adminPanel",{
	
		templateUrl:"view/adminPanel.html",
		controller:"adminctrl"
                
	}).when("/addToCart",{
	
		templateUrl:"view/addToCart.html",
		controller:"appctrl"
                
	}).when("/cart",{
	
		templateUrl:"view/cart.html",
		controller:"appctrl"
                
	}).when("/toLogin",{
	
		templateUrl:"view/login.html",
		controller:"appctrl"
	}).otherwise({
		redirectTo : "/home"
	});
	
});