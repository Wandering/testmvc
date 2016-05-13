/**
 * Created by admin on 2016/4/6.
 */
var getUrlParam = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]); return null;
}


var app = angular.module('lyyApp', []);
app.controller('IndexController', ['$scope',function($scope) {
}]);
app.controller('bannersController', ['$scope',function($scope) {
    getCarsFun($scope,1,6);
}]);
var carquery=function($scope){
    $scope.carQueryParam=decodeURI(getUrlParam("queryparam"));
}
app.controller('carsController', ['$scope', function($scope) {
    carquery($scope);
    $scope.querypage = function(page,query){
        getCarsFun($scope,page,6);
    }
    $scope.querypage(1,$scope.carQueryParam);
    $scope.querypageclick=function(event){
        var currentElement = event.target;
        $scope.querypage( currentElement.innerHTML,$scope.carQueryParam);
    }
    $scope.deleteCar=function(event) {
        if (confirm('确实要删除该内容吗?')) {
            console.log(event.target.getAttribute("myid"))
            ajaxFun("/input/deleteCar?id=" + event.target.getAttribute("myid"), "GET", {}, false, function (res) {
                if(res){
                    $scope.querypage(1);
                }
            });
        }
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
    $scope.deleteNew=function(event) {
        if (confirm('确实要删除该内容吗?')) {
            ajaxFun("/input/deleteNew?id=" + event.target.getAttribute("myid"), "GET", {}, false, function (res) {
                if(res){
                    $scope.querypage(1);
                }
            });
        }
    }
}]);
app.controller('buysController', ['$scope', function($scope) {
    $scope.querypage = function(page){
        getBuyFun($scope,page,6);
    };
    $scope.querypage(1);
    $scope.querypageclick=function(event){
        var currentElement = event.target;

        $scope.querypage( currentElement.innerHTML);
    };

}]);
var getBuyFun=function($scope,page,rows,query){
    if(!query){
        query="";
    }
    ajaxFun(getUrlList().buyQueryPage+"?"+"page="+page+"&rows="+rows+"&query="+query, "GET", {},false, function(res){
        $scope.buys=res.list;
        console.log($scope.buys)
        setPageNum($scope,res);
    });
}
var geNewsFun=function($scope,page,rows){
    ajaxFun(getUrlList().news+"?"+"page="+page+"&rows="+rows, "GET", {},false, function(res){
        $scope.news=res.list;
        setPageNum($scope,res);
    });

}
var getCarsFun=function($scope,page,rows,query){
    if(!query){
        query="";
    }
    ajaxFun(getUrlList().carsbanner+"?"+"page="+page+"&rows="+rows+"&query="+$scope.carQueryParam, "GET", {},false, function(res){
        $scope.carsbanner=res.list;
        setPageNum($scope,res);
        $scope.carQueryParam="";
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
            pagenum.class="current btn btn-primary"
        }else{
            pagenum.class="page btn btn-default"
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
            if(res){
                alert("提交成功，我们的工作人员会尽快与您联系！")
                $("#carId").val("");
                $("#name").val("");
                $("#phone").val("");
                $("#comments").val("");
            }else{
                alert("提交失败，服务器未知异常！")
            }
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

