package com.cuileikun.androidbase.javaactivity.seven.成员方法;

/*
	标准的手机类练习

	手机类：
		成员变量：brand,price,color
		构造方法：无参构造
		成员方法：getXxx()/setXxx()
*/
//定义手机类
class PhoneSecond {
    //品牌
    private String brand;
    //价格
    private int price;
    //颜色
    private String color;

    //无参构造方法
    public PhoneSecond() {}

    //getXxx()和setXxx()方法
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

public class PhoneTestSecond {
    public static void main(String[] args) {
        //创建对象
        PhoneSecond p = new PhoneSecond();

        //给成员变量赋值
        p.setBrand("诺基亚");
        p.setPrice(199);
        p.setColor("土豪金");

        //获取值
        System.out.println(p.getBrand()+"---"+p.getPrice()+"---"+p.getColor());
    }
}
