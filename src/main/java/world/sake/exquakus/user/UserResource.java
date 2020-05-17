package world.sake.exquakus.user;

/**
 * see https://jsonplaceholder.typicode.com/users
 * @author neginuki
 */
public class UserResource {

    public Long id;

    public String name;

    public String username;

    public String email;

    public Address address;

    public static class Address {

        public String street;

        public String suite;

        public String city;

        public String zipcode;
    }
}
