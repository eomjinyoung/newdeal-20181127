package com.eomcs.lms.dao;

import java.util.List;
import java.util.Map;

public interface LessonDao {
  List<Map<String,Object>> findByParticipantNo(int memberNo);
}
