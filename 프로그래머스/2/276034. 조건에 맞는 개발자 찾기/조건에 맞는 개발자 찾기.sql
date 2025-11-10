-- 코드를 작성해주세요

-- DEVELOPERS 테이블에서 Python이나 C# 스킬을 가진 개발자의 정보를 조회
--  조건에 맞는 개발자의 ID, 이메일, 이름, 성을 조회하는 SQL 문

select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS d
where d.SKILL_CODE & (
    select sum(CODE)
    from SKILLCODES
    where NAME = 'Python'
) >0 OR d.SKILL_CODE & (
    select sum(CODE) 
    from SKILLCODES
    where NAME = 'C#'
) >0
order by ID;