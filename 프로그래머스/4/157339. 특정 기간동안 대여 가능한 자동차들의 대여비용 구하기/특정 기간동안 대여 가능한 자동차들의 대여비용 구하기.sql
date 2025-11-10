-- 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중
--  2022년 11월 1일부터 2022년 11월 30일까지 대여 가능
-- 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차
--  자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력

-- 대여 금액을 기준으로 내림차순 정렬 ->  대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬 ->  자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬

select cc.CAR_ID, cc.CAR_TYPE, FLOOR(cc.DAILY_FEE * (100 - cp.DISCOUNT_RATE) / 100 * 30) AS FEE
from CAR_RENTAL_COMPANY_CAR cc
join CAR_RENTAL_COMPANY_RENTAL_HISTORY ch on cc.CAR_ID = ch.CAR_ID
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN cp on cc.CAR_TYPE = cp.CAR_TYPE
where cc.CAR_TYPE IN ('세단', 'SUV') and
cc.CAR_ID NOT IN (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE <= '2022-11-30' and END_DATE >= '2022-11-01'
) and DURATION_TYPE = '30일 이상'
-- 2022-11-01~2022-11-30
group by cc.CAR_ID
HAVING FEE >= 500000 and FEE < 2000000
order by FEE desc, cc.CAR_TYPE asc, cc.CAR_ID desc;