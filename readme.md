1.广播式：服务端有消息时，会将所有消息发送到连接了当前endpoint的浏览器
（1）配置websocket，开启@EnableWebSocketMessageBroker参见WebSocketConfig
路径：/all
2.点对点
用户配置：WebSecurityConfig
访问路径：/login,/chat