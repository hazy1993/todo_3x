# todo_3x


[1].todoApi
할일을 등록하고 조회, 삭제하는 기능의 api

[2].소스 빌드 및 실행 방법 메뉴얼 (DB 스키마 및 기초데이터 백업파일 필수)

mysql 설치

use mysql -- 사용할 디비 생성

테이블 생성
CREATE TABLE todos (
id INT NOT NULL AUTO_INCREMENT,   -- 자동 증가 설정
title VARCHAR(255) NOT NULL,      -- title 컬럼
content VARCHAR(1000),            -- content 컬럼
exec_dt VARCHAR(8),               -- 실행일자 (YYYYMMDD 형식)
exec_yn VARCHAR(1) DEFAULT 'N',   -- 실행 여부 (기본 값 'Y')
insert_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 생성일자 (기본 값: 현재 시간)
update_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일자 (업데이트 시 현재 시간)
PRIMARY KEY (id)                  -- id를 Primary Key로 설정
);



2-1 설정 - 빌드,실행,배포 - 빌드도구 - gradle
    - 다음을 사용하여 빌드 및 실행 - intellij IDEA   
    - 다음을 사용하여 테스트 및 실행 - intellij IDEA
    - gradle VM SDK 17 설정
                 
2-2.프로젝트 구조 
    -프로젝트 프로젝트 설정 - sdk17세팅
    -플랫폼 설정 - sdk - 17 세팅

[3]라이브러리 설명
Spring Boot Starter Web
- Spring Boot 기반 웹 애플리케이션을 만들기 위한 필수 라이브러리
- 내장 Tomcat을 제공하고, RESTful API 구현을 쉽게 해줍니다.

MyBatis Spring Boot Starter
- MyBatis를 Spring Boot에서 편리하게 사용할 수 있도록 지원하는 라이브러리
- SQL Mapper 기반 ORM을 제공하여 복잡한 쿼리를 쉽게 다룰 사용.

MySQL Connector 
- MySQL 데이터베이스와 Java 애플리케이션을 연결하는 JDBC 드라이버.

Lombok (org.projectlombok:lombok)
- 반복되는 Getter, Setter, 생성자 코드를 자동 생성해주는 라이브러리
- @Data, @Getter, @Setter 등의 어노테이션을 활용하면 깔끔한 코드 사용가능.


[4].api 호출 테스트(postman)

todo 등록 - post
localhost:8081/todos 

{
"title": "test1"
,"content": "test1Content"
,"execDt":  "20240516"
}

todo 조회(list) - get
localhost:8081/todos 

todo 조회(id값) - get
localhost:8081/todos/{id}


todo 수정(id값) - put
localhost:8081/todos/{id}
{
"title": "수정"
,"content": "삭제"
,"execDt":  "20240518"
}
todo 삭제(id값) - delete
localhost:8081/todos/{id} 


localhost:8081/todos/search?변수=값
변수는 title, content 두가지(제목 내용)
