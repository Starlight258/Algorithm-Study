-- 코드를 입력하세요
SELECT PRODUCT_CODE, SUM(p.PRICE * os.SALES_AMOUNT) as SALES
from PRODUCT p
join OFFLINE_SALE os on p.PRODUCT_ID = os.PRODUCT_ID
group by PRODUCT_CODE
order by SALES desc, PRODUCT_CODE asc;

--  상품코드 별 매출액(판매가 * 판매량) 합계를 출력
-- 매출액을 기준으로 내림차순 정렬
-- 매출액이 같다면 상품코드를 기준으로 오름차순 정렬