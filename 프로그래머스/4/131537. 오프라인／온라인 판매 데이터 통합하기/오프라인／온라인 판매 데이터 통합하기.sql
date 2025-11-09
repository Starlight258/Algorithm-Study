-- 코드를 입력하세요
SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM ONLINE_SALE
WHERE SALES_DATE >= '2022-03-01' and SALES_DATE < '2022-04-01' 

UNION ALL

SELECT DATE_FORMAT(SALES_DATE, "%Y-%m-%d") AS SALES_DATE, PRODUCT_ID, NULL as USER_ID, SALES_AMOUNT
FROM OFFLINE_SALE
WHERE SALES_DATE >= '2022-03-01' and SALES_DATE < '2022-04-01' 

ORDER BY SALES_DATE ASC, PRODUCT_ID ASC, USER_ID ASC;

-- select sales_date, product_id, user_id, sales_amount
-- from online_sale
-- union all 
-- select sales_date, product_id, NULL as user_id, sales_amount
-- from offline_sale
-- order by sales_date asc, product_id asc, user_id asc

-- 2022년 3월의 판매날짜, 상품id, 유저id, 판매량 
-- offline sale user_id null
-- 판매일 기준으로 오름차순 정렬, 상품 id 오름차순 정렬, 유저 id 오름차순 정렬