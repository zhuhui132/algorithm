#!/usr/bin/env bash

# 给定一个文本文件 file.txt，请只打印这个文件中的第十行。


#tail -n +10表示从第10行开始输出  -n<行数> 显示的行数
tail -n+10 file.txt | head -n 1

#-n表示只输出匹配行，p表示Print
sed -n 10p file.txt

#awk 'NR == 10' file.txt NR在awk中指行号
awk 'NR==10' file.txt


#但是考虑到说明中行数不足10的情况处理，可以做如下处理：
# wc -l  统计行数利器（
row_num=$(cat file.txt|wc -l)
echo $row_num
if [ $row_num -lt 10 ];then
    echo "The number of row is less than 10"
else
    awk '{if(NR==10){print $0}}' file.txt
fi

#其中NF表示当前记录的字段数（即列数）
#$i 文件中每行以间隔符号分割的不同字段
awk '{for(i=1;i<=NF;i++){print $i}}' words.txt

cat words.txt | xargs -n1
awk '{for(i=1;i<=NF;i++){asso_array[$i]++;}};END{for(w in asso_array){print w,asso_array[w];}}' words.txt

#sort工具用于排序，它将文件的每一行作为一个单位，从首字母向后按照ASCII码值进行比较，默认将他们升序输出。
#
#-r : 降序排列
#
#-n : 以数字排序，默认是按照字符排序的。
#
#uniq用去取出连续的重复行
#
#-c ：统计重复行的次数

[root@localhost ~]# cat words.txt | xargs -n1 | sort | uniq -c | sort -rn | awk '{print $2,$1}'

awk '{for(i=1;i<=NF;i++){print "row[",i,"]="$i}}' file.txt
awk '{for(i=1;i<=NF;i++){if(NR==1){row[i]=$i} else{row[i]=row[i]" "$i}}};END{for(i=1;i<=NF;i++){print row[i]}}' content.txt