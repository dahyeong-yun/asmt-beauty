<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<title>:: Beauty Inside ::</title>
</head>
<body class="bg-light">
<!-- 상단바 -->
	<%@include file="navbar.jsp" %>
<form>
<div>
상품확인
<div><img src ="${itemInfo.ITEM_IMAGE}"></div>
<div>
<p>${itemInfo.ITEM_NAME}</p>
<p>${itemInfo.ITEM_PRICE}원</p>
<p>${itemInfo.PAY_AMOUNT}개</p>
</div>
</div>
<div>
받는사람 정보
<div>
이름 : <input type="text" value="${loginMember.MEM_NAME}" id="MEM_NAME"><br>
휴대폰 번호 : <input type="text" value="${loginMember.MEM_PHONE}" id="MEM_PHONE">
주소 : <input type="text" value="${loginMember.MEM_ADDR}" id="MEM_ADDR">
배송메세지 : <input type="text" id="PAY_MESSAGE">
</div>
</div>
<div>
<input type="button" value="결제" id="payment"> <input type="button" value="취소" onclick="history.back();">
</div>
</form>
<script>
$('#payment').click(function(){
var IMP = window.IMP; // 생략가능
IMP.init('imp22202955'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
IMP.request_pay({
    pg : 'html5_inicis', //ActiveX 결제창은 inicis를 사용
    pay_method : 'card', //card(신용카드), trans(실시간계좌이체), vbank(가상계좌), phone(휴대폰소액결제)
    merchant_uid : 'merchant_' + new Date().getTime(), //상점에서 관리하시는 고유 주문번호를 전달
    name : '${itemInfo.ITEM_NAME}',
    amount : '${itemInfo.ITEM_PRICE}',
    buyer_name : $('#MEM_NAME').val(),
    buyer_tel : $('#MEM_PHONE').val(), //누락되면 이니시스 결제창에서 오류
    buyer_addr : $('#MEM_ADDR').val(),
    buyer_postcode : '123-456'
}, function(rsp) {
	console.log(rsp)
    if ( rsp.success ) {
    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
    	jQuery.ajax({
    		url: "/beauty/item/payment/complete", //cross-domain error가 발생하지 않도록 주의해주세요
    		type: 'POST',
    		dataType: 'text',
    		data: {
	    		"PAY_NUM" : rsp.imp_uid, //주문번호
	    		"ITEM_ID" : '${itemInfo.ITEM_ID}',
	    		"ITEM_NAME" : '${itemInfo.ITEM_NAME}',
	    	    "ITEM_PRICE" : '${itemInfo.ITEM_PRICE}',
	    	    "MEM_ID" : '${loginMember.MEM_ID}',
	    	    "MEM_NAME" : $('#MEM_NAME').val(),
	    	    "MEM_PHONE" : $('#MEM_PHONE').val(), 
	    	    "MEM_ADDR" : $('#MEM_ADDR').val(),
	    	    "PAY_AMOUNT" : '${itemInfo.PAY_AMOUNT}',
	    	    "PAY_MESSAGE" : $('#PAY_MESSAGE').val(),
	    	    "PAY_METHOD" : 'card' 	    
	    		//기타 필요한 데이터가 있으면 추가 전달
    		}
    	}).done(function(data) {
            console.log('호출끝남');
            //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
            if ( rsp.success ) {
              var msg = '결제가 완료되었습니다.';
              msg += '\n고유ID : ' + rsp.imp_uid;
              msg += '\n상점 거래ID : ' + rsp.merchant_uid;
              msg += '\n결제 금액 : ' + rsp.paid_amount;
              msg += '카드 승인번호 : ' + rsp.apply_num;
              alert(msg);
              window.location = '/beauty/item'; //완료페이지로 이동
            } else {
              console.log('결제실패함');
              //[3] 아직 제대로 결제가 되지 않았습니다.
              //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
            }
          })
        } else {
		    console.log('결제취소');
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
            alert(msg);
            window.history.go(-4); //실패
        }
              });
           });
</script>

	<!-- 하단 -->
	<%@include file="footer.jsp" %>
</body>
</html>