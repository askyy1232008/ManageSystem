package com.lee.dao;

import java.util.List;


public interface BaseDao {
	/**
	 * 保存对象
	 * @param obj
	 */
	void save(Object obj);
	/**
	 * 修改对象
	 * @param obj
	 */
	void update(Object obj);
	/**
	 * 删除对象
	 * @param obj
	 */
	void remove(Object obj);
	/**
	 * 获取对象
	 * @param cls entity
	 * @param id  entity-id
	 */
	Object get(Class<?> cls, java.io.Serializable id);
	/**
	 * 执行hql获取列表数据
	 * @param hql
	 */
	List<Object> list(String hql);
	/**
	 * 执行分页查询
	 * @param hql
	 * @param cls entity
	 * @param start 开始位置 
	 * @param pageSize 每页数据量
	 * @return
	 */
	List<?> execQuery(String hql,Integer start,Integer pageSize);
	/**
	 * 查询数量count
	 * @param hql
	 * @return
	 */
	Integer execQuery(String hql);
}
