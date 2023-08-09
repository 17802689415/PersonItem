class Student:
    name = None
    """私有属性与方法只在类内使用"""
    __gender = None
    age = None
    def say_hi(self):
        print(f"你好{self.name}")

    """构造方法"""
    def __init__(self,name,gender,age):
        self.name = name
        self.gender = gender
        self.age = age

    """toString"""
    def __str__(self):
        return f"{self.name}{self.gender}{self.age}"

    """比较   le小于等于，大于等于  eq等于"""
    def __lt__(self, other):
        return self.age < other.age

"""继承 可多继承  继承靠左优先级高"""
class Student_New(Student):
    #pass
    def __str__(self):
        return f"{self.name}{self.gender}{self.age}"


# stu_1 = Student()
# stu_1.name = "zl"
# stu_1.gender = "man"
# stu_1.age = 18
# print(stu_1)
# stu_1.say_hi()

stu_2 = Student("xd","man",18)
stu_2.say_hi()
print(stu_2)
stu_1 = Student("x1","man",17)
print(stu_2<stu_1)

stu_3 = Student_New("z1","man",16)
print(stu_3)
