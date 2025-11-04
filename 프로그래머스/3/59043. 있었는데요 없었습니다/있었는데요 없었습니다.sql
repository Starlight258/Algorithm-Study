-- 코드를 입력하세요
SELECT ins.ANIMAL_ID, ins.NAME
FROM ANIMAL_INS ins
JOIN ANIMAL_OUTS outs ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE outs.DATETIME < ins.DATETIME
ORDER BY ins.DATETIME ASC;

-- 아이디와 이름 조회
-- 입양일 < 보호 시작일
-- select animal_id, name
-- from animal_ins ins
-- join animal_outs outs on ins.animal_id = outs.animal_id
-- where outs.datetime < ins.datetime
-- order by outs.datetime
-- 보호 시작일이 빠른 순으로 조회