package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// MyBatis 사용해 코드가 매우 간결해졌다.
	
	@Override
	public List<BoardDto> selectList() {
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		try {  
			list = sqlSession.selectList("myboard.selectList");
		} catch (Exception e) {
			System.out.println("[error] : select list");
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public BoardDto selectOne(int myno) {
		
		BoardDto dto = null;
		
		try {
			//String NAMESPACE = "myboard.";
			dto = sqlSession.selectOne(NAMESPACE+"selectOne", myno);
		} catch (Exception e) {
			System.out.println("[error] : selec one");
			e.printStackTrace();
		}
		
		return dto;
	}
	
	
	@Override
	public int insert(BoardDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE+"insert", dto);
		} catch (Exception e) {
			System.out.println("[error] : insert");
			e.printStackTrace();
		}
		return res;
	}
	
	
	
	@Override
	public int update(BoardDto dto) {
		
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "update", dto);
			System.out.println("에러 체크용1");
			// myboard.update
		} catch(Exception e) {
			System.out.println("[Error] : update");
			e.printStackTrace();
		}
		// try - catch는 반드시 필요한 건 아니고, 에러 났을 때 catch로 처리하려고 작성한 것이다.
		System.out.println("에러 체크용2");
		return res;
	}
	@Override
	public int delete(int myno) {
		
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE + "delete", myno);
		} catch(Exception e) {
			System.out.println("[Error] : delete");
			e.printStackTrace();
		}
		
		return res;
	}

}
