import java.lang.Math;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;

class Post {
    int id, authorId, likes;
    String content;
    boolean moderated = false;
    ArrayList<Integer> commentIds = new ArrayList<Integer>();
    ArrayList<Comment> comments = new ArrayList<Comment>();

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
        commentIds.add(comment.getId());
    }

    public void setModerated() {
        moderated = true;
    }

    public boolean getModerated() {
        return moderated;
    }

    public int getId() {
        return id;
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

    public void save() {
        try {
            File file = new File("./data/posts/");
            file.mkdirs();
            FileWriter writer = new FileWriter("data/posts/" + Integer.toString(id) + ".json");
            JSONObject json = new JSONObject();

            json.put("id", id);
            json.put("authorId", authorId);
            json.put("likes", likes);
            json.put("content", content);
            json.put("commentIds", commentIds);
            json.put("moderated", moderated);

            writer.write(json.toJSONString());
            writer.close();
        } catch (IOException e) {
            System.out.println("IO error.");
            e.printStackTrace();
        }
    }

    public void load(String filename) {
        File file = new File("data/posts/" + filename);
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(file));
            JSONObject json = (JSONObject) obj;

            id = ((Long) json.get("id")).intValue();
            authorId = ((Long) json.get("authorId")).intValue();
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

    public void loadComments() {
        for (Object commentId : commentIds) {
            Comment comment = new Comment(0, 0, "");
            comment.load(((Long) commentId).intValue());
            comments.add(comment);
        }
    }

    public void delete() {
        File file = new File("data/posts/" + Integer.toString(id) + ".json");
        file.delete();
    }
}
