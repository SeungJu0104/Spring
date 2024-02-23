package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;

@Repository
// DAO 담당하는 단이라고 선언한다.
// 자동으로 객체(bean)이 생성된다.
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	// mybatis 객체(bean)과 연결. 의존성 주입.
	
	@Override
	public List<BoardDto> selectList() {
		
		List <BoardDto> list = new ArrayList <BoardDto> ();
		
		try {
			// Dao에 namespace 적어놨다.(myboard.)
			list = sqlSession.selectList(NAMESPACE + "selectList");
			// namespace는 mapper의 id같은 개념
			// board-mapper에서 해당하는 namespace를 찾아 거기에 selectList라는 id를 가진 태그를 실행
			// myboard.selectList
			
		} catch(Exception e){
			System.out.println("[Error] : select list");
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public BoardDto selectOne(int myno) {
		
		BoardDto dto = null;
		
		// Dao에 namespace 적어놨다.(myboard.)
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", myno);
		} catch(Exception e){
			System.out.println("[Error] : select one");
			e.printStackTrace();
		}
		// namespace는 mapper의 id같은 개념
		// board-mapper에서 해당하는 namespace를 찾아 거기에 selectOne라는 id를 가진 태그를 실행
		// 필요한 파리미터도 같이 넘겨준다.
		// myboard.selectOne
		
		return dto;
	}

	@Override
	public int insert(BoardDto dto) {
		
		int res = 0;
		
		// 원하는 문자 블럭치고, alt+shift+z 하면 try-catch문 자동 완성 할 수 있다.
		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
			// myboard.insert
		} catch(Exception e) {
			System.out.println("[Error] : insert");
			e.printStackTrace();
		}
		
		return res;
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
