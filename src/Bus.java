//客车
public class Bus extends Car {
    private int seat_Num;//客车座位数量
    private double day_RentOfBig;//大型客车租金(15座以上)
    private double day_RnetOfSamll;//小型客车租金(15座以下)

    //客车构造方法
    //车名，品牌，数量，座位数，大型客车日租金，小型客车日租金
    public Bus(String car_Name, String car_Label,
               int car_Num, int  seat_Num, double day_RentOfBig, double day_RnetOfSamll) {
        this.car_Name = car_Name;
        this.car_Label = car_Label;
        this.car_Num = car_Num;
        this.seat_Num = seat_Num;
        this.day_RentOfBig = day_RentOfBig;
        this.day_RnetOfSamll = day_RnetOfSamll;
    }

    //重写父类计算租金价格方法
    @Override
    double getRentPrice(int day) {
        if (seat_Num > 15) {
            return this.day_RentOfBig * day;
        } else {
            return this.day_RnetOfSamll * day;
        }
    }

    //重写父类打印车辆信息方法
    @Override
    void printCarInfo() {
        System.out.printf("客车：%s\t%s\t%d\t%s\t%s\n",
                this.car_Name, this.car_Label, this.car_Num, this.day_RnetOfSamll, this.day_RentOfBig);

    }
}
