1.ConsumeFromWhere设置
     ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET一个新的订阅组第一次启动从队列的最前位置开始消费,后续再启动接着上次消费的进度开始消费
     ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET 一个新的订阅组第一次启动从队列的最后位置开始消费,后续再启动接着上次消费的进度开始消费
     ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET_AND_FROM_MIN_WHEN_BOOT_FIRST  @Deprecated
     ConsumeFromWhere.CONSUME_FROM_MAX_OFFSET   @Deprecated
     ConsumeFromWhere.CONSUME_FROM_MIN_OFFSET  @Deprecated
     ConsumeFromWhere.CONSUME_FROM_TIMESTAMP    一个新的订阅组第一次启动从指定时间点开始消费,后续再启动接着上次消费的进度开始消费,
                                                    时间点设置参见DefaultMQPushConsumer.consumeTimestamp参数
     MessageModel.CLUSTERING  集群消费，一个 Consumer Group 中的 Consumer 实例平均分摊消费消息。例如某个 Topic 有 9 条消息，其中一个 Consumer Group 有 3 个实例（可能是 3 个迕程，戒者 3 台机器），那举每个实例只消费其中的 3 条消息
     MessageModel.BROADCASTING  广播



 2.搭建调试环境的过程：

 启动 RocketMQ Namesrv
 启动 RocketMQ Broker
 启动 RocketMQ Spring Boot Producer
 启动 RocketMQ Spring Boot Consumer
 最小化的 RocketMQ 的环境，暂时不考虑 Namesrv 集群、Broker 集群、Consumer 集群。


