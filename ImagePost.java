import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.util.*;

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
            FileWriter writer = new FileWriter("data/posts/i" + Integer.toString(id) + ".json");
            JSONObject json = new JSONObject();

            json.put("id", id);
            json.put("authorId", authorId);
            json.put("likes", likes);
            json.put("content", content);
            json.put("commentIds", commentIds);
            json.put("moderated", moderated);
            json.put("imagePath", imagePath);

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
            imagePath = (String) json.get("imagePath");

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
