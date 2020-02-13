abstract class Car {
    protected String car_Name;//车名
    protected String car_Label;//车的品牌
    protected int car_Num;//车的数量

    //根据租赁时间得到租金
    abstract double getRentPrice(int day);

    //打印车辆的信息
    abstract void printCarInfo();
}
