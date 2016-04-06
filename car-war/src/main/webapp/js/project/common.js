/**
 * Created by admin on 2016/4/6.
 */
var app = angular.module('lyyApp', []);
app.controller('IndexController', ['$scope', function($scope) {
}]);
app.controller('bannersController', ['$scope', function($scope) {
    ajaxFun(getUrlList().banner, "GET", {},false, function(res){
        $scope.banners=res;
        console.log(res)
    });

}]);
app.controller('servicesController', ['$scope', function($scope) {
    ajaxFun(getUrlList().services, "GET", {},false, function(res){
        $scope.services=res;
        console.log(res)
    });

}]);

var getUrlList=function(){
    return JSON.parse(localStorage.getItem("urlConfig"));
}

var initUrlCofig=function(){
    $.ajax({
        type: "GET",
        url: "/config/config.json",
        data: {},
        dataType: "json",
        success: function(data){
                    console.log(data)
                    localStorage.setItem("urlConfig", JSON.stringify(data));
        }
    });
}
initUrlCofig();
//ajax拉取数据
var ajaxFun=function(url, method, data,async, callback, callbackError) {

    $.ajax({
        url: url,
        type: method,
        async: async,
        data: data || {},
        success: function (res) {
            callback(res);
        },
        error: function (res) {
            if (callbackError && typeof(callbackError) === "function") {
                callbackError(res);
            }
        }
    });
};

var changeBaseUrlFun = function (baseUrl) {
    localStorage.removeItem("urlConfig");
    var urlConfig = JSON.parse(localStorage.getItem("baseUrlConfig"));
    for (var s in urlConfig) {
        urlConfig[s] = baseUrl + urlConfig[s];
    }
    localStorage.setItem("urlConfig", JSON.stringify(urlConfig));
};
var changeConfigFun = function (str) {
    switch (str) {
        case "debug":
            changeBaseUrlFun("http://10.10.72.32:8888/qky/qky");
            break;
        case "local":
            changeBaseUrlFun("http://113.140.31.190:18094");
            break;
        case "jsy":
            changeBaseUrlFun("http://qky-dev.thinkjoy.com.cn");
            break;
        case "localhost":
            changeBaseUrlFun("http://localhost:8087");
            break;
        default :
            alert("输入参数不对.");
            break;
    }
};

