# 数据容器 列表list 元组tuple 字符串str 集合set 字典dict
name_list = ["it",111,["com",888]]
print(name_list[-1][0][0])
print(name_list[-2])
print(name_list[-3])

i = name_list.index("it")
print(i)
name_list.insert(1,"ccc")
name_list.append("尾部添加单个")
name_list.extend(["尾部","添加","多个"])
print(name_list)

del name_list[-1]
name_list.pop(0)
name_list.remove(111) # 删除第一个匹配项
print(name_list)
l = name_list.count(111)
print(f"元素111个数为{l}")
name_list.clear() # 清空列表
print(name_list)
count = len(name_list)
print(f"列表长度{count}")


def while_fun():
    name_list = ["it", 111, ["com", 888]]
    index = 0;
    while index < len(name_list):
        print(name_list[index])
        index+=1

def for_fun():
    name_list = ["it", 111, ["com", 888]]
    for i in name_list:
        print(i)
while_fun()
for_fun()

"""
列表 可以封装多个不同类型的元素，可以修改
元组 最大不同在于不可修改
"""
t1 = ("it",111,("com",222))
t2 = ("it",)
print(t1[0])

"""字符串 不可修改 字符的容器"""
str = "it com "
print(str[2])
print(str[1])
newStr = str.replace("it","item")
print(newStr)
strList = str.split(" ")
print(strList)
"""strip 去除指定字符"""
print(str.strip())

"""
列表 元组 字符串 可称为序列
序列的切片 从一个序列中取一个子序列
"""
res = str[1:5:1]
print(res)

"""
set 无序 不重复
"""
mySet = {"set","jihe","不可重复","add","remove","pop随机取出一个元素","clear","difference取出两个集合的差集","jihe1.difference_update(jihe2)在集合1中消除和集合二中相同的元素","union合并两个集合"}
print(mySet)
p = mySet.pop()
print(mySet)
print(p)

"""字典"""
obj = {
    "zl":18,
    "xd":19,
    "xl":20
}
obj.pop("zl")
print(obj)

o = {
    "list":"列表",
    (1,2,3):"元组",
    "set":"集合",
    1:"num"
}
print(o)
keys = o.keys() #获取全部key
for k in keys:
    print(o[k])

for k in o:
    print(o[k])

"""sorted 排序 转成列表"""
