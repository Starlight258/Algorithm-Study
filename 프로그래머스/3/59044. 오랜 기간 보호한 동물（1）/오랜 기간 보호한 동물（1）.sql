-- 코드를 입력하세요
SELECT ins.NAME, ins.DATETIME
FROM ANIMAL_INS ins
LEFT JOIN ANIMAL_OUTS outs ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE outs.ANIMAL_ID IS NULL
ORDER BY ins.DATETIME
LIMIT 3;

-- 아직 입양을 못 간 동물들 : ins에는 있지만 outs에는 없는 동물
-- select name, datetime
-- from animal_ins
-- left join animal_outs on ins.animal_id = outs.animal_id
-- where outs.animal_id is null
-- order by datetime desc
-- limit 3
-- 가장 오래 보호소에 있었던 동물 desc datetime
-- 3마리 (limit)
-- 