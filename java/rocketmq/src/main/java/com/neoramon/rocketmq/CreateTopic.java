package com.neoramon.rocketmq;

import org.apache.rocketmq.broker.BrokerController;
import org.apache.rocketmq.broker.topic.TopicConfigManager;
import org.apache.rocketmq.common.BrokerConfig;
import org.apache.rocketmq.common.MixAll;
import org.apache.rocketmq.remoting.netty.NettyClientConfig;
import org.apache.rocketmq.remoting.netty.NettyServerConfig;
import org.apache.rocketmq.store.config.MessageStoreConfig;

public class CreateTopic {

    public static void main(final String... args) throws Exception {
        final BrokerController brokerController = new BrokerController(//
                new BrokerConfig(), //
                new NettyServerConfig(), //
                new NettyClientConfig(), //
                new MessageStoreConfig());
        final boolean initResult = brokerController.initialize();
        System.out.println("initialize " + initResult);
        brokerController.start();

        final TopicConfigManager topicConfigManager = new TopicConfigManager(brokerController);

        final String topic = "TestTopic_SEND_2";
        final String defaultTopic = MixAll.DEFAULT_TOPIC;
        final String remoteAddress = "172.17.0.2:9876";
        final int clientDefaultTopicQueueNums = 1;
        final int topicSysFlag = 4;

        topicConfigManager.createTopicInSendMessageMethod(topic, defaultTopic, remoteAddress, clientDefaultTopicQueueNums, topicSysFlag);

        System.out.println("Will persist: " + topicConfigManager);

        topicConfigManager.persist();

        System.out.println("Persisted ");

        brokerController.shutdown();

    }
}
