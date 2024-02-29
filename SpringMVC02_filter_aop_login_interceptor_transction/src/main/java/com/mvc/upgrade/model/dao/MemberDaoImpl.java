package com.mvc.upgrade.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MemberDto;

@Repository
// Dao 선언하는 Annotaion
// 자동으로 객체(bean)가 생성된다.
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MemberDto login(MemberDto dto) {
		
		MemberDto res = null;
		
		try { // try - catch문 필수 아니다.
			res = sqlSession.selectOne(NAMESPACE + "login", dto);
			// mymember.login
			// 넘겨받은 dto 파라미터로 mapper.xml에 넘겨준다.
		} catch(Exception e) {
			System.out.println("[Error] : login");
			e.printStackTrace();
		}
		
		return res;
	}

}
