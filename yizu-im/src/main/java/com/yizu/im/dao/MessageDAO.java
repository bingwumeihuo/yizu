package com.yizu.im.dao;

import com.mongodb.bulk.UpdateRequest;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.yizu.im.entity.Message;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * @Package: com.yizu.im.dao
 * @ClassName: MessageDAO
 * @Description: Java类作用
 * @Author: 式神
 * @CreateDate: 2019/7/23 1:16
 */
public interface MessageDAO {
    List<Message> findListByFromAndTo(Long fromId, Long toId, Integer page, Integer
            rows);

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    Message findMessageById(String id);

    /**
     * 更新消息状态
     *
     * @param id
     * @param status
     * @return
     */
    UpdateResult updateMessageState(ObjectId id, Integer status);

    /**
     * 新增消息
     *
     * @param message
     * @return
     */
    Message saveMessage(Message message);

    /**
     * 根据消息id删除数据
     *
     * @param id
     * @return
     */
    DeleteResult deleteMessage(String id);
}
