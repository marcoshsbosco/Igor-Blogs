import java.lang.Math;

class Post {
    int id, authorId, likes;
    String content;

    public Post(int authorId, String content) {
        this.authorId = authorId;
        this.content = content;
        id = (int) (Math.random() * 1024);
    }

    public void addLike() {
        likes += 1;
    }

    public void info() {
        System.out.println("\n--- Post ---");
        System.out.println(content);
        System.out.println("---");
        System.out.print("Author ID: ");
        System.out.println(authorId);
        System.out.print("Post ID: ");
        System.out.println(id);
        System.out.print("Likes: ");
        System.out.println(likes);
        System.out.println("------------");
    }
}
