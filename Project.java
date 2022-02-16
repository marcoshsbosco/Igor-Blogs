import java.util.*;

class Project {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        User user = new User("Fulano");
        ArrayList<Post> posts = new ArrayList<Post>();

        while (true) {
            System.out.println("\n----- Igor Artigos -----");
            System.out.println("1. Create a post");
            System.out.println("2. View user info");
            System.out.println("3. Like post");
            System.out.println("4. See all posts");
            System.out.println("5. Add comment");
            System.out.println("0. Exit");

            String choice = input.nextLine();

            if (choice.equals("0")) {
                System.exit(0);
            } else if (choice.equals("1")) {
                System.out.println("\nType in the contents of your post:");
                String content = input.nextLine();

                Post post = user.post(content);
                posts.add(post);
            } else if (choice.equals("2")) {
                user.info();
            } else if (choice.equals("3")) {
                System.out.println("\nPost ID:");
                String postId = input.nextLine();

                for (Post post : posts) {
                    if (post.id == Integer.parseInt(postId)) {
                        user.like(post);
                    }
                }
            } else if (choice.equals("4")) {
                for (Post post : posts) {
                    post.info();
                }
            } else if (choice.equals("5")) {
                System.out.println("\nPost ID:");
                String postId = input.nextLine();

                for (Post post : posts) {
                    if (post.id == Integer.parseInt(postId)) {
                        System.out.println("\nType in the contents of your comment:");
                        String content = input.nextLine();

                        user.comment(content, post);
                    }
                }
            }
        }
    }
}
