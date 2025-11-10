# WITH RECURSIVE hours AS (
#     SELECT 0 AS h
#     UNION ALL
#     SELECT h + 1
#     FROM hours
#     WHERE h < 23
# )
# SELECT 
#     hours.h AS HOUR,
#     COALESCE(COUNT(AO.ANIMAL_ID), 0) AS COUNT
# FROM hours
# LEFT JOIN ANIMAL_OUTS AO
#     ON hours.h = HOUR(AO.DATETIME)
# GROUP BY hours.h
# ORDER BY hours.h;

-- . 0시부터 23시까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회
--  시간대 순으로 정렬
with recursive hours as(
    select 0 as h
    union all
    select h+1
    from hours
    where h < 23
)
select hours.h AS HOUR, count(ANIMAL_ID) as COUNT
from hours
left join ANIMAL_OUTS ao on HOUR(DATETIME) = hours.h
group by HOUR
order by HOUR