 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
 <!DOCTYPE html> 
 <html> 
  <head> 
  <meta charset="UTF-8"> 
  <title>Insert title here</title> 	

  </head> 
  <body> 
    <script type="text/javascript">
    $('document').ready(function() {
        var wsUri = "ws://아이피/빈설정할때 적은 웹소켓연결할 uri";

        websocket = new WebSocket(wsUri);
//딱봐도 알거라고 믿겟음 함수명이 모든걸 말아주고있져?
        websocket.onopen = function(evt) {
            onOpen(evt)
        };
//것도 메시지보내는
        websocket.onmessage = function(evt) {
            onMessage(evt)
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