-- 코드를 입력하세요
SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE JOINED LIKE '2021%' AND (AGE >= 20 AND AGE <= 29);

-- 2021년에 가입한 회원 중 
-- 나이가 20세 이상 29세 이하인 회원이 
-- 몇 명인지 출력

select count(*) as USERS
from USER_INFO
where AGE >= 20 and AGE <= 29 and YEAR(JOINED) = 2021;