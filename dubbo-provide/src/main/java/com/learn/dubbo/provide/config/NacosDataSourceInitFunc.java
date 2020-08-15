package com.learn.dubbo.provide.config;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author jingjing.zhang
 */
@Configuration
@ConfigurationProperties(prefix="alibaba.nacos")
public class NacosDataSourceInitFunc implements InitFunc {
    private static Logger logger = LoggerFactory.getLogger(NacosDataSourceInitFunc.class);
    private String serverAddr;
    private String groupId;
    private String dataId;

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    @Override
    public void init() throws Exception {
        loadNacosData();
    }
    private void loadNacosData(){
        logger.info("----------------serverAddr: {}, groupId: {}, dataId: {} ",serverAddr,groupId,dataId);
        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource=
                new NacosDataSource<>(serverAddr, groupId, dataId, source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
                }));
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
    }
}
