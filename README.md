# 基于SpringBoot
1. 实现redis的基本数据、对象存储等
2. 实现redis的发布与订阅功能
	1. 用途：
		- 同一台redis 不同端口之间
		-  任意停其中游戏服一台，不会影响在大厅的功能。
		-  能单独停服更新每一款游戏
		-  从而不影响其他的游戏的正常使用
			- room_server :port 8080  
			- hnmj_server: port 9090  
			- glzp_server: port 6075
	2. 例子：
		- 用户User创建房间，玩法 hnmj 在room服务器
		-  room_server服务器在hnmj这个channel上发送数据给订阅了hnmj这个信道的 hnmj_server服务器（Publish）
		-  hnmj_server服务器监听了 hnmj这个信道，收到消息（Subscribe）
		-  hnmj_server做消息处理发送数据给订阅了  room 这个信道的服务器 room_server (publish)
		-   room_server 服务器监听 room这个信道的信息（Subscribe）
		-  根据信息返回给 用户User

        
       
