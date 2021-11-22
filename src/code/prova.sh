#!/bin/bash
cd $1
cnt=0
for f in *;do
	if test -f $f;then
		a=$(wc -l <$f)
		#echo nel file $f ci sono $a linee
		cnt=$(expr $a + $cnt)
		#echo $cnt
	fi
done
echo $cnt >> $2
echo "nella cartella $1 ci sono $cnt linee"
