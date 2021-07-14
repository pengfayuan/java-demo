# 抽奖活动
基于redis的set实现抽奖功能
1、通过setOperations.add()添加抽奖者
2、通过setOperations.members()获取所有的抽奖者
3、通过setOperations.size()获取抽奖者人数
4、通过setOperations.pop()从抽奖者名单中随机获取抽奖者（返回后从集合中删除）



