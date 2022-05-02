/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

/**
 *
 * @author maria
 */
class Admin extends User {
    public Admin(String name) {
        super(name);

        admin = true;
    }

    public void acceptPost(Post post) {
        post.setModerated();
    }

    public void acceptPost(ImagePost post) {
        post.setModerated();
    }
}