import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

class ImagePost extends Post {
    String imagePath;

    public ImagePost(int authorId, String content, String imagePath) {
        super(authorId, content);
        this.imagePath = imagePath;
    }

    public void save() {
        try {
            File file = new File("./data/posts/");
            file.mkdir();
            FileWriter writer = new FileWriter("data/posts/" + Integer.toString(id) + ".json");
            JSONObject json = new JSONObject();

            json.put("id", id);
            json.put("authorId", authorId);
            json.put("likes", likes);
            json.put("content", content);
            json.put("comments", comments);
            json.put("moderated", moderated);
            json.put("imagePath", imagePath);

            writer.write(json.toJSONString());
            writer.close();
        } catch (IOException e) {
            System.out.println("IO error.");
            e.printStackTrace();
        }
    }
}
