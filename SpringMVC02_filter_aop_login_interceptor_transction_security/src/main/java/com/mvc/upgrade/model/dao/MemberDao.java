package com.mvc.upgrade.model.dao;

import com.mvc.upgrade.model.dto.MemberDto;

public interface MemberDao {
	
	String NAMESPACE = "mymember.";
	// mapper에 namespace와 동일하게 작성한다. 매번 namespace명 작성할 수고를 덜기 위해서 여기에 변수에다 저장해 사용한다.
	
	public MemberDto login(MemberDto dto);
	public int insert(MemberDto dto);

}
