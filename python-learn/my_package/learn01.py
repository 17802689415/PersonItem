import random

print("hello")
str1 = "hello"
print(10)
str2 = 10
str = "%sworld,数量%s" % (str1, str2)
print(str)
# %5d将整数宽度控制在5
# %5.2f宽度为5，小数点精度为2，小数点也占一位宽度
if str2 > 15:
    print("true")
print("缩进关系")

if str2 > 18:
    print("成年")
else:
    print("未成年")

if str2 > 18:
    print("大于18")
elif str2 >= 10:
    print("大于等于10")
else:
    print("else")

num = random.randint(1, 10)
print(num)

i = 1
sum = 0
while i <= 100:
    sum += i
    print(i, end="")
    i += 1
print(sum)

# for处理字符串
for s in str1:
    print(s)

range(10) # 0到10 不包括10
range(5,10)
range(5,10,2) # 间隔2


"""
def 函数名(参数):
    函数体
    return 返回值 
"""
def change():
    global str2
    str2 = 20

change()
print(str2)

str3 = str1[:-2]
print(str3)