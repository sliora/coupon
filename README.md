# 멀티모듈 선착순 쿠폰 시스템

## Background
한정된 수량의 쿠폰을 먼저 신청한 사용자에게 제공하는 프로젝트

## Architecture

## 비동기 쿠폰 발급 요청 처리 구조

image

## 캐시 데이터 기반 Validation

image

### Tech Stack
**Infra**  
Aws EC2, Aws RDS, Aws Elastic Cache,

**Server**  
Java 17, Spring Boot 3.1, Spring Mvc, JPA, QueryDsl

**Database**  
Mysql, Redis, H2

**Monitoring**   
Aws Cloud Watch, Spring Actuator, Promethous, Grafana

**Etc**  
Locust, Gradle, Docker

## Main Feature

### 쿠폰 발급 검증
- 발급 기한
- 발급 수량
- 중복 발급

### 쿠폰 발급 수량 관리
- Redis Set기반 재고 관리

### 비동기 쿠폰 발급
- Redis List (발급 Queue)
- Queue Polling Scheduler 