package socialmedia;

import org.junit.Test;
import socialmedia.*;

import static org.junit.Assert.*;

public class TestFacebookPost {
    @Test
    public void TestCommentCount() {
        FacebookPost f = new FacebookPost("user");
        FacebookPost.FacebookComment c = new FacebookPost.FacebookComment("Hello");
        c.getReplies().add("Hi");
        c.getReplies().add("How are you");
        c.getReplies().add("Good.");
        f.getComments().add(c);

        assertEquals(4, f.getCommentCount());
    }

    @Test
    public void TestVoteCount() {
        FacebookPost f = new FacebookPost("user");
        f.getReactions().add(new FacebookPost.FacebookReaction(FacebookPost.FacebookReaction.Reactiontype.Like));
        f.getReactions().add(new FacebookPost.FacebookReaction(FacebookPost.FacebookReaction.Reactiontype.Like));
        f.getReactions().add(new FacebookPost.FacebookReaction(FacebookPost.FacebookReaction.Reactiontype.Angry));
        f.getReactions().add(new FacebookPost.FacebookReaction(FacebookPost.FacebookReaction.Reactiontype.Haha));

        assertEquals(2, f.getVoteCount());
    }
}
