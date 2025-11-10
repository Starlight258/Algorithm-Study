-- 코드를 입력하세요

-- FOOD_PRODUCT와 FOOD_ORDER 테이블에서 생산일자가 2022년 5월인 식품들
-- 식품 ID, 식품 이름, 총매출을 조회하
--  총매출을 기준으로 내림차순 정렬 -> 총매출이 같다면 식품 ID를 기준으로 오름차순 정렬

select f.PRODUCT_ID, f.PRODUCT_NAME, SUM(f.PRICE * o.AMOUNT) as TOTAL_SALES
from FOOD_PRODUCT f
join FOOD_ORDER o on f.PRODUCT_ID = o.PRODUCT_ID
where o.PRODUCE_DATE like '2022-05%'
group by f.PRODUCT_ID
order by TOTAL_SALES desc, f.PRODUCT_ID;
