"""异常"""

try:
    1/0
except Exception as e:
    print(e)
else:
    print("无异常")
finally:
    print("无论有无异常都会执行")


def fun01(x,y):
    return x+y


def fun02():
    print(fun01(x=1,y=2))

fun02()

