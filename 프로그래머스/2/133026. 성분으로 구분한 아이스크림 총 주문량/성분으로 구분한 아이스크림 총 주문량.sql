-- 코드를 입력하세요

-- 상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량을 총주문량이 작은 순서대로 조회하는 SQL 문
-- 총주문량을 나타내는 컬럼명은 TOTAL_ORDER

select ii.INGREDIENT_TYPE, SUM(TOTAL_ORDER) as TOTAL_ORDER
from FIRST_HALF fh
join ICECREAM_INFO ii on fh.FLAVOR = ii.FLAVOR
group by ii.INGREDIENT_TYPE
order by TOTAL_ORDER;