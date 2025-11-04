-- 코드를 입력하세요
SELECT ins.ANIMAL_ID, ins.NAME
FROM ANIMAL_INS ins
JOIN ANIMAL_OUTS outs ON ins.ANIMAL_ID = outs.ANIMAL_ID
ORDER BY TIMESTAMPDIFF(DAY, ins.DATETIME, outs.DATETIME) DESC
LIMIT 2;

-- 보호기간이 가장 길었던 동물 두 마리의 아이디와 이름
-- 보호 기간이 긴 순으로 조회

-- select id, name, TIMESTAMPDIFF(DAY, ins.datetime, outs.datetime) as stay_days
-- from animal_ins ins
-- join animal_outs outs on ins.animal_id = outs.animal_id
-- order by stay_days desc
-- limit 2

-- where ins.id IN (
-- select id 
-- from animal_outs outs
-- where MAX(outs.datetime - ins.datetime)
-- limit 2
-- )
-- or
-- join animal_outs outs on ins.animal_id = outs.animal_id
-- where MAX(outs.datetime - ins.datetime)
-- order by 
-- MAX(o)