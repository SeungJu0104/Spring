package com.mvc.upgrade.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.MemberDao;
import com.mvc.upgrade.model.dto.MemberDto;

@Service
// 서비스단 선언하는 Annotation
// 자동으로 객체 생성
public class MemberBizImpl implements MemberBiz {
	
	@Autowired
	private MemberDao dao;
	// Annotation으로 Dao 선언한 객체와 연결
	// Autowired는 타입으로 구별한다.

	@Override
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}

	@Override
	public int insert(MemberDto dto) {
		return dao.insert(dto);
	}

}
