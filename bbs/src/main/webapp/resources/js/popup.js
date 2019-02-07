 // Get the modal
 var modal = document.getElementById('myModal');

 // Get the button that opens the modal
 var btn = document.getElementById("myBtn");

 // Get the <span> element that closes the modal
 var span = document.getElementsByClassName("close")[0];                                          

 // When the user clicks on the button, open the modal  
 btn.onclick = function popOpen() {
     modal.style.display = "block";
 }

 // When the user clicks on <span> (x), close the modal
 span.onclick = function popClose() {
     modal.style.display = "none";
 }

 // When the user clicks anywhere outside of the modal, close it
 window.onclick = function(event) {
     if (event.target == modal) {
         modal.style.display = "none";
     }
 } 
 
//Get cookie function
 function getCookie(name) { 
    var cookieName = name + "=";
    var x = 0;
    while ( x <= document.cookie.length ) { 
       var y = (x+cookieName.length); 
       if ( document.cookie.substring( x, y ) == cookieName) { 
          if ((lastChrCookie=document.cookie.indexOf(";", y)) == -1) 
             lastChrCookie = document.cookie.length;
          return decodeURI(document.cookie.substring(y, lastChrCookie));
       }
       x = document.cookie.indexOf(" ", x ) + 1; 
       if ( x == 0 )
          break; 
       } 
    return "";
 }

 /* setCookie function */
 function setCookie(cname, value, expire) {
	 var todayValue = new Date();
	 // 오늘 날짜를 변수에 저장
	 
	 todayValue.setDate(todayValue.getDate() + expire);
	 document.cookie = cname + "=" + encodeURI(value) + "; expires=" + todayValue.toGMTString() + "; path=/;";
 } 

 // 하루동안 안열기 쿠키 저장
 $(function() {
    var closeTodayBtn = $('.closeTodayBtn');
    // 버튼의 클래스명은 closeTodayBtn

    closeTodayBtn.click(function() {
       setCookie( "popup", "end" , 1);
       // 하루동안이므로 1을 설정
       modal.style.display = "none";
       // 현재 열려있는 팝업은 닫으면서 쿠키값을 저장
    });
 }); 

 $(function() {
    var resetBtn = $('.resetBtn');
    resetBtn.click(function() {
       setCookie( "popup", null);       
       modal.style.display = "none";       
    });
 });
 
window.onload = function(){
 var result = getCookie('popup');
 console.log(result);
 if (result == 'end') {
     modal.style.display = "none";
 } else {
     modal.style.display = "block";
 }
}
 
 
 
 