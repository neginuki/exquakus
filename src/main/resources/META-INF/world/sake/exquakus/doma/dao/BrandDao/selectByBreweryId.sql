select 
  brand./*%expand*/* 
from 
  brewery brewery,
  brand brand  
where
  brewery.brewery_id = brand.brewery_id
    and
  brewery.brewery_id = /*breweryId*/1
