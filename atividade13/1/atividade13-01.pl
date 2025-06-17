pai(ivo, eva).
pai(ivo, adao).

mae(ana, eva).
mae(ana, adao).

homem(ivo).
homem(adao).

mulher(ana).
mulher(eva).

gerou(X, Y) :- pai(X, Y).
gerou(X, Y) :- mae(X, Y).

feliz(X) :- gerou(X, _).

casal(X, Y) :- 
    gerou(X, F),
    gerou(Y, F),
    X \= Y.

