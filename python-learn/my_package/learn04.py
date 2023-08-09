"""文件操作"""
f = open("C:\\Work\\file.txt","r",encoding="UTF-8")
print(f.read())  # readLine 读一行 会续接上一个read方法
# readLines 一行一行读
for line in f:
    print(line)

f.close()

with open("C:\\Work\\file.txt","r",encoding="UTF-8") as file:
    for line in file:
        print(line)



autor = open("C:\\Work\\autor.txt","w",encoding="UTF-8")  # a模式 追加
autor.write("hello")
autor.flush()
autor.close()
