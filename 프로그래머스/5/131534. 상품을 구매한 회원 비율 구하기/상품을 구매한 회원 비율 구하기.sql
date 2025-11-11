-- 코드를 입력하세요

--  2021년에 가입한 전체 회원들 
--  상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)을 년, 월 별로 출력
-- 상품을 구매한 회원의 비율은 소수점 두번째자리에서 반올림
-- 전체 결과는 년을 기준으로 오름차순 정렬 -> 월을 기준으로 오름차순 정렬
select YEAR(SALES_DATE), MONTH(SALES_DATE), count(DISTINCT(u.USER_ID)) as PURCHASED_USERS, ROUND(count(DISTINCT(u.USER_ID)) /
(select count(DISTINCT(u.USER_ID))
from USER_INFO u
 where YEAR(JOINED) = 2021 
), 1) as PUCHASED_RATIO
from USER_INFO u
join ONLINE_SALE s on u.USER_ID = s.USER_ID
where YEAR(JOINED) = 2021 
group by YEAR(SALES_DATE), MONTH(SALES_DATE)