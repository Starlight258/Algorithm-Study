-- 코드를 입력하세요
# SELECT outs.ANIMAL_ID, outs.NAME
# FROM ANIMAL_OUTS outs
# LEFT JOIN ANIMAL_INS ins ON outs.ANIMAL_ID = ins.ANIMAL_ID
# where ins.ANIMAL_ID IS NULL
# ORDER BY outs.ANIMAL_ID;

-- 입양은 갔지만, 보호소에 들어온 기록이 없는 동물의 id와 이름
-- select animal_id, name
-- from animal_outs as out
-- left join animal_ins as ins on out.animal_id = ins.animal_id
-- where ins.animal_id is null
-- id 순으로 조회

-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물
-- ID와 이름
-- ID 순으로 조회

select aouts.ANIMAL_ID, aouts.NAME
from ANIMAL_OUTS aouts
left join ANIMAL_INS ains on ains.ANIMAL_ID = aouts.ANIMAL_ID
where ains.ANIMAL_ID IS NULL
order by aouts.ANIMAL_ID;