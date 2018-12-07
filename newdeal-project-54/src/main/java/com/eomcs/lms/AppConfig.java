package com.eomcs.lms;

import java.util.Scanner;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

// Spring IoC 컨테이너에게 패키지 이름을 알려주면 
// 그 패키지를 뒤져서 @Component가 붙은 클래스에 대해 
// 인스턴스를 자동으로 생성해준다.
@ComponentScan("com.eomcs.lms")

// Spring IoC 컨테이너에게 프로퍼티 파일을 로딩할 것을 명령한다.
@PropertySource("classpath:/com/eomcs/lms/conf/jdbc.properties")

// MyBatis의 DAO 인터페이스 구현체를 자동 생성하는 도우미를 추가한다.
// => DAO 인터페이스가 들어있는 패키지를 지정한다.
// => 자동 생성된 DAO 구현체가 SQL을 찾을 때 
//    인터페이스의 전체 이름으로 찾는다.
//    따라서 SQL 매퍼 파일의 namespace 이름은 인터페이스의 전체 이름과 
//    같아야 한다.
// => 인터페이스의 메서드 이름, 파라미터, 리턴 타입이
//    SQL 매퍼의 아이디, 파라미터, 리턴 타입과 같아야 한다.
@MapperScan("com.eomcs.lms.dao")
public class AppConfig {
  
  // Spring IoC 컨테이너가 로딩한 프로퍼티 정보를 가져오기
  //=> "야! 스프링 IoC 컨테이너. 로딩한 프로퍼티 값 중에서 
  //    jdbc.driver 라는 이름을 가진 값을 꺼내 
  //    jdbcDriver 변수에 넣어줘!"
  @Value("${jdbc.driver}")
  String jdbcDriver;
  
  @Value("${jdbc.url}")
  String jdbcUrl;
  
  @Value("${jdbc.username}")
  String jdbcUsername;
  
  @Value("${jdbc.password}")
  String jdbcPassword;
  
  @Bean
  public DataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(this.jdbcDriver);
    dataSource.setUrl(this.jdbcUrl);
    dataSource.setUsername(this.jdbcUsername);
    dataSource.setPassword(this.jdbcPassword);
    return dataSource;
  }
  
  // 트랜잭션 객체를 생성할 때 
  // 기본 이름으로 transactionManager라고 설정하라.
  // 다른 이름으로 설정하면 
  // 트랜잭션 관련하여 다른 객체를 생성할 때 
  // 그 객체가 트랜잭션 관리자를 자동으로 찾지 못한다.
  public PlatformTransactionManager transactionManager(
      DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }
  
  @Bean
  public SqlSessionFactory sqlSessionFactory(
      DataSource dataSource, 
      ApplicationContext iocContainer) throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    
    // DataSource(DB 커넥션풀) 객체 주입
    factoryBean.setDataSource(dataSource);
    
    // Domain 클래스(VO;Value Object)의 별명 자동 생성하기
    factoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");
    
    // SQL 매퍼 파일 로딩
    // => SQL 매퍼 파일의 위치 정보를 Resource 객체에 담아서 넘겨야 한다.
    // => Resource 객체는 Spring IoC 컨테이너를 통해 만들 수 있다.
    // => Spring IoC 컨테이너 객체를 얻는 방법
    //    이 메서드의 파라미터에 달라고 요청하라! 
    factoryBean.setMapperLocations(iocContainer.getResources(
            "classpath:/com/eomcs/lms/mapper/*Mapper.xml"));
    
    return factoryBean.getObject();
  }
  
  
  @Bean
  public Scanner keyboard() {
    return new Scanner(System.in);
  }
}





