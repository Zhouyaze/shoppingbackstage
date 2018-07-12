<%@ page language="java" contentType="text/html; ISO-8859-1" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>会员列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
    <script src="js/page.js"></script>
    <script type="text/javascript">
        var pagecount = 1;
        var optionJson= [];

        function refurbishIndex(currentPage, pageSize) {
            $.ajax({
                type: "GET",
                contentType: "application/json; charset=utf-8",
                url: '${pageContext.request.contextPath}/getUser?currentPage=' + currentPage + "&pageSize=" + pageSize,
                data: {},
                async: false,
                success: function (data) {
                    var userType = $("#select").val();
                    optionJson = data;
                    var str = "";
                    if (userType == "选择会员等级") {
                        for (var index = 0; index < optionJson.items.length; index++) {
                            str += "<tr>" +
                                "<td>" + optionJson.items[index].id + "</td>" +
                                // " + optionJson.items[index].headPortraitUrl + "
                                "<td><img src=" + optionJson.items[index].headPortraitUrl + " alt=" + optionJson.items[index].headPortraitUrl + "></td>" +
                                "<td>" + optionJson.items[index].nickName + "</td>"
                            if (optionJson.items[index].authenticationEntity.userPhoneNumber != "") {
                                str += "<td>" + optionJson.items[index].authenticationEntity.userPhoneNumber + "</td>"
                            } else {
                                str += "<td>此用户还未实名认证</td>"
                            }
                            str += "<td>" + optionJson.items[index].userTypeName + "</td>" +
                                "<td class=\"center\">"
                            str += "<a href=\"edit_user.jsp?id=" + optionJson.items[index].id + "&nickName=" + optionJson.items[index].nickName + "&userPhoneNumber=" + optionJson.items[index].authenticationEntity.userPhoneNumber + "&authenticationId=" + optionJson.items[index].authenticationEntity.id + "&userTypeName=" + optionJson.items[index].userTypeName + "\" class=\"inline-block\" title=\"编辑\"><img onclick='set()' src=\"images/icon_edit.gif\"/>" + "</a>"
                            // "<a href=\"account.jsp\" class=\"inline-block\" title=\"资金管理\">"+"<img src=\"images/icon_account.gif\"/>"+"</a>"+
                            str += "<a href=\"deleteUser.jsp?id=" + optionJson.items[index].id + "\" class=\"inline-block\" title=\"删除\">" + "<img src=\"images/icon_drop.gif\"/>" + "</a>" +
                                "</td>" +
                                "</tr>";
                            document.getElementById("tbodydata").innerHTML = str;
                        }
                        document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
                    } else {
                        document.getElementById("tbodydata").innerHTML = "";
                        $.ajax({
                            type: "GET",
                            contentType: "application/json; charset=utf-8",
                            url: '${pageContext.request.contextPath}/getUser?userTypeName=' + userType + "&currentPage=" + currentPage + "&pageSize=" + pageSize,
                            data: {},
                            async: false,
                            success: function (data) {
                                optionJson = data;
                                console.log(data)
                                var str = "";
                                for (var index = 0; index < optionJson.items.length; index++) {
                                    str += "<tr>" +
                                        "<td>" + optionJson.items[index].id + "</td>" +
                                        "<td><img src=" + optionJson.items[index].headPortraitUrl + " alt=" + optionJson.items[index].headPortraitUrl + "></td>" +
                                        "<td>" + optionJson.items[index].nickName + "</td>"
                                    if (optionJson.items[index].authenticationEntity.userPhoneNumber != "此用户还未实名认证") {
                                        str += "<td>" + optionJson.items[index].authenticationEntity.userPhoneNumber + "</td>"
                                    } else {
                                        str += "<td>此用户还未实名认证</td>"
                                    }
                                    str += "<td>" + optionJson.items[index].userTypeName + "</td>" +
                                        "<td class=\"center\">"
                                    if (optionJson.items[index].authenticationEntity.userPhoneNumber != "此用户还未实名认证") {
                                        str += "<a href=\"edit_user.jsp?id=" + optionJson.items[index].id + "&nickName=" + optionJson.items[index].nickName + "&userPhoneNumber=" + optionJson.items[index].authenticationEntity.userPhoneNumber + "&authenticationId=" + optionJson.items[index].authenticationEntity.id + "&userTypeName=" + optionJson.items[index].userTypeName + "\" class=\"inline-block\" title=\"编辑\"><img onclick='set()' src=\"images/icon_edit.gif\"/>" + "</a>"
                                    } else {
                                        str += "<a href=\"edit_user.jsp?id=" + optionJson.items[index].id + "&nickName=" + optionJson.items[index].nickName + "&userPhoneNumber=" + optionJson.items[index].authenticationEntity.userPhoneNumber + "&authenticationId=0\" class=\"inline-block\" title=\"编辑\"><img onclick='set()' src=\"images/icon_edit.gif\"/>" + "</a>"
                                    }
                                    // "<a href=\"account.jsp\" class=\"inline-block\" title=\"资金管理\">"+"<img src=\"images/icon_account.gif\"/>"+"</a>"+
                                    str += "<a href=\"deleteUser.jsp?id=" + optionJson.items[index].id + "\" class=\"inline-block\" title=\"删除\">" + "<img src=\"images/icon_drop.gif\"/>" + "</a>" +
                                        "</td>" +
                                        "</tr>";
                                    document.getElementById("tbodydata").innerHTML = str;
                                }
                                if (optionJson.items.length < 15) {
                                    optionJson.totalPage = 1;
                                }
                                document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
                            }
                        });
                    }
                }

            });
        }

        function huiyuanleixing() {
            $.ajax({
                type: "GET",
                contentType: "application/json; charset=utf-8",
                url: '${pageContext.request.contextPath}/getUserType',
                data: {},
                async: false,
                success: function (data) {
                    var option = null;
                    var temp = document.getElementById("select");
                    console.log(data)
                    for (var i = 0; i < data.length; i++) {
                        option = document.createElement("option");
                        option.appendChild(document.createTextNode(option.vaule = data[i].userTypeName));
                        option.vaule = data[i].userTypeName
                        temp.appendChild(option);
                    }
                }
            });
        }

        /*
        根据条件分页查询
        */
        function tiaojianSelect(currentPage, pageSize) {
            var userType = $("#select").val();
            if ($("#tiaojian").val() == "") {
                refurbishIndex(currentPage, 15)
            } else {
                //根据id查询
                var optionJson = [];

                //根据用户昵称查询
                document.getElementById("tbodydata").innerHTML = "";
                $.ajax({
                    async: false,
                    url: '${pageContext.request.contextPath}/getUser?nickName=' + $("#tiaojian").val() + "&currentPage=" + currentPage + "&pageSize=" + pageSize,
                    type: 'GET',
                    dataType: 'json',
                    data: {},
                    success: function (data2) {
                        if (data2.items.length != 0) {
                            optionJson = data2;
                            var str = "";
                            if (userType == "选择会员等级") {
                                for (var index = 0; index < optionJson.items.length; index++) {
                                    str += "<tr>" +
                                        "<td>" + optionJson.items[index].id + "</td>" +
                                        "<td><img src=" + optionJson.items[index].headPortraitUrl + " alt=" + optionJson.items[index].headPortraitUrl + "></td>" +
                                        "<td>" + optionJson.items[index].nickName + "</td>"
                                    if (optionJson.items[index].authenticationEntity.userPhoneNumber != "此用户还未实名认证") {
                                        str += "<td>" + optionJson.items[index].authenticationEntity.userPhoneNumber + "</td>"
                                    } else {
                                        str += "<td>此用户还未实名认证</td>"
                                    }

                                    str += "<td>" + optionJson.items[index].userTypeName + "</td>" +
                                        "<td class=\"center\">"
                                    if (optionJson.items[index].authenticationEntity.userPhoneNumber != "此用户还未实名认证") {
                                        str += "<a href=\"edit_user.jsp?id=" + optionJson.items[index].id + "&nickName=" + optionJson.items[index].nickName + "&userPhoneNumber=" + optionJson.items[index].authenticationEntity.userPhoneNumber + "&authenticationId=" + optionJson.items[index].authenticationEntity.id + "&userTypeName=" + optionJson.items[index].userTypeName + "\" class=\"inline-block\" title=\"编辑\"><img onclick='set()' src=\"images/icon_edit.gif\"/>" + "</a>"
                                    } else {
                                        str += "<a href=\"edit_user.jsp?id=" + optionJson.items[index].id + "&nickName=" + optionJson.items[index].nickName + "&userPhoneNumber=" + optionJson.items[index].authenticationEntity.userPhoneNumber + "&authenticationId=0\" class=\"inline-block\" title=\"编辑\"><img onclick='set()' src=\"images/icon_edit.gif\"/>" + "</a>"
                                    }
                                    // "<a href=\"account.jsp\" class=\"inline-block\" title=\"资金管理\">"+"<img src=\"images/icon_account.gif\"/>"+"</a>"+
                                    str += "<a href=\"deleteUser.jsp?id=" + optionJson.items[index].id + "\" class=\"inline-block\" title=\"删除\">" + "<img src=\"images/icon_drop.gif\"/>" + "</a>" +
                                        "</td>" +
                                        "</tr>";

                                }
                                document.getElementById("tbodydata").innerHTML = str;
                                document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
                            } else {
                                document.getElementById("tbodydata").innerHTML = "";
                                $.ajax({
                                    type: "GET",
                                    contentType: "application/json; charset=utf-8",
                                    url: '${pageContext.request.contextPath}/getUser?userTypeName=' + userType + "&nickName=" + $("#tiaojian").val() + "&currentPage=" + currentPage + "&pageSize=" + pageSize,
                                    data: {},
                                    async: false,
                                    success: function (data) {
                                        optionJson = data;
                                        console.log(data)
                                        var str = "";
                                        for (var index = 0; index < optionJson.items.length; index++) {
                                            str += "<tr>" +
                                                "<td>" + optionJson.items[index].id + "</td>" +
                                                "<td><img src=" + optionJson.items[index].headPortraitUrl + " alt=" + optionJson.items[index].headPortraitUrl + "></td>" +
                                                "<td>" + optionJson.items[index].nickName + "</td>"
                                            if (optionJson.items[index].authenticationEntity.userPhoneNumber != "此用户还未实名认证") {
                                                str += "<td>" + optionJson.items[index].authenticationEntity.userPhoneNumber + "</td>"
                                            } else {
                                                str += "<td>此用户还未实名认证</td>"
                                            }
                                            str += "<td>" + optionJson.items[index].userTypeName + "</td>" +
                                                "<td class=\"center\">"
                                            if (optionJson.items[index].authenticationEntity.userPhoneNumber != "此用户还未实名认证") {
                                                str += "<a href=\"edit_user.jsp?id=" + optionJson.items[index].id + "&nickName=" + optionJson.items[index].nickName + "&userPhoneNumber=" + optionJson.items[index].authenticationEntity.userPhoneNumber + "&authenticationId=" + optionJson.items[index].authenticationEntity.id + "&userTypeName=" + optionJson.items[index].userTypeName + "\" class=\"inline-block\" title=\"编辑\"><img onclick='set()' src=\"images/icon_edit.gif\"/>" + "</a>"
                                            } else {
                                                str += "<a href=\"edit_user.jsp?id=" + optionJson.items[index].id + "&nickName=" + optionJson.items[index].nickName + "&userPhoneNumber=" + optionJson.items[index].authenticationEntity.userPhoneNumber + "&authenticationId=0\" class=\"inline-block\" title=\"编辑\"><img onclick='set()' src=\"images/icon_edit.gif\"/>" + "</a>"
                                            }
                                            // "<a href=\"account.jsp\" class=\"inline-block\" title=\"资金管理\">"+"<img src=\"images/icon_account.gif\"/>"+"</a>"+
                                            str += "<a href=\"deleteUser.jsp?id=" + optionJson.items[index].id + "\" class=\"inline-block\" title=\"删除\">" + "<img src=\"images/icon_drop.gif\"/>" + "</a>" +
                                                "</td>" +
                                                "</tr>";
                                            document.getElementById("tbodydata").innerHTML = str;
                                        }
                                        if (optionJson.items.length < 15) {
                                            optionJson.totalPage = 1;
                                        }
                                        document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
                                    }
                                });
                            }
                        } else {
                            //根据用户登陆名称查询
                            document.getElementById("tbodydata").innerHTML = "";
                            $.ajax({
                                async: false,
                                url: '${pageContext.request.contextPath}/getUser?loginName=' + $("#tiaojian").val() + "&currentPage=" + currentPage + "&pageSize=" + pageSize,
                                type: 'GET',
                                dataType: 'json',
                                data: {},
                                success: function (data3) {
                                    if (data3.items.length != 0) {
                                        optionJson = data3;
                                        var str = "";
                                        if (userType == "选择会员等级") {

                                            for (var index = 0; index < optionJson.items.length; index++) {
                                                str += "<tr>" +
                                                    "<td>" + optionJson.items[index].id + "</td>" +
                                                    "<td><img src=" + optionJson.items[index].headPortraitUrl + " alt=" + optionJson.items[index].headPortraitUrl + "></td>" +
                                                    "<td>" + optionJson.items[index].nickName + "</td>"
                                                if (optionJson.items[index].authenticationEntity.userPhoneNumber != "此用户还未实名认证") {
                                                    str += "<td>" + optionJson.items[index].authenticationEntity.userPhoneNumber + "</td>"
                                                } else {
                                                    str += "<td>此用户还未实名认证</td>"
                                                }

                                                str += "<td>" + optionJson.items[index].userTypeName + "</td>" +
                                                    "<td class=\"center\">"
                                                if (optionJson.items[index].authenticationEntity.userPhoneNumber != "此用户还未实名认证") {
                                                    str += "<a href=\"edit_user.jsp?id=" + optionJson.items[index].id + "&nickName=" + optionJson.items[index].nickName + "&userPhoneNumber=" + optionJson.items[index].authenticationEntity.userPhoneNumber + "&authenticationId=" + optionJson.items[index].authenticationEntity.id + "&userTypeName=" + optionJson.items[index].userTypeName + "\" class=\"inline-block\" title=\"编辑\"><img onclick='set()' src=\"images/icon_edit.gif\"/>" + "</a>"
                                                } else {
                                                    str += "<a href=\"edit_user.jsp?id=" + optionJson.items[index].id + "&nickName=" + optionJson.items[index].nickName + "&userPhoneNumber=" + optionJson.items[index].authenticationEntity.userPhoneNumber + "&authenticationId=0\" class=\"inline-block\" title=\"编辑\"><img onclick='set()' src=\"images/icon_edit.gif\"/>" + "</a>"
                                                }
                                                // "<a href=\"account.jsp\" class=\"inline-block\" title=\"资金管理\">"+"<img src=\"images/icon_account.gif\"/>"+"</a>"+
                                                str += "<a href=\"deleteUser.jsp?id=" + optionJson.items[index].id + "\" class=\"inline-block\" title=\"删除\">" + "<img src=\"images/icon_drop.gif\"/>" + "</a>" +
                                                    "</td>" +
                                                    "</tr>";

                                            }
                                            document.getElementById("tbodydata").innerHTML = str;
                                            document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
                                        } else {
                                            document.getElementById("tbodydata").innerHTML = "";
                                            $.ajax({
                                                type: "GET",
                                                contentType: "application/json; charset=utf-8",
                                                url: '${pageContext.request.contextPath}/getUser?userTypeName=' + userType + "&loginName=" + $("#tiaojian").val() + "&currentPage=" + currentPage + "&pageSize=" + pageSize,
                                                data: {},
                                                async: false,
                                                success: function (data) {
                                                    optionJson = data;
                                                    console.log(data)
                                                    var str = "";
                                                    for (var index = 0; index < optionJson.items.length; index++) {
                                                        str += "<tr>" +
                                                            "<td>" + optionJson.items[index].id + "</td>" +
                                                            "<td><img src=" + optionJson.items[index].headPortraitUrl + " alt=" + optionJson.items[index].headPortraitUrl + "></td>" +
                                                            "<td>" + optionJson.items[index].nickName + "</td>"
                                                        if (optionJson.items[index].authenticationEntity.userPhoneNumber != "此用户还未实名认证") {
                                                            str += "<td>" + optionJson.items[index].authenticationEntity.userPhoneNumber + "</td>"
                                                        } else {
                                                            str += "<td>此用户还未实名认证</td>"
                                                        }
                                                        str += "<td>" + optionJson.items[index].userTypeName + "</td>" +
                                                            "<td class=\"center\">"
                                                        if (optionJson.items[index].authenticationEntity.userPhoneNumber != "此用户还未实名认证") {
                                                            str += "<a href=\"edit_user.jsp?id=" + optionJson.items[index].id + "&nickName=" + optionJson.items[index].nickName + "&userPhoneNumber=" + optionJson.items[index].authenticationEntity.userPhoneNumber + "&authenticationId=" + optionJson.items[index].authenticationEntity.id + "&userTypeName=" + optionJson.items[index].userTypeName + "\" class=\"inline-block\" title=\"编辑\"><img onclick='set()' src=\"images/icon_edit.gif\"/>" + "</a>"
                                                        } else {
                                                            str += "<a href=\"edit_user.jsp?id=" + optionJson.items[index].id + "&nickName=" + optionJson.items[index].nickName + "&userPhoneNumber=" + optionJson.items[index].authenticationEntity.userPhoneNumber + "&authenticationId=0\" class=\"inline-block\" title=\"编辑\"><img onclick='set()' src=\"images/icon_edit.gif\"/>" + "</a>"
                                                        }
                                                        // "<a href=\"account.jsp\" class=\"inline-block\" title=\"资金管理\">"+"<img src=\"images/icon_account.gif\"/>"+"</a>"+
                                                        str += "<a href=\"deleteUser.jsp?id=" + optionJson.items[index].id + "\" class=\"inline-block\" title=\"删除\">" + "<img src=\"images/icon_drop.gif\"/>" + "</a>" +
                                                            "</td>" +
                                                            "</tr>";
                                                        document.getElementById("tbodydata").innerHTML = str;
                                                    }
                                                    if (optionJson.items.length < 15) {
                                                        optionJson.totalPage = 1;
                                                    }
                                                    document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
                                                }
                                            });
                                        }
                                    } else {
                                        //根据用户实名认证id查询
                                        document.getElementById("tbodydata").innerHTML = "";
                                        $.ajax({
                                            async: false,
                                            url: '${pageContext.request.contextPath}/getUser?userPhoneNumber=' + $("#tiaojian").val() + "&currentPage=" + currentPage + "&pageSize=" + pageSize,
                                            type: 'GET',
                                            dataType: 'json',
                                            data: {},
                                            success: function (data4) {
                                                if (data4.items.length != 0) {
                                                    optionJson = data4;
                                                    var str = "";
                                                    if (userType == "选择会员等级") {

                                                        for (var index = 0; index < optionJson.items.length; index++) {
                                                            str += "<tr>" +
                                                                "<td>" + optionJson.items[index].id + "</td>" +
                                                                "<td><img src=" + optionJson.items[index].headPortraitUrl + " alt=" + optionJson.items[index].headPortraitUrl + "></td>" +
                                                                "<td>" + optionJson.items[index].nickName + "</td>"
                                                            if (optionJson.items[index].authenticationEntity.userPhoneNumber != "此用户还未实名认证") {
                                                                str += "<td>" + optionJson.items[index].authenticationEntity.userPhoneNumber + "</td>"
                                                            } else {
                                                                str += "<td>此用户还未实名认证</td>"
                                                            }

                                                            str += "<td>" + optionJson.items[index].userTypeName + "</td>" +
                                                                "<td class=\"center\">"
                                                            if (optionJson.items[index].authenticationEntity.userPhoneNumber != "此用户还未实名认证") {
                                                                str += "<a href=\"edit_user.jsp?id=" + optionJson.items[index].id + "&nickName=" + optionJson.items[index].nickName + "&userPhoneNumber=" + optionJson.items[index].authenticationEntity.userPhoneNumber + "&authenticationId=" + optionJson.items[index].authenticationEntity.id + "&userTypeName=" + optionJson.items[index].userTypeName + "\" class=\"inline-block\" title=\"编辑\"><img onclick='set()' src=\"images/icon_edit.gif\"/>" + "</a>"
                                                            } else {
                                                                str += "<a href=\"edit_user.jsp?id=" + optionJson.items[index].id + "&nickName=" + optionJson.items[index].nickName + "&userPhoneNumber=" + optionJson.items[index].authenticationEntity.userPhoneNumber + "&authenticationId=0\" class=\"inline-block\" title=\"编辑\"><img onclick='set()' src=\"images/icon_edit.gif\"/>" + "</a>"
                                                            }
                                                            // "<a href=\"account.jsp\" class=\"inline-block\" title=\"资金管理\">"+"<img src=\"images/icon_account.gif\"/>"+"</a>"+
                                                            str += "<a href=\"deleteUser.jsp?id=" + optionJson.items[index].id + "\" class=\"inline-block\" title=\"删除\">" + "<img src=\"images/icon_drop.gif\"/>" + "</a>" +
                                                                "</td>" +
                                                                "</tr>";

                                                        }
                                                        document.getElementById("tbodydata").innerHTML = str;
                                                        document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
                                                    }
                                                } else {
                                                    //根据用户实名认证id查询
                                                    document.getElementById("tbodydata").innerHTML = "";
                                                    alert($("#tiaojian").val())
                                                    $.ajax({
                                                        async: false,
                                                        url: '${pageContext.request.contextPath}/getUser?userName=' + $("#tiaojian").val() + "&currentPage=" + currentPage + "&pageSize=" + pageSize,
                                                        type: 'GET',
                                                        dataType: 'json',
                                                        data5: {},
                                                        success: function (data5) {
                                                            if (data5.items.length != 0) {
                                                                optionJson = data5;
                                                                var str = "";
                                                                if (userType == "选择会员等级") {

                                                                    for (var index = 0; index < optionJson.items.length; index++) {
                                                                        str += "<tr>" +
                                                                            "<td>" + optionJson.items[index].id + "</td>" +
                                                                            "<td><img src=" + optionJson.items[index].headPortraitUrl + " alt=" + optionJson.items[index].headPortraitUrl + "></td>" +
                                                                            "<td>" + optionJson.items[index].nickName + "</td>"
                                                                        if (optionJson.items[index].authenticationEntity.userPhoneNumber != "此用户还未实名认证") {
                                                                            str += "<td>" + optionJson.items[index].authenticationEntity.userPhoneNumber + "</td>"
                                                                        } else {
                                                                            str += "<td>此用户还未实名认证</td>"
                                                                        }

                                                                        str += "<td>" + optionJson.items[index].userTypeName + "</td>" +
                                                                            "<td class=\"center\">"
                                                                        if (optionJson.items[index].authenticationEntity.userPhoneNumber != "此用户还未实名认证") {
                                                                            str += "<a href=\"edit_user.jsp?id=" + optionJson.items[index].id + "&nickName=" + optionJson.items[index].nickName + "&userPhoneNumber=" + optionJson.items[index].authenticationEntity.userPhoneNumber + "&authenticationId=" + optionJson.items[index].authenticationEntity.id + "&userTypeName=" + optionJson.items[index].userTypeName + "\" class=\"inline-block\" title=\"编辑\"><img onclick='set()' src=\"images/icon_edit.gif\"/>" + "</a>"
                                                                        } else {
                                                                            str += "<a href=\"edit_user.jsp?id=" + optionJson.items[index].id + "&nickName=" + optionJson.items[index].nickName + "&userPhoneNumber=" + optionJson.items[index].authenticationEntity.userPhoneNumber + "&authenticationId=0\" class=\"inline-block\" title=\"编辑\"><img onclick='set()' src=\"images/icon_edit.gif\"/>" + "</a>"
                                                                        }
                                                                        // "<a href=\"account.jsp\" class=\"inline-block\" title=\"资金管理\">"+"<img src=\"images/icon_account.gif\"/>"+"</a>"+
                                                                        str += "<a href=\"deleteUser.jsp?id=" + optionJson.items[index].id + "\" class=\"inline-block\" title=\"删除\">" + "<img src=\"images/icon_drop.gif\"/>" + "</a>" +
                                                                            "</td>" +
                                                                            "</tr>";

                                                                    }
                                                                    document.getElementById("tbodydata").innerHTML = str;
                                                                    document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
                                                                }
                                                            }
                                                        }
                                                    })
                                                }
                                            }
                                        })
                                    }
                                }
                            })
                        }
                    }
                })
            }
        }

        /*
        分页下一页
        */
        function pageJia() {
            if (pagecount > 1) {
                pagecount--;
                if ($("#select").val() != "" || $("#tiaojian").val() != "") {
                    tiaojianSelect(pagecount, optionJson.pageSize)
                } else {
                    refurbishIndex(pagecount, optionJson.pageSize)
                }
                document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
            }
        }

        /*
        分页上一页
        */
        function pageJian() {
            if (pagecount < optionJson.totalPage) {
                pagecount++;
                if ($("#select").val() != "" || $("#tiaojian").val() != "") {
                    tiaojianSelect(pagecount, optionJson.pageSize)
                } else {
                    refurbishIndex(pagecount, optionJson.pageSize)
                }
                document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
            }
            // fun();
        }

        /*
         * 分页跳转
         */
        function tiaozhuan() {
            pagecount = parseInt($("#yema").val());
            if (pagecount > optionJson.totalPage) {
                pagecount = optionJson.totalPage
                document.getElementById("yema").value = optionJson.totalPage;
            } else if (pagecount < 1) {
                pagecount = 1
                document.getElementById("yema").value = 1;
            }
            refurbishIndex(pagecount, optionJson.pageSize)
            document.getElementById("result").innerHTML = pagecount + "/" + optionJson.totalPage;
        }

    </script>
    <script type="text/javascript">

    </script>
