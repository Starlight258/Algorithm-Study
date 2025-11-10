-- 코드를 입력하세요

-- '경제' 카테고리에 속하는 도서들
-- 도서 ID(BOOK_ID), 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트를 출력
-- 결과는 출판일을 기준으로 오름차순 정렬

select b.BOOK_ID, a.AUTHOR_NAME, DATE_FORMAT(b.PUBLISHED_DATE, "%Y-%m-%d") as PUBLISHED_DATE
from BOOK b
join AUTHOR a on b.AUTHOR_ID = a.AUTHOR_ID
where b.CATEGORY = '경제'
order by b.PUBLISHED_DATE;
