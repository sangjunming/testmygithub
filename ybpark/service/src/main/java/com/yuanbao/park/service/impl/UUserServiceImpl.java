package com.yuanbao.park.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanbao.park.dao.master.CeshiMapper;
import com.yuanbao.park.dao.master.UPermissionMapper;
import com.yuanbao.park.dao.master.URoleMapper;
import com.yuanbao.park.dao.master.URolePermissionMapper;
import com.yuanbao.park.dao.master.UUserMapper;
import com.yuanbao.park.dao.master.UUserRoleMapper;
import com.yuanbao.park.entity.UPermission;
import com.yuanbao.park.entity.URole;
import com.yuanbao.park.entity.URolePermission;
import com.yuanbao.park.entity.UUser;
import com.yuanbao.park.entity.UUserRole;
import com.yuanbao.park.service.UUserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class UUserServiceImpl implements UUserService {

	@Autowired
	private UPermissionMapper uPermissionMapper;
	
	@Autowired
	private URoleMapper uRoleMapper;
	
	@Autowired
	private URolePermissionMapper uRolePermissionMapper;
	
	@Autowired
	private UUserMapper uUserMapper;
	
	@Autowired
	private UUserRoleMapper uUserRoleMapper;

	@Override
	public UUser findByName(String username) {
		return uUserMapper.selectUUserByName(username);
	}
	
	@Override
	public List<URole> findURoleByUid(Long id) {
		List<URole> result = null;
		
		Example example = new Example(UUserRole.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("uid", id);
		List<UUserRole> list = uUserRoleMapper.selectByExample(example);
		
		if(list!=null&&list.size()>0){
			result = new ArrayList<URole>();
			for(UUserRole ur : list){
				Long rid = ur.getRid();
				URole urole = uRoleMapper.selectByPrimaryKey(rid);
				result.add(urole);
			}
		}
		
		return result;
	}

	@Override
	public List<UPermission> findUPermissionByUid(Long id) {
		List<UPermission> result = null;
		
		Example example = new Example(UUserRole.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("uid", id);
		List<UUserRole> list = uUserRoleMapper.selectByExample(example);
		
		if(list!=null&&list.size()>0){
			result = new ArrayList<UPermission>();
			for(UUserRole ur : list){
				Long rid = ur.getRid();
				
				Example example1 = new Example(URolePermission.class);
				Criteria criteria1 = example1.createCriteria();
				criteria1.andEqualTo("rid", rid);
				List<URolePermission> plist = uRolePermissionMapper.selectByExample(example1);
				if(plist!=null&&plist.size()>0) {
					for(URolePermission p : plist){
						Long pid = p.getPid();
						UPermission upermission = uPermissionMapper.selectByPrimaryKey(pid);
						result.add(upermission);
					}
				}
			}
		}
		
		return result;
	}

}
