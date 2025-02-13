package com.kh.mybatis.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTemplate {
/*
 * *기존 JDBC 탬플릿
 * public static Connection getConnection(){
 *    //driver.properties 파일을 읽어서
 *    //해당 DB와 관련된 Connection 객체를 생성 후 반환
 *     }
 *     
 * public static void close(JDBC 용 객체){
 *  // 전달받은 객체를 반납(close)
 *  }
 *  
 * public static void commit|rollback(Connection 객체){
 * //트랜잭션 처리
 * } 
 * 
 */
	//마이바티스 탬플릿
	public static SqlSession getSqlSession() {
		//mybatis-config.xml 파일을 읽어서
		//해당 DB와 접속된 SqlSession 객체를 생성 후 반환
		SqlSession sqlSession = null;
		
		//SqlSession 객체를 생성하기 위해서 SqlSessionFactory 객체 필요
		//SqlSessionFactory 객체를 생성하기 위해서 SqlSessionFactoryBuilder 객체 필요
		String resources = "/mybatis-config.xml";
		
		try {
			InputStream stream = Resources.getResourceAsStream(resources);
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(stream);
			sqlSession = ssf.openSession(false);
			//openSession() : 기본값 false
			//openSession(boolean) : auto commit 설정(true: 자동 커밋 , false: 수동 커밋)
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlSession;
	}
	
	
}
