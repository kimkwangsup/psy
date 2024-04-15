package com.human.psy.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.human.psy.vo.MemberVO;

public class MemberDao {
	@Autowired
	SqlSessionTemplate session;
	public int getLogin(MemberVO mVO) {
		return session.selectOne("mSQL.login", mVO);
	}
	public int joinProc(MemberVO mVO) {
		return session.insert("mSQL.join", mVO);
	}
}
