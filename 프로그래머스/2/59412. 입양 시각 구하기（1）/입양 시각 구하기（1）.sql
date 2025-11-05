-- 코드를 입력하세요
SELECT HOUR(outs.DATETIME) AS HOUR, COUNT(*) AS COUNT
FROM ANIMAL_OUTS outs
WHERE HOUR(DATETIME) BETWEEN 9 AND 19
GROUP BY HOUR(outs.DATETIME) 
ORDER BY HOUR;


-- timestampdiff
-- ins - datetime
-- count(*)
-- 09:00 ~ 19:59
-- 각 시간대별로 : order by
