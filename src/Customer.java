class Customer implements OrderObserver {
    private String name;

    public Customer(String name) {
        this.name = name;
    }
    public void update(String orderStatus) {
        System.out.println("Hello "+name+"! Your order is now "+ orderStatus);
    }
}
