package com.eomcs.lms.dao.impl;

import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

//Spring IoC 컨테이너가 이 클래스의 인스턴스를 자동 생성하도록 
//클래스에 표시해 둔다.
@Component
public class MariaDBMemberDao implements MemberDao {
  
  SqlSessionFactory sqlSessionFactory;
  
  public MariaDBMemberDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  @Override
  public Member findByEmailPassword(String email, String password) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      
      HashMap<String,Object> params = new HashMap<>();
      params.put("email", email);
      params.put("password", password);
      
      return sqlSession.selectOne(
          "MemberDao.findByEmailPassword", params);
    }
  }

}






