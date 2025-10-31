public class User {
    private final String name;
    private final String email;
    private final int age;
    private final String address;

    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.address = builder.address;
    }

    public static class Builder {
        private final String name;
        private final String email;
        private int age;
        private String address;

        public Builder(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public Builder age(int age) { this.age = age; return this; }
        public Builder address(String address) { this.address = address; return this; }
        public User build() { return new User(this); }
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', email='%s', age=%d, address='%s'}",
                name, email, age, address);
    }

    public static void main(String[] args) {
        User user = new User.Builder("John Doe", "john@example.com")
                        .age(30)
                        .address("Jakarta, Indonesia")
                        .build();
        System.out.println(user);
    }
}