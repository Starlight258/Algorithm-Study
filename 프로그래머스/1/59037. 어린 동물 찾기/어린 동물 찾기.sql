# SELECT ANIMAL_ID, NAME
# FROM ANIMAL_INS
# WHERE INTAKE_CONDITION NOT IN ('Aged')
# ORDER BY ANIMAL_ID;

--  젊은 동물1의 아이디와 이름을 조회
-- INTAKE_CONDITION이 Aged가 아닌 경우를 뜻함 ↩
-- 결과는 아이디 순으로 조회

select ANIMAL_ID, NAME
from ANIMAL_INS
where INTAKE_CONDITION <> 'Aged'
order by ANIMAL_ID;