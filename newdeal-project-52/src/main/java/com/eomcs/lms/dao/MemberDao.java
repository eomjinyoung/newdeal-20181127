package com.eomcs.lms.dao;

import java.util.Map;
import com.eomcs.lms.domain.Member;

public interface MemberDao {
  Member findByEmailPassword(Map<String, Object> params) 
      throws Exception;
}
