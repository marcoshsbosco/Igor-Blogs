class Admin extends User {
    public Admin(String name) {
        super(name);

        admin = true;
    }

    public void acceptPost(Post post) {
        post.setModerated();
    }
}
