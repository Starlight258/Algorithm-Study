-- 코드를 입력하세요
SELECT ID, NAME, HOST_ID
FROM PLACES
WHERE HOST_ID IN (
    SELECT HOST_ID
    FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(*) >=2
)
ORDER BY ID;

-- 헤비 유저 : 공간을 둘 이상 등록한 사람
-- 아이디 순으로 조회 

-- select id, name, host_id
-- from places
-- group by host_id
-- having count(id) >=2
-- order by id;