package com.mvc.upgrade.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.upgrade.model.dao.BoardDao;
import com.mvc.upgrade.model.dto.BoardDto;

@Service
public class BoardBizImpl implements BoardBiz {
	@Autowired
	private BoardDao dao;
	
	@Override
	public List<BoardDto> selectList() {
		return dao.selectList();
	}
	
	@Override
	public BoardDto selectOne(int myno) {
		return dao.selectOne(myno);
	}
	
	@Override
	public int insert(BoardDto dto) {
		return dao.insert(dto);
	}
	
	@Override
	public int update(BoardDto dto) {
		return dao.update(dto);
	}
	
	@Override
	public int delete(int myno) {
		return dao.delete(myno);
	}
	
	// 예외 강제 발생용 메소드
	@Transactional
	// @Transactional(rollbackFor = 예외 클래스명.class) 도 가능
	// 특정 예외 나오면 롤백하겠다라는 설정 가능하다.
	// 트랜잭션 설정
	// servlet-context.xml에서 Annotation 설정하고, 
	// applicationContext.xml에서 TransactionManager 객체(bean) 생성해야한다.
	// dao에서 sqlSession.rollback();은 안된다. MyBatis에서 안되도록 막아놨다.(에러 발생)
	// 예외 발생하면 이 메소드 내의 작업들 모두 롤백되어야한다.
	@Override
	public String test() {
		dao.insert(new BoardDto(0, "transaction", "test", "insert test transaction", null));
		String test = dao.test();
		
		// insert 후 예외 발생(NullPointer)
		test.length();
		// null.length();
		
		// 결론적으로 얘기하면 insert 후 null 포인터 예외나오고, insert 작업까지 rollback 되어야한다.
		
		return test;
	}

}
