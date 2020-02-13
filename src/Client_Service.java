import java.util.Scanner;

//租赁系统
public class Client_Service {

    public static void main(String[] args) {
        //新建一个服务器系统
        Client_Service service = new Client_Service();
        Scanner scanner = new Scanner(System.in);
        service.menu();
        int chooseNum = scanner.nextInt();

        while (true) {
            if (chooseNum == 1) {
                service.rentCar();
                break;
            } else if (chooseNum == 2) {
                service.sendBack();
                break;
            } else if (chooseNum == 0){
                System.out.println("您已退出该系统");
                System.exit(0);
            } else {
                System.out.println("输入错误，请重新输入");
                continue;
            }
        }
    }

    void menu() {
        System.out.println("====欢迎来到汽车租赁中心====");
        System.out.println("====请选择你需要的服务====" );
        System.out.println("1.租赁车辆 2.退换车辆 0.退出该系统");
    }

    //租赁车辆服务内容
    void rentCar() {
        System.out.println("====请选择您需要的汽车类型====");
        System.out.println("1.轿车  2.客车");
        Scanner scanner = new Scanner(System.in);
        int carType = scanner.nextInt();
        if (carType == 1) {
            while (true) {
                System.out.println("下面是目前拥有的轿车：");
                Company.display_Trolley();
                System.out.println("请输入您选择要租的汽车车名和品牌");
                String name = scanner.nextLine();
                String label = scanner.nextLine();
                Trolley rentalCar =  Company.getTrolley(name, label);
                if (rentalCar != null && rentalCar.car_Num > 0) {
                    //如果存在这辆车，并且数量大于零。就输入租用天数，计算总租金
                    System.out.println("请选择您要租用轿车的时长(天)");
                    int days = scanner.nextInt();
                    double totalRent = rentalCar.getRentPrice(days);
                    System.out.println("您本次租车的总租金为 " + totalRent);
                    //将该型汽车的数量减1
                    rentalCar.car_Num--;
                    break;
                } else {
                    //车辆不存在或者数量不够
                    System.out.println("对不起，您选择的车辆不存在或数量不足，请重新输入");
                    continue;
                }
            }
        } else if (carType == 2) {
            while (true) {
                System.out.println("下面是目前拥有的客车：");
                Company.display_Bus();
                System.out.println("请输入您选择要租的汽车车名和品牌");
                String name = scanner.nextLine();
                String label = scanner.nextLine();
                Bus rentalCar = Company.getBus(name, label);
                if (rentalCar != null && rentalCar.car_Num > 0) {
                    //如果存在这辆车，并且数量大于零。就输入租用天数，计算总租金
                    System.out.println("请选择您要租用客车的时长(天)");
                    int days = scanner.nextInt();
                    double totalRent = rentalCar.getRentPrice(days);
                    System.out.println("您本次租车的总租金为 " + totalRent);
                    //将该型汽车的数量减1
                    rentalCar.car_Num--;
                    break;
                } else {
                    //车辆不存在或者数量不够
                    System.out.println("对不起，您选择的车辆不存在或数量不足，请重新输入");
                    continue;
                }
            }
        }
        scanner.close();
    }

    void sendBack() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您退还的车辆类型");
        System.out.println("1.轿车  2.客车");
        int carType = scanner.nextInt();
        if (carType == 1) {
            while (true) {
                System.out.println("请输入您退还的车辆的车名和品牌名");
                String name = scanner.nextLine();
                String label = scanner.nextLine();
                Trolley trolley = Company.getTrolley(name, label);
                if (trolley != null) {
                    trolley.car_Num++;
                    break;
                } else {
                    System.out.println("您输入的车辆信息不存在，请重新输入");
                    continue;
                }
            }
            System.out.println("退还成功");
        } else {
            while (true) {
                System.out.println("请输入您退还的车辆的车名和品牌名");
                String name = scanner.nextLine();
                String label = scanner.nextLine();
                Bus bus = Company.getBus(name, label);
                if (bus != null) {
                    bus.car_Num++;
                } else {
                    System.out.println("您输入的车辆信息不存在，请重新输入");
                    continue;
                }
            }
        }
        scanner.close();
    }
}
