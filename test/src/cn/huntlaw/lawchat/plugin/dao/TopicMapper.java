package cn.huntlaw.lawchat.plugin.dao;

import java.util.List;

import cn.huntlaw.lawchat.plugin.entity.Topic;

public interface TopicMapper {
	
	/**查询所有*/
	public List<Topic> selectAllTopic() throws Exception;
	
	/**查询一个*/
	public Topic selectTopicByTopicNo(Topic topic) throws Exception;
	
    /**插入*/
	public int insertTopic(Topic topic) throws Exception;
	
	/**修改 */
	public int updateTopicByTopicNo(Topic topic) throws Exception;
	
	/**删除*/
	public int deleteTopicByTopicNo(String topicNo) throws Exception;
	
}
