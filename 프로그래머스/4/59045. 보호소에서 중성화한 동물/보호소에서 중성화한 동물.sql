-- 코드를 입력하세요
SELECT o.ANIMAL_ID, o.ANIMAL_TYPE, o.NAME
FROM ANIMAL_OUTS AS o
JOIN ANIMAL_INS  AS i
  ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE i.SEX_UPON_INTAKE  LIKE 'Intact%'
  AND (o.SEX_UPON_OUTCOME LIKE 'Spayed%' OR o.SEX_UPON_OUTCOME LIKE 'Neutered%')
ORDER BY o.ANIMAL_ID;

-- in : 중성화 X -> out : 중성화된 동물
-- select id, animal_type, name
-- from ins ins
-- join outs outs on ins.id = outs.id
-- where ins.SEX_UPON_INTAKE <> 'Intact' and outs.SEX_UPON_INTAKE = 'Intact'
-- Intact