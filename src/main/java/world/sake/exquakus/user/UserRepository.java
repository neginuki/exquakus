package world.sake.exquakus.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class UserRepository {

    public static Map<Long, UserResource> users = new HashMap<>();

    public List<UserResource> findAll() {
        return users.values().stream().collect(Collectors.toCollection(ArrayList::new));
    }

    public UserResource findById(long id) {
        return users.get(id);
    }

    public UserResource create(UserResource resource) {
        long newId = users.keySet().stream().mapToLong(id -> id).max().orElse(0L) + 1;
        resource.id = newId;

        users.put(newId, resource);

        return findById(newId);
    }

    public static UserRepository testsetup() {
        LongStream.rangeClosed(1, 10).forEach(index -> {
            UserResource user = new UserResource();
            user.id = index;
            user.name = "name" + index;
            user.username = "username" + index;

            users.put(user.id, user);
        });

        return new UserRepository();
    }
}
