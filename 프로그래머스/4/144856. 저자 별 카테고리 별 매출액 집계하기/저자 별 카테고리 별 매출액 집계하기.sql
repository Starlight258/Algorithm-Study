-- 코드를 입력하세요
# SELECT a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(bs.SALES * b.PRICE) as TOTAL_SALES
# FROM BOOK b
# JOIN AUTHOR a ON b.AUTHOR_ID = a.AUTHOR_ID
# JOIN BOOK_SALES bs ON b.BOOK_ID = bs.BOOK_ID 
# WHERE bs.SALES_DATE >= '2022-01-01' and bs.SALES_DATE < '2022-02-01'
# GROUP BY a.AUTHOR_ID, b.CATEGORY
# ORDER BY a.AUTHOR_ID ASC, b.CATEGORY DESC;

-- 2022년 1월의 도서 판매 데이터를 기준으로 
-- 저자 별, 카테고리 별 매출액(TOTAL_SALES = 판매량 * 판매가) 
-- 저자 ID(AUTHOR_ID), 저자명(AUTHOR_NAME), 카테고리(CATEGORY), 매출액(SALES) 리스트를 출력
-- 저자 ID를 오름차순으로, 저자 ID가 같다면 카테고리를 내림차순 정렬

select a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(bs.SALES * b.PRICE ) as TOTAL_SALES
from BOOK b
join AUTHOR a on b.AUTHOR_ID = a.AUTHOR_ID
join BOOK_SALES bs on b.BOOK_ID = bs.BOOK_ID
where bs.SALES_DATE like '2022-01%'
group by a.AUTHOR_ID, b.CATEGORY
order by a.AUTHOR_ID asc, b.CATEGORY desc;

