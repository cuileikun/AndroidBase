package com.cuileikun.androidbase.javaactivity.nine.抽象类的概述和讲解;

/**
 假如我们在开发一个系统时需要对员工类进行设计，员工包含3个属性：姓名、工号以及工资。
 经理也是员工，除了含有员工的属性外，另为还有一个奖金属性。
 请使用继承的思想设计出员工类和经理类。要求类中提供必要的方法进行属性访问。
 分析：
 普通员工类
 成员属性:  姓名,工号,工资
 构造方法： 有参，无参
 成员方法： set,get,show,工作
 经理
 成员属性:  姓名,工号,工资,奖金
 构造方法： 有参，无参
 成员方法： set,get,show,工作



 实现
 员工类
 普通员工类
 经理
 */
/**
 员工类
 */
abstract class EmployeerSecond
{
    private String name;
    private int    age ;
    private int  money;

    public EmployeerSecond(){}
    public EmployeerSecond(String name ,int age ,int money)
    {
        this.name=name ;
        this.age =age;
        this.money=money;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public void setMoney(int money)
    {
        this.money=money;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age ;
    }
    public int getMoney()
    {
        return money;
    }
    public abstract void work();
}


class ManagerSecond extends EmployeerSecond
{
    private int id;
    public ManagerSecond(){}
    public ManagerSecond(String name ,int age ,int money)
    {
        super(name,age ,money);
    }
    public void setId(){
        this.id=id;
    }
    public int getId()
    {
        return id;
    }
    public void work()
    {
        System.out.println("经理管理员工");
    }

}

class ProgrammerSecond extends EmployeerSecond
{
    public ProgrammerSecond(){}
    public ProgrammerSecond(String name ,int age ,int money)
    {
        super(name ,age ,money);
    }
    public void work()
    {
        System.out.println("员工干活");
    }
}

public class EmployeerTest {
    public static void main(String []args)
    {
        EmployeerSecond em=new ManagerSecond();
        em.setName("年伟");
        em.setAge(15);
        em.setMoney(8500);
        System.out.println("姓名"+em.getName()+"年龄"+em.getAge()+"金钱"+em.getMoney());
        em.work();

    }
}
