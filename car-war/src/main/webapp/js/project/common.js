/**
 * Created by admin on 2016/4/6.
 */
var getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
}


var app = angular.module('lyyApp', []);
app.controller('IndexController', ['$scope',function($scope) {
}]);
app.controller('bannersController', ['$scope',function($scope) {
    getCarsFun($scope,1,6);
}]);

app.controller('carsController', ['$scope', function($scope) {

    $scope.querypage = function(page,query){
        getCarsFun($scope,page,6,query);
    }
    $scope.querypage(1);
    $scope.querypageclick=function(event){
        var currentElement = event.target;

        $scope.querypage( currentElement.innerHTML);
    }
}]);
app.controller('newsController', ['$scope', function($scope) {
    $scope.querypage = function(page){
        geNewsFun($scope,page,6);
    }
    $scope.querypage(1);
    $scope.querypageclick=function(event){
        var currentElement = event.target;

        $scope.querypage( currentElement.innerHTML);
    }
}]);
var geNewsFun=function($scope,page,rows){
    ajaxFun(getUrlList().news+"?"+"page="+page+"&rows="+rows, "GET", {},false, function(res){
        $scope.news=res.list;
        console.log($scope.news)
        console.log("tt")
        setPageNum($scope,res);
    });

}
var getCarsFun=function($scope,page,rows,query){
    if(!query){
        query="";
    }
    ajaxFun(getUrlList().carsbanner+"?"+"page="+page+"&rows="+rows+query, "GET", {},false, function(res){
        $scope.carsbanner=res.list;
        setPageNum($scope,res);
    });
}
var setPageNum = function($scope,res){
    var nums=[];
    var pageInfo={
        currPage:res.currPage,
        pages:res.pages,
        count:res.count
    };
    $scope.pageInfo=pageInfo;
    for(var i=1;i<=res.pages;i++){
        var pagenum={
            num:i
        };
        if(res.currPage===i){
            pagenum.class="current"
        }else{
            pagenum.class="page"
        }

        pagenum.num=i;
        nums.push(pagenum);
    }
    $scope.pagenum=nums;
    console.log( $scope.pagenum);
}
app.controller('carInfoController', ['$scope', function($scope) {
    var id = getUrlParam("id");
    if(!id){
        id=0;
    }
    ajaxFun(getUrlList().carinfo+"?id="+id, "GET", {},false, function(res){
        $scope.carinfo=res;
        console.log(res)
    });
}]).filter(
    'to_trusted', ['$sce', function ($sce) {
        return function (text) {
            return $sce.trustAsHtml(text);
        }
    }]
)  ;
app.controller('newInfoController', ['$scope', function($scope) {
    var id = getUrlParam("id");
    if(!id){
        id=0;
    }
    ajaxFun(getUrlList().newinfo+"?id="+id, "GET", {},false, function(res){
        $scope.newinfo=res;
        console.log(res)
    });
}]).filter(
    'to_trusted', ['$sce', function ($sce) {
        return function (text) {
            return $sce.trustAsHtml(text);
        }
    }]
)  ;

var addBuy=function(){
    $("#carId").val();
    $("#name").val();
    $("#phone").val();
    $("#comments").val();
    var data={
        carId:$("#carId").val(),
        name:$("#name").val(),
        phone:$("#phone").val(),
        comments:$("#comments").val(),
    }
        ajaxFun("/input/addBuy", "POST", data,true, function(res){

        });
}






var getUrlList=function(){
    return JSON.parse(localStorage.getItem("urlConfig"));
}
var initUrlCofig=function(){
    $.ajax({
        type: "GET",
        url: "config/config.json",
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

