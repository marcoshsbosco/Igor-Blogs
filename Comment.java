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
        System.out.print("Likes: ");
        System.out.println(likes);
    }
}
