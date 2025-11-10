-- 코드를 입력하세요

--  중고 거래 게시판 정보를 담은 USED_GOODS_BOARD
-- USED_GOODS_USER

-- 완료된 중고 거래의 총금액이 70만 원 이상인 사람
-- 회원 ID, 닉네임, 총거래금액을 조회
-- 총거래금액을 기준으로 오름차순 정렬

select USER_ID, NICKNAME, SUM(PRICE) as TOTAL_SALES
from USED_GOODS_BOARD ug
join USED_GOODS_USER uu on ug.WRITER_ID = uu.USER_ID
where ug.STATUS = 'DONE'
group by USER_ID
having SUM(PRICE) >= 700000
order by TOTAL_SALES;