</head>
<body onload="refurbishIndex(1,15),huiyuanleixing()">
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i class="user"></i><em>会员列表</em></span>
        <span class="modular fr"><a href="add_user.jsp" class="pt-link-btn">+添加新会员</a></span>
    </div>
    <div class="operate">
        <form action="/getUser">
            <select id="select" class="inline-select">
                <option>选择会员等级</option>

            </select>
            <input id="tiaojian" type="text" class="textBox length-long" placeholder="输入会员昵称、姓名、手机号码..."/>
            <input type="button" onclick="tiaojianSelect(1,15)" value="查询" class="tdBtn"/>
        </form>
    </div>
    <table class="list-style Interlaced">
        <tr>
            <th>编号</th>
            <th>头像地址</th>
            <th>会员昵称</th>
            <th>手机号码</th>
            <th>用户类型</th>
            <th>操作</th>
        </tr>
        <tbody id="tbodydata">

    </table>
    <!-- BatchOperation -->
    <div style="overflow:hidden;">
        <div class="turnPage center fr" id="pageBtn" style="width: auto;display:inline-block !important;height: auto;">
            <a onclick="pageJia()">上一页</a>
            <a>跳转至</a>
            <input type="text" id="yema" style="width: 20px;"/>
            <a onclick="tiaozhuan()">跳转</a>
            <a onclick="pageJian()">下一页</a>
            <a id="result"></a>
        </div>
    </div>
</div>
</div>
</body>
</html>