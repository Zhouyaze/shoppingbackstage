package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_service.impl.shopping_backage_Kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhkj.shopmall.shoppingbackstage.shopping_backstage_api.vo.IndexMessageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(KafkaServiceImpl.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public static final String TOPIC="asd";

//    @KafkaListener(topics = "")
    private void handleMessage(String content) {
        try {
            System.out.println("接收到的信息:"+content);
            IndexMessageVO message = objectMapper.readValue(content, IndexMessageVO.class);
//            switch (message.getOperation()) {
//                case IndexMessageVO.SAVE:
//                    this.saveMessage(message);
//                    break;
//                case IndexMessageVO.DEL:
//                    this.delMessage(message);
//                    break;
//                case IndexMessageVO.UPDATE:
//                    this.updateMessage(message);
//                    break;
//                default:
//                    logger.warn("Not support message content " + content);
//                    break;
//            }
        } catch (IOException e) {
            logger.error("Cannot parse json for " + content, e);
        }
    }
    //商品commodity，商品关系specificationsrelation，商品分类commoditytyperelation给健康

    /**添加的消息*/
    private void saveMessage(IndexMessageVO indexMessageVO){
        String msg=indexMessageVO.getObjects();
        if (msg==null||msg==""){
            logger.error("Save message {} dose not exist!", msg);
//            this.index(msg,indexMessageVO.getRetry(),indexMessageVO.getId());
            return;
        }
    }
    /**修改的消息*/
    private void updateMessage(IndexMessageVO indexMessageVO){
        String msg=indexMessageVO.getObjects();
        if (msg==null||msg==""){
            logger.error("Update message {} dose not exist!", msg);
//            this.index(msg,indexMessageVO.getRetry(),indexMessageVO.getId());
            return;
        }
    }
    /**修改的消息*/
    private void delMessage(IndexMessageVO indexMessageVO){
        String msg=indexMessageVO.getObjects();
        if (msg==null||msg==""){
            logger.error("Del message {} dose not exist!", msg);
//            this.index(msg,indexMessageVO.getRetry(),indexMessageVO.getId());

            return;
        }
    }

    /**发送添加消息*/
    public <T> void kafka_save(String object, String id,Class<T> value) throws IOException, IOException {
        T t = objectMapper.readValue(object,value);
        String className = t.getClass().getSimpleName();
        String topic=this.getTable(className);
        IndexMessageVO indexMessageVO = new IndexMessageVO(IndexMessageVO.SAVE ,object,id);
        try {
            kafkaTemplate.send(topic, objectMapper.writeValueAsString(indexMessageVO));
            System.out.println("主题为"+topic+"添加发送成功:\n"+objectMapper.writeValueAsString(indexMessageVO));
        } catch (JsonProcessingException e) {
            logger.error("Json encode error for " + indexMessageVO);
        }
    }
    /**发送修改消息*/
    public <T> void kafka_update(String object, String id,Class<T> value) throws IOException {
        T t = objectMapper.readValue(object,value);
        String className = t.getClass().getSimpleName();
        String topic=this.getTable(className);
        IndexMessageVO indexMessageVO = new IndexMessageVO(IndexMessageVO.UPDATE ,object,id);
        try {
            kafkaTemplate.send(topic, objectMapper.writeValueAsString(indexMessageVO));
            System.out.println("主题为"+topic+"修改发送成功:\n"+objectMapper.writeValueAsString(indexMessageVO));
        } catch (JsonProcessingException e) {
            logger.error("Json encode error for " + indexMessageVO);
        }
    }
    /**发送删除消息*/
    public <T> void kafka_del(String id,Class<T> value) throws IOException {
//        T t = objectMapper.readValue(object,value);
//        String className = t.getClass().getSimpleName();
        String className=value.getSimpleName();
        String topic=this.getTable(className);
        IndexMessageVO indexMessageVO = new IndexMessageVO(IndexMessageVO.DEL ,id);
        try {
            kafkaTemplate.send(topic, objectMapper.writeValueAsString(indexMessageVO));
            System.out.println("主题为"+topic+"删除发送成功:\n"+objectMapper.writeValueAsString(indexMessageVO));
        } catch (JsonProcessingException e) {
            logger.error("Json encode error for " + indexMessageVO);
        }
    }
    /**截取表名*/
    private String getTable(String entity){
        return entity.substring(0,entity.lastIndexOf("E")).toLowerCase();
    }


}
