##!/bin/bash
#
#
#
#awk 'NR == 10' file.txt NR在awk中指行号
#
#sed -n 10p file.txt -n表示只输出匹配行，p表示Print
#
#
#
#tail -n+10 file.txt|head -1 tail -n +10表示从第10行开始输出
#
#cat words.txt | tr -s ' ' '\n'|sort|uniq -c |sort -r|awk '{print $2" "$1}'
#
#解释给和我一样的菜鸟们呜呜呜
#cat words.txt | tr -s ' ' '\n'|sort|uniq -c |sort -r|awk '{print $2" "$1}'
#
#cat ——浏览文件
#tr -s ——替换字符串（空格换为换行）保证了一行一个单词
#sort ——默认ASCII值排序，排序号后还会有重复
#uniq —— 去重，-c再输出重复次数。结果就是 ”4 abc“ abc出现了4次
#sort -r —— 反向排序，也就是从大到小。得到按频率高低的结果
#awk ——格式化输出，规定输出是先字符串再重复次数，所以先$2再$1，中间空格分隔