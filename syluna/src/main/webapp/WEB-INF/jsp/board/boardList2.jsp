<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@ include file="/WEB-INF/include/include-header.jsp" %>

<body class="default">
    <h2>게시판 목록</h2>
    <table class="board_list">
        <colgroup>
            <col width="10%"/>
            <col width="*"/>
            <col width="15%"/>
            <col width="20%"/>
        </colgroup>
        <thead>
            <tr>
                <th scope="col">글번호</th>
                <th scope="col">제목</th>
                <th scope="col">조회수</th>
                <th scope="col">작성일</th>
            </tr>
        </thead>
        <tbody id="tbody">
            <c:choose>
                <c:when test="${fn:length(list) > 0}">
                    <c:forEach items="${list }" var="row">
                        <tr>
                            <td>${row.IDX }</td>
                            <td class="title">
                                <a href="#this" name="title">${row.TITLE }</a>
                                <input type="hidden" id="IDX" value="${row.IDX }">
                            </td>
                            <td>${row.HIT_CNT }</td>
                            <td>${row.CREA_DTM }</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="4">조회된 결과가 없습니다.</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
    <br/>
    <a href="#this" class="btn" id="write">글쓰기</a>
    </body>
    <!-- <div id="PAGE_NAVI" style="text-align:center;"></div>
    <input type="hidden" id="PAGE_INDEX" name="PAGE_INDEX"> -->
    <%@ include file="/WEB-INF/include/include-body.jsp" %>
    <script type="text/javascript">
        $(document).ready(function(){
            window.onload=function() {fn_pageSelect(2);};
            $("#write").on("click", function(e){ //글쓰기 버튼
                e.preventDefault();
                fn_openBoardWrite();
            });
            
            $("a[name='title']").on("click", function(e){ //제목
                e.preventDefault();
                fn_openBoardDetail($(this));
            });
        });
        
        function fn_openBoardWrite(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/board/openBoardWrite.do' />");
            comSubmit.submit();
        }
         
        function fn_openBoardDetail(obj){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/board/openBoardDetail.do' />");
            comSubmit.addParam("IDX", obj.parent().find("#IDX").val());
            comSubmit.submit();
        }
        
        function fn_pageSelect(pageNo) {
            $.ajax({
                type: "POST",
                url : "<c:url value='board/selectBoardList.do'/>", 
                data : {
                    "pageNo" : pageNo
                },
                async : false,
                success : function (data, status) {
                    alert("success!");
                    var str="";
                    var total = data.TOTAL_COUNT;
                    var body = $("#tbody");
                    body.empty();
                    if(total == 0){
                        var str="<tr>" + "<td colspan='4'>조회 결과가 없음</td>" + "</tr>";
                        body.append(str);
                    }else{
                        alert("정보있음");
                    }
                    body.append(str);
                }
            });
        }
        
        /* function fn_selectBoardListCallBack(data) {
            // rendering 구현
        } */
    </script>

<%@ include file="/WEB-INF/include/include-footer.jsp" %>

