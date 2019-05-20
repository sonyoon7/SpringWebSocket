//package com.yuni.interceptor;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
//
//public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {
//
//	@Autowired
//	private UserService userService;
//
//	@Override
//	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
//		Map<String, Object> attributes) throws Exception {
//		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		attributes.put(UserConstant.HEADER_USER_KEY, userService.findBy(user.getId()));
//		return super.beforeHandshake(request, response, wsHandler, attributes);
//	}
//
//}
