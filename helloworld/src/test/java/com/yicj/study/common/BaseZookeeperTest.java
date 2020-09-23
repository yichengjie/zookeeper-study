package com.yicj.study.common;

import org.junit.Test;

import java.util.List;

public class BaseZookeeperTest extends BaseTest {

    @Test
    public void test1() throws Exception {
        String address = getZKServerAddress() ;
        BaseZookeeper zookeeper = new BaseZookeeper();
        zookeeper.connectZookeeper(address);
        List<String> children = zookeeper.getChildren("/");
        System.out.println(children);
    }

}
