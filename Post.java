import java.lang.Math;
import java.util.*;

class Post {
    int id, authorId, likes;
    String content;
    ArrayList<Comment> comments = new ArrayList<Comment>();
    boolean moderated = false;

    public Post(int authorId, String content) {
        this.authorId = authorId;
        this.content = content;
        id = (int) (Math.random() * 1024);
    }

    public void addLike() {
        likes += 1;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void setModerated() {
        moderated = true;
    }

    public boolean getModerated() {
        return moderated;
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

        System.out.println("Comments: ");
        for (Comment comment : comments) {
            comment.info();
        }

        System.out.println("------------");
    }
}
