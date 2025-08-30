package com.saymeevetime;

import com.saymeevetime.bean.ChatMessages;
import nonapi.io.github.classgraph.json.Id;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 *
 * @author jiacheng
 * @date 28/8/25 22:33 Thursday
 * @description :
 *
 */
@SpringBootTest
public class MongoCrudTest {

    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 插入文档
     */

    @Test
    public void testInsert(){
//        mongoTemplate.insert(new ChatMessages(1L,"聊天记录"));
    }


    /**
     * 插入文档
     */
    @Test
    public void testInsert2(){
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("聊天记录列表");
        mongoTemplate.insert(chatMessages);
    }


    /**
     * 根据ID查询文档
     */
    @Test
    public void testFindById() {
        ChatMessages chatMessages = mongoTemplate.findById("6801ead733ba9c4a0d9b6c7b", ChatMessages.class);
        System.out.println(chatMessages);
    }



    @Test
    public void testUpdate() {
        Criteria criteria = Criteria.where("_id").is("68b06ae498c84d1d24a02bc7");
        Query query = Query.query(criteria);
        Update update = new Update();
        update.set("content",
                "新的聊天记录列表");
        //修改或新增
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }

    @Test
    public void testUpdate2() {
        Criteria criteria = Criteria.where("_id").is("68b06ae498c84d1d24a02bc7");
                Query query = new Query(criteria);
        Update update = new Update();
        update.set("content",
                "新的聊天记录列表");
        //修改或新增
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }


    /**
     * 删除文档
     */
    @Test
    public void testDelete() {
        Criteria criteria = Criteria.where("_id").is("68b06ae498c84d1d24a02bc7");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }


}

