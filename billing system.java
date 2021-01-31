package com.lb.test01;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //定义一个字符串，用来接收整个收支的明细
        String details = "";
        //定义一个变量，接余额
        int balance = 0; //初始化金额为0

        while(true) {
            System.out.println("------欢迎使用billing system------");
            System.out.println("1.收支明细");
            System.out.println("2.登记收入");
            System.out.println("3.登记支出");
            System.out.println("4.退出");
            System.out.println("请输入你要使用的功能：");

            //拿来一个扫描器
            Scanner scanner = new Scanner(System.in);
            //接收键盘录入的int类型的数据
            int choice = scanner.nextInt();
            //对录入的choice做过滤
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                System.out.println("你输入的信息有误，请重新输入：");
                int newChoice = scanner.nextInt();
                choice = newChoice;
            }
            //根据输入的数字，判断对应的功能
            switch (choice){
                case 1:
                    System.out.println("记账系统--->收支明细");
                    //如果直接输出details，最后会多出一个换行，
                    //System.out.println(details);\
                    //换种写法
                    /*String s = details.substring(0, details.length() - 1);
                    System.out.println(s);*/
                    //优化
                    //System.out.println(details.substring(0, details.length() - 1));
                    if (details != ""){
                        System.out.println(details.substring(0, details.length() - 1));
                    }else {
                        System.out.print(details);
                    }
                    break;
                case 2:
                    System.out.println("记账系统--->登记收入");
                    System.out.println("请输入收支金额：");
                    int income = scanner.nextInt();
                    System.out.println("请输入收入说明：");
                    String incomeDetail = scanner.next();
                    balance += income;
                    details = details + "收入：" + income + "，收入说明：" + incomeDetail + "，账户余额：" + balance + "\n";
                    break;
                case 3:
                    System.out.println("记账系统--->登记支出");
                    System.out.println("请输入支出金额：");
                    int expend = scanner.nextInt();
                    System.out.println("请输入支出说明：");
                    String expendDetail = scanner.next();
                    balance -= expend;
                    details = details + "支出：" + expend + "，支出说明：" + expendDetail + "，账户余额：" + balance + "\n";
                    break;
                case 4:
                    System.out.println("记账系统--->退出功能");
                    System.out.println("确定退出系统？ Y/N：");
                    String isExit = scanner.next();
                    switch (isExit) {
                        case "Y":
                            System.out.println("系统退出，欢迎下次使用！");
                            return; //结束当前方法
                    }
            }
        }

    }
}
