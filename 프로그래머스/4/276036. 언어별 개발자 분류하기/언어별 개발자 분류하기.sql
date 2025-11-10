-- 코드를 작성해주세요

# SELECT(
#     CASE WHEN SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End')
#     AND SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'Python') THEN 'A'
#     WHEN SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#') THEN 'B'
#     WHEN SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End') THEN 'C'
#     ELSE NULL END) as GRADE, ID, EMAIL
# FROM DEVELOPERS
# GROUP BY GRADE, ID, EMAIL
# HAVING GRADE IS NOT NULL
# ORDER BY GRADE, ID

-- grade별 개발자의 정보
-- A: front end + python
-- B : C#
-- C : 그 외

-- 400 = 256 + 128 + 16
-- select grade, id ,email, grade
-- from developers d
-- join skillCodes jc on jc.skill_code = d.code
-- group by d
-- group by (, B, C)
-- order by grade, id

-- GRADE별 개발자의 정보를 조회
--  GRADE, ID, EMAIL
select CASE 
WHEN d.SKILL_CODE & (select SUM(CODE) from SKILLCODES
                    where CATEGORY = 'Front End') >0 and
d.SKILL_CODE & (select SUM(CODE) from SKILLCODES
                    where NAME = 'Python') >0                  
THEN 'A'
WHEN d.SKILL_CODE & (select SUM(CODE) from SKILLCODES
                    where NAME ='C#') >0
THEN 'B'
WHEN d.SKILL_CODE & (select SUM(code) from SKILLCODES where CATEGORY = 'Front End') THEN 'C'
ELSE NULL END
as GRADE
, ID, EMAIL
from DEVELOPERS d
group by GRADE, ID, EMAIL
having GRADE IS NOT NULL
order by GRADE, ID;
