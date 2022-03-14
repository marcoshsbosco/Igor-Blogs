import java.util.*;
import java.lang.Math;

class User {
    int id;
    String name;
    boolean admin;
    ArrayList<Integer> postIds = new ArrayList<Integer>();
    ArrayList<Integer> likedPostIds = new ArrayList<Integer>();

    public User(String name) {
        id = (int) (Math.random() * (1024));
        admin = false;
    }

    public Post post(String content) {
        Post post = new Post(this.id, content);
        postIds.add(post.id);

        return post;
    }

    public void like(Post post) {
        likedPostIds.add(post.id);
        post.addLike();
    }

    public Comment comment(String content, Post post) {
        Comment comment = new Comment(post.id, id, content);

        post.addComment(comment);

        return comment;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void info() {
        System.out.println("\n--- User ---");
        System.out.print("User ID: ");
        System.out.println(id);
        System.out.print("Post IDs: ");
        System.out.println(postIds);
        System.out.print("Liked post IDs: ");
        System.out.println(likedPostIds);
        System.out.println("------------");
    }
}
