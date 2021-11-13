package socialmedia;

import org.junit.Test;
import socialmedia.RedditPost;

import static org.junit.Assert.assertEquals;

public class TestRedditPost {
    @Test
    public void TestCommentCount() {
        RedditPost r = new RedditPost("user");

        // Comments:
        // hello
        // |__ hi
        //     |__ how are you
        //         |__ fine
        //     |-- hey! welcome
        // |__ long time
        //     |__ yeah
        // Hi I am new.
        // Total comments: 8

        RedditPost.RedditComment rc1 = new RedditPost.RedditComment("hello");
        RedditPost.RedditComment rc11 = new RedditPost.RedditComment("hi");
        RedditPost.RedditComment rc111 = new RedditPost.RedditComment("how are you");
        RedditPost.RedditComment rc1111 = new RedditPost.RedditComment("fine");


        RedditPost.RedditComment rc112 = new RedditPost.RedditComment("hey welcome");

        RedditPost.RedditComment rc12 = new RedditPost.RedditComment("long time");
        RedditPost.RedditComment rc121 = new RedditPost.RedditComment("yeah");
        RedditPost.RedditComment rc2 = new RedditPost.RedditComment("Hi I am new");

        rc111.getComments().add((rc1111));
        rc11.getComments().add(rc111);
        rc11.getComments().add(rc112);
        rc12.getComments().add(rc121);
        rc1.getComments().add(rc11);
        rc1.getComments().add(rc12);
        r.getComments().add(rc1);
        r.getComments().add(rc2);

        assertEquals(8, r.getCommentCount());
    }
}
