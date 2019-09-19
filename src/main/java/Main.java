public class Main {
    public static void main(String[] args) {
        User user=new User("Gunay");
        System.out.println(user.getName());
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
