var myApp = angular.module("myApp", []);

myApp.directive('myPwdMatch', [function () {
    return {
        restrict: "A",
        require: 'ngModel',
        link: function (scope, element, attrs, ctrl) {
            var tageCtrl = scope.$eval(attrs.myPwdMatch);
            tageCtrl.$parsers.push(function (viewValue) {
                ctrl.$setValidity('pwdmatch', viewValue == ctrl.$viewValue);
                return viewValue;
            });
            ctrl.$parsers.push(function (viewValue) {
                if (viewValue == tageCtrl.$viewValue) {
                    ctrl.$setValidity('pwdmatch', true);
                    return viewValue;
                } else {
                    ctrl.$setValidity('pwdmatch', false);
                    return undefined;
                }
            });
        }
    };
}]);



myApp.controller("myCtrl", ["$scope", "$http", function ($scope, $http) {
    console.log($scope)

    $scope.safeTypes = [{
        value: 0,
        text: "不保存账户状态"
    }, {
        value: 30,
        text: "保存半个小时"
    }, {
        value: 60,
        text: "保存一个小时"
    }, {
        value: 180,
        text: "保存三个小时"
    }, {
        value: 60 * 24,
        text: "保存一天"
    }, {
        value: 60 * 24 * 7,
        text: "保存一周"
    }, {
        value: 60 * 24 * 30,
        text: "保存一个月"
    }];


    $scope.doSubmit = function () {
        if ($scope.myForm.$valid) {
            alert("提交表单数据");
        }
        $scope.myForm.submitted = true;
    }
}]);
