SELECT F.FLAVOR
FROM FIRST_HALF F, ICECREAM_INFO I
WHERE TOTAL_ORDER > 3000
    AND F.FLAVOR = I.FLAVOR
    AND I.INGREDIENT_TYPE = 'fruit_based'
ORDER BY F.TOTAL_ORDER DESC