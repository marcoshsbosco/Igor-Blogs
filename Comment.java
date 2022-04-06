import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.util.*;

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

    public void load(int commentId) {
        File file = new File("data/comments/" + Integer.toString(commentId) + ".json");
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(file));
            JSONObject json = (JSONObject) obj;

            id = ((Long) json.get("id")).intValue();
            authorId = ((Long) json.get("authorId")).intValue();
            postId = ((Long) json.get("postId")).intValue();
            likes = ((Long) json.get("likes")).intValue();
            content = (String) json.get("content");
            commentIds = (ArrayList<Integer>) json.get("commentIds");
            moderated = (Boolean) json.get("moderated");

            if (commentIds == null) {
                commentIds = new ArrayList<Integer>();
            } else {
                this.loadComments();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
