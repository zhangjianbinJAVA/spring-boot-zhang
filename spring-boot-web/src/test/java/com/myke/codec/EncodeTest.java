package com.myke.codec;

import org.junit.Test;

/**
 * user: zhangjianbin <br/>
 * date: 2018/2/7 17:32
 */
public class EncodeTest {

    /**
     * 最近用到AES加密，在这里整理成篇，供大家参考阅读，在使用该demo过程中，首先你需要看一下demo简
     * <p>
     * 介，查看是否适合你的项目。
     * <p>
     * 本DEMO AES加密流程为:
     * <p>
     * 加密的过程: 参数字典 --> json字符串 --> base64加密后的字符串 --> AES加密后base64再加密 --> 输出最终加密后的字符串;
     * <p>
     * 解密的过程：
     * <p>
     * 获取加密的字符串 -->base64解密 --> AES解密后base64解密 --> json字符串 --> 数据字典;(与加密的过程相反)
     * <p>
     * 网上对AES的详细介绍已经有很多，在这里不做赘述，如果你需要了解这些知识，度娘，google 去吧.
     */
    @Test
    public void aes() {

    }
}
