-- 코드를 입력하세요
SELECT CAR_TYPE, count(*) as CARS
from CAR_RENTAL_COMPANY_CAR
where OPTIONS LIKE '%통풍시트%' or
 OPTIONS LIKE '%열선시트%' or
 OPTIONS LIKE '%가죽시트%'
group by CAR_TYPE
order by CAR_TYPE;

-- '통풍시트', '열선시트', '가죽시트' 중 하나 이상의 옵션이 포함된 자동차가 자동차 종류 별로 몇 대인지 출력
-- 자동차 수에 대한 컬럼명은 CARS
-- 결과는 자동차 종류를 기준으로 오름차순 정렬