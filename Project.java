import java.util.*;
import java.io.File;

class Project {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Admin user = new Admin("Fulano");
        //User user = new User("Fulano Jr.");
        ArrayList<Post> posts = new ArrayList<Post>();
        ArrayList<ImagePost> imagePosts = new ArrayList<ImagePost>();

        while (true) {
            System.out.println("\n----- Igor Artigos -----");
            System.out.println("1. Create a post");
            System.out.println("2. View user info");
            System.out.println("3. Like post");
            System.out.println("4. See text posts");
            System.out.println("5. Add comment");

            if (user.isAdmin() == true) {
                System.out.println("6. Moderate posts");
            }

            System.out.println("7. See image posts");
            System.out.println("0. Exit");

            String choice = input.nextLine();

            if (choice.equals("0")) {
                System.exit(0);
            } else if (choice.equals("1")) {
                System.out.println("\nType in the contents of your post:");
                String content = input.nextLine();

                System.out.println("\nType in the path of your image or leave empty if text only post: ");
                String path = input.nextLine();

                if (path.equals("")) {
                    Post post = user.post(content);
                    posts.add(post);
                    post.save();
                } else {
                    ImagePost post = user.postImage(content, path);
                    imagePosts.add(post);
                    post.save();
                }

                user.save();

            } else if (choice.equals("2")) {
                user.info();
            } else if (choice.equals("3")) {
                System.out.println("\nPost ID:");
                String postId = input.nextLine();

                for (Post post : posts) {
                    if (post.id == Integer.parseInt(postId)) {
                        user.like(post);
                        post.save();
                    }
                }

                for (ImagePost post : imagePosts) {
                    if (post.id == Integer.parseInt(postId)) {
                        user.like(post);
                        post.save();
                    }
                }

                user.save();
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

                        Comment comment = user.comment(content, post);
                        comment.save();
                        post.save();
                    }
                }
            } else if (choice.equals("6") && user.isAdmin() == true) {
                for (Post post : posts) {
                    if (post.getModerated() == false) {
                        post.info();
                    }
                }

                for (ImagePost post : imagePosts) {
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
                            post.save();
                        } else {
                            posts.remove(post);
                            post.delete();
                        }

                        break;
                    }
                }

                for (ImagePost post : imagePosts) {
                    if (post.id == Integer.parseInt(postId)) {
                        if (accept.equals("y")) {
                            user.acceptPost(post);
                            post.save();
                        } else {
                            imagePosts.remove(post);
                            post.delete();
                        }

                        break;
                    }
                }
            } else if (choice.equals("7")) {
                for (ImagePost post : imagePosts) {
                    if (post.getModerated() == true) {
                        post.info();
                    }
                }
            }
        }
    }
}
