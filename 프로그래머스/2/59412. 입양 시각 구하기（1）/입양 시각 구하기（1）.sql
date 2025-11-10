-- 코드를 입력하세요
# SELECT HOUR(outs.DATETIME) AS HOUR, COUNT(*) AS COUNT
# FROM ANIMAL_OUTS outs
# WHERE HOUR(DATETIME) BETWEEN 9 AND 19
# GROUP BY HOUR(outs.DATETIME) 
# ORDER BY HOUR;


-- timestampdiff
-- ins - datetime
-- count(*)
-- 09:00 ~ 19:59
-- 각 시간대별로 : order by

-- 09:00부터 19:59까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문
-- 결과는 시간대 순으로 정렬
select HOUR(DATETIME) as HOUR, count(*) as COUNT
from ANIMAL_OUTS
where HOUR(DATETIME) >= 9 and HOUR(DATETIME) < 20
group by HOUR
order by HOUR