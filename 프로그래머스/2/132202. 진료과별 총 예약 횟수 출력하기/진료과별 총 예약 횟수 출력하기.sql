-- 코드를 입력하세요

-- 2022년 5월에 예약한 환자 수를
-- 진료과코드 별로 조회
-- 컬럼명은 '진료과 코드', '5월예약건수'
-- 진료과별 예약한 환자 수를 기준으로 오름차순 정렬 -> 예약한 환자 수가 같다면 진료과 코드를 기준으로 오름차순 정렬

select MCDP_CD as '진료과 코드', count(*) as '5월예약건수'
from APPOINTMENT
where APNT_YMD like '2022-05%'
group by MCDP_CD
order by count(*), PT_NO;