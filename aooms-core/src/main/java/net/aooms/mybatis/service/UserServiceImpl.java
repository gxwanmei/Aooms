package net.aooms.mybatis.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.common.collect.Maps;
import net.aooms.mybatis.entity.User;
import net.aooms.mybatis.dao.GenericDaoSupport;
import net.aooms.mybatis.record.Record;
import net.aooms.mybatis.mapper.UserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private SqlSessionTemplate sessionTemplate;

	@Autowired
	private GenericDaoSupport genericDaoSupport;

	public boolean deleteAll() {
		userMapper.deleteAll();
		return true;
	}

	public List<User> selectListBySQL() {
		return userMapper.selectListBySQL();
	}

	public List<Map<String,Object>> selectMap() {
		User u = new User();


		Record record = Record.NEW();

		record.put("id",System.currentTimeMillis());
		record.put("name","lisi");


		Map<String,Object> maps = Maps.newHashMap();
		maps.put("id",System.currentTimeMillis());
		maps.put("name","zhangsan");

		genericDaoSupport.insert("user",record);

		//genericDaoSupport.

		//List<Map<String,Object>> datas = (List<Map<String, Object>>) genericDaoSupport.findForList("Demo.selectListBySQL",null);
		//System.err.println("datas = " + datas.size());

		//baseMapper.selectMapsPage(new Page(1,1),new EntityWrapper(new User()));
		//sqlSession.selectOne("23123");
		//sessionTemplate.getConfiguration().getMappedStatement("")
		//u.setId(System.currentTimeMillis());
		//baseMapper.insert(u);
		//baseMapper.deleteById(1L);

		return userMapper.selectMap(maps);
	}

	public List<User> selectListByWrapper(Wrapper wrapper) {
		return userMapper.selectListByWrapper(wrapper);
	}
}