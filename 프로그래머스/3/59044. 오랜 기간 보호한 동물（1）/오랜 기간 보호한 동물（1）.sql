# SELECT ins.NAME, ins.DATETIME
# FROM ANIMAL_INS ins
# WHERE NOT EXISTS (
#     SELECT 1
#     FROM ANIMAL_OUTS outs
#     WHERE ins.ANIMAL_ID = outs.ANIMAL_ID
# )
# ORDER BY ins.DATETIME
# LIMIT 3;

-- 아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리
-- 이름과 보호 시작일을 조회

select ains.NAME, ains.DATETIME
from ANIMAL_INS ains
left join ANIMAL_OUTS outs on ains.ANIMAL_ID = outs.ANIMAL_ID
where outs.DATETIME IS NULL
order by ains.DATETIME
limit 3;