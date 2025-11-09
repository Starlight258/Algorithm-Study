-- 코드를 입력하세요
SELECT a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(bs.SALES * b.PRICE) as TOTAL_SALES
FROM BOOK b
JOIN AUTHOR a ON b.AUTHOR_ID = a.AUTHOR_ID
JOIN BOOK_SALES bs ON b.BOOK_ID = bs.BOOK_ID 
WHERE bs.SALES_DATE >= '2022-01-01' and bs.SALES_DATE < '2022-02-01'
GROUP BY a.AUTHOR_ID, b.CATEGORY
ORDER BY a.AUTHOR_ID ASC, b.CATEGORY DESC;

-- select a.author_id, a.author_name, b.category, sum(bs.sales * b.price) as total_sales
-- from book as b
-- join author a on b.author_id = a.author_id
-- join book sales bs on bs.book_id = b.book_id
-- where book bs.sales_date >= '2022-01-01' and bs.sales_date > '2022-02-01'
-- group by a.author_id, a.author_name, b.category
-- order by a.author_id asc, b.category desc
-- 판매량 * 판매가
-- sales * price 
-- 저자별, 카테고리별