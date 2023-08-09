def test_return():
    return "返回多个返回值",2,[1,"zl"],{"oo":123,"pp":456}
if __name__ == '__main__':
    z, x, c, v = test_return()
    print(z)
    print(x)
    print(c)
    print(v)



def info(name,age,job="py"):  # 设置默认值必须在最后
    print(f"name:{name},age:{age},job:{job}")

if __name__ == '__main__':
    info(name="zl", age=18, job="java")
    info(name="zl", age=18)


def test(**kwargs):
    for i in kwargs.keys():
        print(kwargs[i])

if __name__ == '__main__':
    test(name="zl", age=20, job="java")



"""函数作为参数传入"""
def count():
    res = com(1,2)
    print(res)
# count(lambda x,y:x+y)

def com(x,y):
    res = x+y
    return res

if __name__ == '__main__':
    count()



