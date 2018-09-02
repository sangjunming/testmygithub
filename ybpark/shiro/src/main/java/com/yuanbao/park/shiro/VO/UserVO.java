package com.yuanbao.park.shiro.VO;

import java.util.Date;
import java.util.List;

import com.yuanbao.park.entity.UUser;


public class UserVO {
	    private Long id;
	    private String name;
	    private String password;
	    private String salt;
	    private String department;
	    private String position;
	    private Long parkId;
	    private String email;
	    private String deleteType;
	    private Date createtime;
	    private Date updatetime;
	    private Date lastlogintime;
	    private Long status;
	    private List<String> roleStrlist;
	    private List<String> perminsStrlist;
	    
		public UserVO() {
			super();
			// TODO Auto-generated constructor stub
		}

		
		public UserVO(UUser uUser, List<String> roleStrlist, List<String> perminsStrlist) {
			super();
			this.id = uUser.getId();
			this.name = uUser.getName();
			this.password = uUser.getPassword();
			this.salt = uUser.getSalt();
			this.department = uUser.getDepartment();
			this.position = uUser.getPosition();
			this.parkId = uUser.getParkId();
			this.email = uUser.getEmail();
			this.deleteType = uUser.getDeleteType();
			this.createtime = uUser.getCreatetime();
			this.updatetime = uUser.getUpdatetime();
			this.lastlogintime = uUser.getLastlogintime();
			this.status = uUser.getStatus();
			this.roleStrlist = roleStrlist;
			this.perminsStrlist = perminsStrlist;
		}

		

		public UserVO(Long id, String name, String password, String salt, String department, String position,
				Long parkId, String email, String deleteType, Date createtime, Date updatetime, Date lastlogintime,
				Long status, List<String> roleStrlist, List<String> perminsStrlist) {
			super();
			this.id = id;
			this.name = name;
			this.password = password;
			this.salt = salt;
			this.department = department;
			this.position = position;
			this.parkId = parkId;
			this.email = email;
			this.deleteType = deleteType;
			this.createtime = createtime;
			this.updatetime = updatetime;
			this.lastlogintime = lastlogintime;
			this.status = status;
			this.roleStrlist = roleStrlist;
			this.perminsStrlist = perminsStrlist;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getSalt() {
			return salt;
		}


		public void setSalt(String salt) {
			this.salt = salt;
		}


		public String getDepartment() {
			return department;
		}


		public void setDepartment(String department) {
			this.department = department;
		}


		public String getPosition() {
			return position;
		}


		public void setPosition(String position) {
			this.position = position;
		}


		public Long getParkId() {
			return parkId;
		}


		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getDeleteType() {
			return deleteType;
		}


		public void setDeleteType(String deleteType) {
			this.deleteType = deleteType;
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


		public Date getLastlogintime() {
			return lastlogintime;
		}


		public void setLastlogintime(Date lastlogintime) {
			this.lastlogintime = lastlogintime;
		}


		public Long getStatus() {
			return status;
		}


		public void setStatus(Long status) {
			this.status = status;
		}


		public List<String> getRoleStrlist() {
			return roleStrlist;
		}

		public void setRoleStrlist(List<String> roleStrlist) {
			this.roleStrlist = roleStrlist;
		}

		public List<String> getPerminsStrlist() {
			return perminsStrlist;
		}

		public void setPerminsStrlist(List<String> perminsStrlist) {
			this.perminsStrlist = perminsStrlist;
		}

		
}
