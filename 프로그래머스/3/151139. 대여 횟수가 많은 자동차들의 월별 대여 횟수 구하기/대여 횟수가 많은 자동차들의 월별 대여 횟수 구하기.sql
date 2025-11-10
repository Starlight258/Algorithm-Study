-- 코드를 입력하세요
select MONTH(START_DATE) AS MONTH, CAR_ID, count(HISTORY_ID) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where CAR_ID IN (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE >='2022-08-01' and  START_DATE <'2022-11-01'
    group by CAR_ID
    having count(HISTORY_ID)>=5
) and START_DATE >='2022-08-01' and  START_DATE <'2022-11-01'
group by MONTH(START_DATE), CAR_ID
having count(HISTORY_ID)>0
order by MONTH(START_DATE) asc, CAR_ID desc;

-- 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차들
-- 해당 기간 동안의 월별 자동차 ID 별 총 대여 횟수(컬럼명: RECORDS) 리스트를 출력
-- 월을 기준으로 오름차순 정렬 -> 월이 같다면 자동차 ID를 기준으로 내림차순 정렬
-- 특정 월의 총 대여 횟수가 0인 경우에는 결과에서 제외

-- 기간 총 대여횟수 >=5, 월별 대여횟수