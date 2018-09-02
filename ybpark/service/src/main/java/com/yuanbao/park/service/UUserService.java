package com.yuanbao.park.service;

import java.util.List;

import com.yuanbao.park.entity.UPermission;
import com.yuanbao.park.entity.URole;
import com.yuanbao.park.entity.UUser;

public interface UUserService {
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 */
	public UUser findByName(String username);
	
	/**
	 * 根据用户id查询用户角色
	 * @param id
	 */
	public List<URole> findURoleByUid(Long id);

	/**
	 * 根据用户id查询用户权限
	 * @param id
	 */
	public List<UPermission> findUPermissionByUid(Long id);
}
