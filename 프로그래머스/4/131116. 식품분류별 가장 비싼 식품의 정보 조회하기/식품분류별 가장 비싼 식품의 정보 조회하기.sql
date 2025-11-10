-- 코드를 입력하세요
select CATEGORY, PRICE, PRODUCT_NAME
from FOOD_PRODUCT
where CATEGORY IN ('과자', '국', '김치', '식용유') and 
(CATEGORY, PRICE) IN (
    select CATEGORY, max(PRICE)
    from FOOD_PRODUCT
    group by CATEGORY
)
order by PRICE desc;


-- 식품분류별로 가격이 제일 비싼 식품의 분류, 가격, 이름을 조회하는 SQL문
-- 식품분류가 '과자', '국', '김치', '식용유'인 경우만 출력
-- 결과는 식품 가격을 기준으로 내림차순 정렬