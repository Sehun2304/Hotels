package hotels;

public class Customer {
    String name;
    String phoneNum;
    String money;

    Customer() {}

    Customer(String name, String phoneNum, String money) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getMoney() {
        return money;
    }
}