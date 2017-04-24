/**
 * Created by root on 17-4-23.
 */
var subListStudent = {
    //提交表单
    submitForm : function (actionUrl) {
        var formElement = document.getElementById('stuForm');
        formElement.action = actionUrl;
        formElement.submit();
    },
    //首页
    firstPage : function (context) {
        subListStudent.submitForm(context+'/student/onePage?pageNumber=1');
    },
    //尾页
    endPage : function (totalPageNumber,context) {
      subListStudent.submitForm(context+'/student/onePage?pageNumber='+totalPageNumber);
    },
    //上一页
    prePage : function (currentPage,context) {
        var prePage = currentPage-1;
        subListStudent.submitForm(context+'/student/onePage?pageNumber='+prePage);
    },
    nextPage : function (currentPage,context) {
        var  nextPage  = currentPage+1;
    subListStudent.submitForm(context+'/student/onePage?pageNumber='+nextPage) ;
    }
    ,
    //下一页
    //初始化页面
    initPage : function (sex) {
        var sexElement = document.getElementById('sex');
        if(sex!=""){
            sex = parseInt(sex);
        }
        var options = sexElement.options;
        var i =0;
        for(i=0;i<options.length;i++){
            if (options[i].value==sex){
                options[i].selected=true;
                break;
            }
        }
    }
};
