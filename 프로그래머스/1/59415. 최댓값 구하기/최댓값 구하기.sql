-- 코드를 입력하세요

-- 가장 최근에 들어온 동물은 언제 들어왔는지 조회
select DATETIME
from ANIMAL_INS
where DATETIME  = (
    select MAX(DATETIME)
    from ANIMAL_INS
)