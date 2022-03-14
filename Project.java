import java.util.*;

class Project {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Admin user = new Admin("Fulano");
        //User user = new User("Fulano Jr.");
        ArrayList<Post> posts = new ArrayList<Post>();

        while (true) {
            System.out.println("\n----- Igor Artigos -----");
            System.out.println("1. Create a post");
            System.out.println("2. View user info");
            System.out.println("3. Like post");
            System.out.println("4. See all posts");
            System.out.println("5. Add comment");

            if (user.isAdmin() == true) {
                System.out.println("6. Moderate posts");
            }

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
                    if (post.getModerated() == true) {
                        post.info();
                    }
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
            } else if (choice.equals("6") && user.isAdmin() == true) {
                for (Post post : posts) {
                    if (post.getModerated() == false) {
                        post.info();
                    }
                }

                System.out.println("\nPost ID:");
                String postId = input.nextLine();

                System.out.println("\nAccept post? (y/n)");
                String accept = input.nextLine();

                for (Post post : posts) {
                    if (post.id == Integer.parseInt(postId)) {
                        if (accept.equals("y")) {
                            user.acceptPost(post);
                        } else {
                            posts.remove(post);
                        }

                        break;
                    }
                }
            }
        }
    }
}
