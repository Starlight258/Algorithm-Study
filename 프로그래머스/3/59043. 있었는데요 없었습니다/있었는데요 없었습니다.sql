-- 코드를 입력하세요
# SELECT ins.ANIMAL_ID, ins.NAME
# FROM ANIMAL_INS ins
# WHERE EXISTS (
#     SELECT 1
#     FROM ANIMAL_OUTS outs 
#     WHERE ins.ANIMAL_ID = outs.ANIMAL_ID
#     AND outs.DATETIME < ins.DATETIME
# )
# ORDER BY ins.DATETIME ASC;

-- 보호 시작일보다 입양일이 더 빠른 동물
-- 아이디와 이름을 조회
--  보호 시작일이 빠른 순으로 조회

select ains.ANIMAL_ID, ains.NAME
from ANIMAL_INS ains
join ANIMAL_OUTS aouts on ains.ANIMAL_ID = aouts.ANIMAL_ID
where aouts.DATETIME < ains.DATETIME
order by ains.DATETIME;