# SELECT NAME
# FROM ANIMAL_INS
# WHERE DATETIME = (SELECT MIN(DATETIME) FROM ANIMAL_INS);

select NAME
from ANIMAL_INS
order by DATETIME 
limit 1;

-- 동물 보호소에 가장 먼저 들어온 동물의 이름