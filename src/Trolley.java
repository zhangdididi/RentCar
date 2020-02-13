//轿车
public class Trolley extends Car {
    private double day_Rent;//日租金

    //轿车构造方法
    //车名，品牌，数量，日租金
    public Trolley(String car_Name, String car_Label, int car_Num, double day_Rent) {
        this.car_Name = car_Name;
        this.car_Label = car_Label;
        this.car_Num = car_Num;
        this.day_Rent = day_Rent;
    }

    //重写父类计算租金价格方法
    @Override
    double getRentPrice(int day) {
        return day * day_Rent;
    }

    //重写父类打印车辆信息方法
    @Override
    void printCarInfo() {
        System.out.printf("轿车：%s\t%5s\t%d\t%s\t\n", this.car_Name, this.car_Label, this.car_Num, this.day_Rent);
    }
}
