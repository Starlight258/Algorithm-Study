-- 코드를 입력하세요

--  년, 월, 성별 별로 상품을 구매한 회원수를 집계
-- . 결과는 년, 월, 성별을 기준으로 오름차순 정렬
-- 성별 정보가 없는 경우 결과에서 제외
select YEAR(SALES_DATE) as YEAR, MONTH(SALES_DATE) as MONTH, GENDER, count(DISTINCT(ui.USER_ID)) as USERS
from USER_INFO ui
join ONLINE_SALE us on ui.USER_ID = us.USER_ID
where GENDER IS NOT NULL
group by YEAR, MONTH, GENDER
order by YEAR, MONTH, GENDER;