import java.util.*;
import java.lang.Math;

class User {
    int id;
    String name;
    ArrayList<Integer> postIds = new ArrayList<Integer>();

    public User() {
        id = (int) (Math.random() * (1024));
    }

    public Post post() {
        String content;
        Scanner input = new Scanner(System.in);

        System.out.println("\nType in the contents of your post!");
        content = input.nextLine();

        Post post = new Post(this.id, content);
        postIds.add(post.id);

        return post;
    }

    public void info() {
        System.out.println("\n--- User ---");
        System.out.print("User ID: ");
        System.out.println(id);
        System.out.print("Post IDs: ");
        System.out.println(postIds);
        System.out.println("------------");
    }
}
