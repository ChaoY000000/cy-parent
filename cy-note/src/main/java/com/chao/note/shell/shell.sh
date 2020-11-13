#!/usr/bin/env bash

your_name="chao"

# 单引号''
greeting='hello , '$your_name' !'
greeting_1='hello , '${your_name}' !'
greeting_2='hello , ${your_name} !'
echo $greeting  " -> " $greeting_1   " -> " $greeting_2

#双引号""
greeting="hello , "$your_name" !"
greeting_1="hello , /"${your_name}/" !"
greeting_2="hello , ${your_name} !"
echo $greeting  " -> " $greeting_1   " -> " $greeting_2


#获取字符串的长度
echo "your_name is length : "${#your_name}

