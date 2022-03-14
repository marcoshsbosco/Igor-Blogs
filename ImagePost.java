class ImagePost extends Post {
    String imagePath;

    public ImagePost(int authorId, String content, String imagePath) {
        super(authorId, content);
        this.imagePath = imagePath;
    }
}
