import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

class Comment extends Post {
    int postId;

    public Comment(int postId, int authorId, String content) {
        super(authorId, content);
        this.postId = postId;

        id = (int) (Math.random() * 1024);
    }

    public void info() {
        System.out.println("\n- Comment -");
        System.out.println(content);
        System.out.println("---");
        System.out.print("Author ID: ");
        System.out.println(authorId);
        System.out.print("Comment ID: ");
        System.out.println(id);
        System.out.print("Post ID: ");
        System.out.println(postId);
        System.out.print("Likes: ");
        System.out.println(likes);
    }

    public void save() {
        try {
            File file = new File("./data/comments/");
            file.mkdir();
            FileWriter writer = new FileWriter("data/comments/" + Integer.toString(id) + ".json");
            JSONObject json = new JSONObject();

            json.put("id", id);
            json.put("authorId", authorId);
            json.put("likes", likes);
            json.put("content", content);
            json.put("comments", comments);
            json.put("moderated", moderated);
            json.put("postId", postId);

            writer.write(json.toJSONString());
            writer.close();
        } catch (IOException e) {
            System.out.println("IO error.");
            e.printStackTrace();
        }
    }
}
