-- 코드를 입력하세요

-- 상위 3개의 맛을 조회
-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 

select FLAVOR
from (
    select *
    from FIRST_HALF
    union all
    select * 
    from JULY
) as A
group by FLAVOR
order by SUM(TOTAL_ORDER) desc
limit 3;