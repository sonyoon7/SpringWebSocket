 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <!DOCTYPE html> 
 <html> 
  <head> 
  <meta charset="UTF-8"> 
  <title>Insert title here</title> 	
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.js"></script>
  

  </head> 
  <body> 
    <script>
    
    $('document').ready(function() {
        var wsUri = "ws://localhost:9090/app/echo";
//socket을 하나 여는데 ws로 여는 것임 어떠한 라이브러리도 추가 하지 않음  브라우져가 자체 지원하는 것임
//new WebSocket("ws://localhost:9090/echo")
        websocket =  new SockJS("<c:url value="/echo"/>");
       // websocket =  new WebSocket(wsUri);
        console.log("<c:url value="/echo"/>")
        websocket.onopen = function(evt) {
			console.log('Info : connection opened.')
			//setTimeout(function(){connect();},1000)//retry connection
            onOpen(evt)
			
			//연결이 되고 난 후 메세지를 받도록 짜기 
            websocket.onmessage = function(evt) {
				console.log(evt.data+'\n')
	            onMessage(evt)
	        };
			
			
        };
    
//에러
        websocket.onerror = function(evt) { 
            onError(evt)
        };

        function onOpen(evt) {
        }

        function onMessage(evt) {
            var recv = JSON.parse(evt.data);
            if(recv.type=='time')
                $('#time').text(recv.time);
            else if(recv.type=='chat'){
                var str = '<li>';
                str += '<table cellpadding="0" cellspacing="0">';
                str += '<tr>';
                str += '<td class="profile_td">';
                str += '<img src="resources/img/bitcoin-logo.png" />';
                str += '</td>';
                str += '<td class="chat_td">';
                str += '<div class="email">'
                str += recv.name;
                str += '</div>';
                str += '<div class="chat_preview">';
                str += recv.chat;
                str += '</div></td>';
                str += '<td class="time_td">';
                str += '<div class="time">';
                str += recv.date;
                str += '</div><div class="check"><p></p></div></td></tr></table></li>';
                $('.list ul').prepend(str);
            }
            
        }

        function onError(evt) {
        }

        function doSend(message) {
            websocket.send(message);
        }
        // 주기적으로 시간표시
        function getCurrentTime(){
            
            var Now = new Date();
            var NowTime = Now.getFullYear();

            NowTime += '-' + Now.getMonth() + 1 ;
            NowTime += '-' + Now.getDate();
            NowTime += ' ' + Now.getHours();
            NowTime += ':' + Now.getMinutes();
            NowTime += ':' + Now.getSeconds();

            return NowTime;
        }
        // 보내는곳에서 키포커스를 벗어날경우 
        $('#inputChat').keypress(function(data){
            if(data.which == 13){
                senddate = {
                    type:"chat",
                    name:$('#inputChatname').val(),
                    chat:$('#inputChat').val(),
                    date:getCurrentTime()
                };
                doSend(JSON.stringify(senddate));
                $('#inputChat').val('');
            }
        })
    })
    
    
    </script>
  </body> 
 </html>