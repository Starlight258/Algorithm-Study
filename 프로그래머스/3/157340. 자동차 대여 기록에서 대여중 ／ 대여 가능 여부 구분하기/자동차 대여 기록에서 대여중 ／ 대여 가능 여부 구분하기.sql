-- 코드를 입력하세요
SELECT CAR_ID, 
CASE WHEN CAR_ID
IN (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE <= '2022-10-16' and '2022-10-16' <= END_DATE
) THEN '대여중'
ELSE '대여 가능' END
as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
order by CAR_ID desc;

--  2022년 10월 16일에 대여 중인 자동차인 경우 '대여중' 이라고 표시
--  대여 중이지 않은 자동차인 경우 '대여 가능'을 표시하는 컬럼 : AVAILABILITY
--  자동차 ID와 AVAILABILITY 리스트를 출력
-- 반납 날짜가 2022년 10월 16일인 경우에도 '대여중'으로 표시
-- 자동차 ID를 기준으로 내림차순 정렬