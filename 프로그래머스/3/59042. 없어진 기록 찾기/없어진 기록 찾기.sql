#나간 기록은 있고 들어온 기록이 없는 데이터들 찾기
select o.animal_id, o.name from animal_outs o
left outer join animal_ins i on o.animal_id = i.animal_id
where i.animal_id is null
order by o.animal_id;