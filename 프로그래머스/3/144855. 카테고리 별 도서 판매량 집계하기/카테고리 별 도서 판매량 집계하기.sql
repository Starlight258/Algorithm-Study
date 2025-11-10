-- 코드를 입력하세요
# SELECT
#     b.CATEGORY,
#     SUM(s.SALES) AS TOTAL_SALES
# FROM BOOK b
# JOIN BOOK_SALES s
#   ON s.BOOK_ID = b.BOOK_ID
# WHERE s.SALES_DATE >= '2022-01-01'
#   AND s.SALES_DATE <  '2022-02-01'
# GROUP BY b.CATEGORY
# ORDER BY b.CATEGORY;

-- 카테고리별 도서 판매량 합산 SUM()
-- 카테고리명 기준 오름차순 정렬

-- 2022년 1월의 카테고리 별 도서 판매량을 합산
-- 카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력
select b.CATEGORY, sum(bs.SALES) as TOTAL_SALES
from BOOK b
join BOOK_SALES bs on b.BOOK_ID = bs.BOOK_ID
where bs.SALES_DATE like '2022-01%'
group by b.CATEGORY
order by b.CATEGORY