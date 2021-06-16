from selenium import webdriver
import pymysql

def get_data_from_url(url):
    driver = webdriver.Firefox()
    driver.get(url)
    # 打印当前页面title
    print(driver.title)
    # 打印当前页面URL
    print(driver.current_url)
    distinct = driver.find_elements_by_class_name("data-menu-item")[5]
    distinct.click()
    btns = driver.find_elements_by_class_name("data-menu-item")[6:]
    lines = []
    for btn in btns:
        btn.click()
        appp1 = driver.find_element_by_id("app_1")
        table = appp1.find_element_by_tag_name("tbody")

        print(table.text)
        lines.append(table.text + '\n')
    # 关闭所有窗口
    driver.quit()
    # 将数据保存到txt文件
    with open('z_data.txt', "w", encoding='utf-8')  as f:
        f.writelines(lines)
    print("爬取数据成功！！!")



def write_mysql(host,port,user,passwd,database,charset):
    with open("z_data.txt", 'r', encoding='utf-8') as f:
        # for index,value in enumerate(f.readlines()):
        #     if value.startswith("序号"):
        #         print(index)
        lines = [line.rstrip('\n') for line in f.readlines()]
    # print(lines)
    # 打开数据库连接
    conn = pymysql.connect(host=host,
                           port=port,
                           user=user,
                           passwd=passwd,
                           database=database,
                           charset=charset)
    # 使用cursor()方法创建一个游标对象，等待输入SQL语句
    cursor = conn.cursor()
    # 插入数据
    sql = "insert into university values(%s,%s,%s,%s,%s,%s,%s)"

    for line in lines:
        data = line.split(";")[1:]
        if len(data) == 7:
            cursor.execute(sql, data)  # sql和data之间以","隔开
            conn.commit()  # 提交，不然无法保存插入或者修改的数据(这个一定不要忘记加上)
        elif data[0].isdigit():
            data.append(" ")
            cursor.execute(sql, data)  # sql和data之间以","隔开
            conn.commit()  # 提交，不然无法保存插入或者修改的数据(这个一定不要忘记加上)
        else:
            print(data)
    # 关闭数据库连接
    conn.close()
    print("Create table already! Please check Mysql!")

# 从指定url爬取数据
URL = 'https://www.cingta.com/school/ser'
HOST = '127.0.0.1'
PORT = 3306
USER = 'root'
PASSWD = 'root'
DATABASE = 'test'
CHARSET = 'utf8'
if __name__ == '__main__':
    # 爬取数据
    # get_data_from_url(URL)
    # data.txt文件 需要将 空格 替换 为 分号;
    # 写入mysql数据库
    write_mysql(HOST,PORT,USER,PASSWD,DATABASE,CHARSET)

