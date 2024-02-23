package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.BoardDao;
import com.mvc.upgrade.model.dto.BoardDto;

@Service
// Biz, Service 담당하는 단이라고 선언한다.
// 자동으로 해당 클래스의 bean(객체)가 생성된다.
public class BoardBizImpl implements BoardBiz {
	
	@Autowired
	private BoardDao dao;
	// @Repository로 DAO 단임을 선언하면 자동으로 객체(bean) 생성된다.
	// 그 객체를 연결시킨다.

	@Override
	public List<BoardDto> selectList() {
		return dao.selectList();
		// Dao에서 selectList 실행해 받은 결과 값을 컨트롤러로 돌려준다.
		// 컨트롤러 <-> biz <-> dao <-> db
	}

	@Override
	public BoardDto selectOne(int myno) {
		return dao.selectOne(myno);
		// Dao에서 selectOne 실행해 받은 결과 값을 컨트롤러로 돌려준다.
		// 컨트롤러 <-> biz <-> dao <-> db
	}

	@Override
	public int insert(BoardDto dto) {
		return dao.insert(dto);
		// Dao에서 selectOne 실행해 받은 결과 값을 컨트롤러로 돌려준다.
		// 컨트롤러 <-> biz <-> dao <-> db
	}

	@Override
	public int update(BoardDto dto) {
		return 0;
	}

	@Override
	public int delete(int myno) {	
		return 0;
	}

}
