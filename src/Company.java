
public class Company {
    protected static Trolley[] trolleys;//轿车数组
    protected static Bus[] buses;//客车数组

    //初始化数组
    static {
        trolleys = new Trolley[10];
        buses = new Bus[5];

        trolleys[0] = new Trolley("大众", "桑塔纳2000", 2, 600);
        trolleys[1] = new Trolley("比亚迪", "F3", 1, 500);
        trolleys[2] = new Trolley("奥迪", "A6", 3, 1200);
        trolleys[3] = new Trolley("宝马", "X3", 2, 1500);
        trolleys[4] = new Trolley("奥迪", "Q7", 1, 2000);
        trolleys[5] = new Trolley("长城", "酷熊", 2, 500);
        trolleys[6] = new Trolley("大众", "passat", 2, 600);
        trolleys[7] = new Trolley("通用", "别克", 3, 500);
        trolleys[8] = new Trolley("本田", "思域", 1, 600);
        trolleys[9] = new Trolley("现代", "胜达", 2, 500);

        buses[0] = new Bus("东风", "EQ6364PF", 2, 12,1200, 1000);
        buses[1] = new Bus("大众", "DZ3472TY", 3, 18,1200, 1000);
        buses[2] = new Bus("奔驰", "BC6734DF", 1, 25,2000, 1500);
        buses[3] = new Bus("丰田", "FT9822DX", 0, 16,1200, 1000);
        buses[4] = new Bus("比亚迪", "BY6535CN", 2, 10,1200, 1000);
    }

    static void display_Trolley() {
        System.out.printf("车型：车名   品牌名   数量   日租金");
        System.out.println();
        for (Trolley trolley : trolleys) {
            trolley.printCarInfo();
        }
    }

    static void display_Bus() {
        System.out.printf("车型：车名  品牌名   数量   小型日租金  大型日租金");
        System.out.println();
        for (Bus bus : buses) {
            bus.printCarInfo();
        }
    }

    static Trolley getTrolley(String name, String label) {
        for (int i = 0; i < trolleys.length; i++) {
            if (name.equals(trolleys[i].car_Name) && label.equals(trolleys[i].car_Label)) {
                //在轿车数组中找到客户需要的汽车
                return trolleys[i];
            }
        }
        //没找到返回空
        return null;
    }

    static Bus getBus(String name, String label) {
        for (int i = 0; i < buses.length; i++) {
            if (name.equals(buses[i].car_Name) && label.equals(buses[i].car_Label)) {
                //在客车数组中找到客户需要的客车
                return buses[i];
            }
        }
        //没找到返回空
        return null;
    }
}
