package test;


import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.huntlaw.lawchat.plugin.dao.TopicMapper;
import cn.huntlaw.lawchat.plugin.entity.Topic;


public class Test {
	
	

	public static void main(String[] args) {
		/*double mLat1 = 39.90923; // point1纬度
		double mLon1 = 116.357428; // point1经度
		double mLat2 = 39.90923;// point2纬度
		double mLon2 = 116.397428;// point2经度
*/		
		double mLat1 = 39.95676; // point1纬度
		double mLon1 = 116.401394; // point1经度
		double mLat2 = 36.63014;// point2纬度
		double mLon2 = 114.499574;// point2经度
		
	//	double distance =(new Test()).GetLongDistance(mLon1, mLat1, mLon2, mLat2);
	//	System.out.println(distance);
		
		/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
		TopicMapper topicMapper = (TopicMapper) applicationContext.getBean("topicMapper");
		
		try {
			Topic topic = new Topic();
			topic.setTitle("北京雾霾天");
			topic.setContent("北京雾霾影响首都人民的健康与出行");
			topic.setImagecount(0);
			topic.setLocation_x(1.1f);
			topic.setLocation_y(1.1f);
			topic.setCreatetime(new Date());
			
			topicMapper.insertTopic(topic);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}			
}
