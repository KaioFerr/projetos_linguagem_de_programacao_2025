area :: Float -> Float
area raio = pi * (raio^2)

juros :: Float -> Float -> Float -> Float
juros valor tempo taxa = valor*(1 + taxa)*tempo

maior :: Float -> Float -> Float
maior val1 val2 = max val1 val2

condicao :: Float -> Int 
condicao val
        | val > 0 = 1
        | val < 0 = -1
        | otherwise = 0

raizes :: Float -> Float -> Float -> (Float, Float)
raizes a b c
  | delta < 0  = error "Nao existem raizes reais"
  | otherwise  = ((-b + raiz) / (2*a), (-b - raiz) / (2*a))
  where
    delta = b^2 - 4*a*c
    raiz  = sqrt delta

mdc :: Int -> Int -> Int
mdc a 0 = a
mdc a b = mdc b (a `mod` b)

fibonacci :: Int -> Int
fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n = fibonacci (n-1) + fibonacci (n-2)

somaLista :: [Int] -> Int
somaLista []    = 0       
somaLista (a:x) = a + somaLista x 

menorElemento :: [Int] -> Int
menorElemento []     = error "Lista vazia não possui menor elemento"
menorElemento [x]    = x
menorElemento (a:x)  = mini a (menorElemento x)
  where
    mini m n          
      | m <= n    = m
      | otherwise = n

indices :: Int -> [Int]
indices n = [0 .. n]

fibonacciSequencia :: Int -> [Int]
fibonacciSequencia n = map fibonacci (indices n)

meuElem :: (Eq a) => a -> [a] -> Bool
meuElem x []     = False
meuElem x (y:ys) = x == y || meuElem x ys

sort :: Ord t => [t] -> [t]
sort [] = []
sort (a:b) = sort [x | x <- b, x < a]
             ++ [a]
             ++ sort [x | x <- b, x >= a]

intercalaListas :: [a] -> [a] -> [a]
intercalaListas [] [] = []
intercalaListas (a:x) [] = a : intercalaListas x []
intercalaListas [] (b:y) = b : intercalaListas [] y
intercalaListas (a:x) (b:y) = a : b : intercalaListas x y