package com.eomcs.lms.dao.impl;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.LessonDao;

@Component
public class MariaDBLessonDao implements LessonDao {
  SqlSessionFactory sqlSessionFactory;
  
  public MariaDBLessonDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Map<String, Object>> findByParticipantNo(int memberNo) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      return sqlSession.selectList(
          "LessonDao.findByParticipantNo", memberNo);
    }
  }
}





