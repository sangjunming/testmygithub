package cn.huntlaw.lawchat.plugin.entity;

import java.util.Date;

public class Topic {
    public int id;//主键
    public String topicNo;//帖子编号
    public String title;//帖子标题
    public String content;//帖子的内容
    public int imagecount;//帖子中的图片数量
    public float location_x;//发帖的位置经度
    public float location_y;//发帖的位置纬度
    public Date createtime;//发帖时间
    public Date updatetime;//改贴时间
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTopicNo() {
		return topicNo;
	}
	public void setTopicNo(String topicNo) {
		this.topicNo = topicNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getImagecount() {
		return imagecount;
	}
	public void setImagecount(int imagecount) {
		this.imagecount = imagecount;
	}
	public float getLocation_x() {
		return location_x;
	}
	public void setLocation_x(float location_x) {
		this.location_x = location_x;
	}
	public float getLocation_y() {
		return location_y;
	}
	public void setLocation_y(float location_y) {
		this.location_y = location_y;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}    
}
