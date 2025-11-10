-- 코드를 입력하세요
# SELECT USER_ID, PRODUCT_ID
# FROM ONLINE_SALE 
# GROUP BY USER_ID, PRODUCT_ID
# HAVING COUNT(*)>=2
# ORDER BY USER_ID ASC, PRODUCT_ID DESC;

--  동일한 회원이 동일한 상품을 재구매한 데이터
-- 재구매한 회원 ID와 재구매한 상품 ID를 출력
-- 결과는 회원 ID를 기준으로 오름차순 정렬 -> 상품 ID를 기준으로 내림차순 정렬
-- 동일한 날짜, 회원 ID, 상품 ID 조합에 대해서는 하나의 판매 데이터만 존재

select USER_ID, PRODUCT_ID
from ONLINE_SALE
group by USER_ID, PRODUCT_ID
having count(*) >=2
order by USER_ID asc, PRODUCT_ID desc;

