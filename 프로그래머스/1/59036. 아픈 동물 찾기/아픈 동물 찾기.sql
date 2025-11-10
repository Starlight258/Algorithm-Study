# SELECT ANIMAL_ID, NAME
# FROM ANIMAL_INS
# WHERE INTAKE_CONDITION LIKE 'Sick'
# ORDER BY ANIMAL_ID;

-- 동물 보호소에 들어온 동물 중 아픈 동물의 아이디와 이름
-- INTAKE_CONDITION = 'Sick'
-- 결과는 아이디 순으로 조회

select ANIMAL_ID, NAME
from ANIMAL_INS
where INTAKE_CONDITION = 'Sick'
order by ANIMAL_ID;
