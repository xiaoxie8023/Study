package Work;

/**
 * program: 2024.5.9
 * description: 电脑类
 * author: xiaoxie
 *create: 2024-05-30 10:42
 **/
public class Computer {
    private USB[] usbSlots = new USB[4]; // 假设电脑有4个USB插槽
    private int slotOccupied = 0; // 记录已占用的插槽数量

    // 安装USB设备方法
    public boolean addUSB(USB usb) {
        if (slotOccupied < usbSlots.length) {
            usbSlots[slotOccupied] = usb;
            slotOccupied++;
            System.out.println(usb.getClass().getSimpleName() + "已安装。");
            return true;
        } else {
            System.out.println("USB插槽已满，无法安装更多设备。");
            return false;
        }
    }

    // 开机方法
    public void powerOn() {
        System.out.println("计算机正在启动...");
        for (USB usb : usbSlots) {
            if (usb != null) {
                usb.turnOn();
            }
        }
        System.out.println("计算机启动完成。");
    }

    // 关机方法
    public void powerOff() {
        System.out.println("计算机正在关闭...");
        for (USB usb : usbSlots) {
            if (usb != null) {
                usb.turnOff();
            }
        }
        System.out.println("计算机已关闭。");
    }
}
