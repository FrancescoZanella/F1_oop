#!/bin/bash

for d in *;do
	if test -d $d;then
		./prova.sh $d $(pwd)/nomi
	fi
done

a=0
for l in $(cat $(pwd)/nomi);do
	#echo $l
	a=$(expr $a + $l)
done
>$(pwd)/nomi
echo ci sono $a linee


