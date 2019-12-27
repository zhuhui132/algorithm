package com.jd.test.elastaic;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.collect.ImmutableList;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.junit.Before;
import org.junit.Test;

public class ElastaicTest {
    TransportClient transportClient;

    //索引库名
    String index = "shb01";

    //type 名称
    String type = "stu";


    @Before
    public void before() {
        /**
         * 1:通过 setting对象来指定集群配置信息
         */
        Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", "my-application").put("client.transport.sniff", false)//启动嗅探功能
                .build();


        /**
         * 2：创建客户端
         * 通过setting来创建，若不指定则默认链接的集群名为elasticsearch
         * 链接使用tcp协议即9300
         */

        transportClient = new TransportClient(settings);

        TransportAddress transportAddress = new InetSocketTransportAddress("114.67.239.153", 9300);
        transportClient.addTransportAddresses(transportAddress);
         /**
          * 3：查看集群信息
          * 注意我的集群结构是：
        *   131的elasticsearch.yml中指定为主节点不能存储数据，
        *   128的elasticsearch.yml中指定不为主节点只能存储数据。
        * 所有控制台只打印了192.168.79.128,只能获取数据节点
        *
        */
        ImmutableList<DiscoveryNode> connectedNodes = transportClient.connectedNodes();
        for(DiscoveryNode node : connectedNodes)
        {
            System.out.println(node.getHostAddress());
        }

    }

    /**
     * 通过prepareGet方法获取指定文档信息
     */
    @Test
    public void testGet() {
        GetResponse getResponse = transportClient.prepareGet(index, type, "1").get();
        System.out.println(getResponse.getSourceAsString());
    }





}
