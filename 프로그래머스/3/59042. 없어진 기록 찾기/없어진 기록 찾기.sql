-- 코드를 입력하세요
SELECT outs.ANIMAL_ID, outs.NAME
FROM ANIMAL_OUTS as outs
LEFT JOIN ANIMAL_INS as ins ON outs.ANIMAL_ID = ins.ANIMAL_ID
where ins.ANIMAL_TYPE IS NULL
ORDER BY outs.ANIMAL_ID ASC;

-- 입양은 갔지만, 보호소에 들어온 기록이 없는 동물의 id와 이름
-- select animal_id, name
-- from animal_outs as out
-- left join animal_ins as ins on out.animal_id = ins.animal_id
-- where ins.animal_id is null
-- id 순으로 조회
