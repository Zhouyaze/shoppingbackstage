// function pageBean(currentPage,totalPage,pageSize){
//     // var currentPage = $("#currentPage").text();//得到当前页数
//     // currentPage = parseInt(currentPage);//得到的文本转成int
//     // var totalPage = $("#totalPage").text();//得到总页数
//     // totalPage = parseInt(totalPage);
//     // $('#pageBtn').html("");
//     var i = 1;
//     i = parseInt(i);
//     var item="<a onclick=\"refurbishIndex("+i+")\">第一页</a>";
//     if (totalPage <= 5 ) {//总页数小于五页，则加载所有页
//
//         for (i; i <= totalPage; i++) {
//             if (i == currentPage) {
//                 item += "<span class='disabled'>"+i+"</span>";
//             }else{
//                 item += "<a onclick='refurbishIndex("+currentPage+","+pageSize+")'>"+i+"</a>";
//             }
//         };
//         item+="<a onclick=\"refurbishIndex("+totalPage+")\">最后一页</a>"
//         $('#pageBtn').append(item);
//         return;
//     }else if (totalPage > 5) {//总页数大于五页，则加载五页
//         if (currentPage < 5) {//当前页小于5，加载1-5页
//             for (i; i <= 5; i++) {
//                 if (i == currentPage) {
//                     item += "<span class='disabled'>"+i+"</span>";
//                 }else{
//                 item += "<a onclick='refurbishIndex("+currentPage+","+pageSize+")'>"+i+"</a>";
//                 }
//             };
//             if (currentPage <= totalPage-2) {//最后一页追加“...”代表省略的页
//                 item += "<span> . . . </span>";
//             }
//             item+="<a onclick=\"refurbishIndex("+totalPage+")\">最后一页</a>"
//
//             $('#pageBtn').append(item);
//             return;
//         }else if (currentPage >= 5) {//当前页大于5页
//             for (i; i <= 2; i++) {//1,2页码始终显示
//                 item += "<a onclick='refurbishIndex("+currentPage+","+pageSize+")'>"+i+"</a>";
//             }
//             item += "<span> . . . </span>";//2页码后面用...代替部分未显示的页码
//             if (currentPage+1 == totalPage) {//当前页+1等于总页码
//                 for(i = currentPage-1; i <= totalPage; i++){//“...”后面跟三个页码当前页居中显示
//                     if (i == currentPage) {
//                         item += "<span class='disabled'>"+i+"</span>";
//                     }else{
//                     item += "<a onclick='refurbishIndex("+currentPage+","+pageSize+")'>"+i+"</a>";
//                     }
//                 }
//             }else if (currentPage == totalPage) {//当前页数等于总页数则是最后一页页码显示在最后
//                 for(i = currentPage-2; i <= totalPage; i++){//...后面跟三个页码当前页居中显示
//                     if (i == currentPage) {
//                         item += "<span class='disabled'>"+i+"</span>";
//                     }else{
//                         item += "<a onclick='refurbishIndex("+currentPage+","+pageSize+")'>"+i+"</a>";
//                     }
//                 }
//             }else{//当前页小于总页数，则最后一页后面跟...
//                 for(i = currentPage-1; i <= currentPage+1; i++){//currentPage+1页后面...
//                     if (i == currentPage) {
//                         item += "<span class='disabled'>"+i+"</span>";
//                     }else{
//                     item += "<a onclick='refurbishIndex("+currentPage+","+pageSize+")'>"+i+"</a>";
//                     }
//                 }
//
//                 item += "<span> . . . </span>";
//                 item+="<a onclick=\"refurbishIndex("+totalPage+")\">最后一页</a>"
//             }
//             $('#pageBtn').append(item);
//             return;
//         }
//     }
// }