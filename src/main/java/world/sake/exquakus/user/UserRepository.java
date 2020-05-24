package world.sake.exquakus.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository {

    private final Map<Long, UserResource> users = new HashMap<>();

    public List<UserResource> findAll() {
        return new ArrayList<>(users.values());
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

    @PostConstruct
    public void testsetup() {
        LongStream.rangeClosed(1, 10).forEach(index -> {
            UserResource user = new UserResource();
            user.id = index;
            user.name = "name" + index;
            user.username = "username" + index;

            users.put(user.id, user);
        });
    }
}
