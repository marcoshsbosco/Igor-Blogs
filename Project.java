import java.util.Scanner;

class Project {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        User user = new User("Fulano");

        while (true) {
            System.out.println("\n----- Igor Artigos -----");
            System.out.println("1. Create a post");
            System.out.println("2. View user info");
            System.out.println("0. Exit");

            String choice = input.nextLine();

            if (choice.equals("0")) {
                System.exit(0);
            } else if (choice.equals("1")) {
                Post post = user.post();
                post.info();
            } else if (choice.equals("2")) {
                user.info();
            }
        }
    }
}
