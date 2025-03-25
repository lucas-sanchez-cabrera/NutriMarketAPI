SELECT SUM(c.product_cant * p.precio_total) AS precio_total
FROM contenido_carrito c
JOIN carrito_personal p ON c.carrito_id = p.carrito_id
WHERE c.carrito_id = 3;