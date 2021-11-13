package socialmedia;

import org.junit.Test;
import socialmedia.FacebookPost;
import socialmedia.Post;
import socialmedia.RedditPost;

import static org.junit.Assert.*;

public class TestPost {
    @Test
    public void TestControversial() {
        // More downvote
        RedditPost rp = new RedditPost("user");
        rp.setCountUpVote(10);
        rp.setCountDownVote(20);

        // More angry reactions
        FacebookPost fp1 = new FacebookPost("user");
        fp1.getReactions().add(new FacebookPost.FacebookReaction(FacebookPost.FacebookReaction.Reactiontype.Angry));
        fp1.getReactions().add(new FacebookPost.FacebookReaction(FacebookPost.FacebookReaction.Reactiontype.Angry));
        fp1.getReactions().add(new FacebookPost.FacebookReaction(FacebookPost.FacebookReaction.Reactiontype.Like));

        // More comments than cotes
        FacebookPost fp2 = new FacebookPost("user");
        fp2.getReactions().add(new FacebookPost.FacebookReaction(FacebookPost.FacebookReaction.Reactiontype.Like));
        fp2.getComments().add(new FacebookPost.FacebookComment("comment1"));
        fp2.getComments().add(new FacebookPost.FacebookComment("comment2"));
        fp2.getComments().add(new FacebookPost.FacebookComment("comment3"));

        assertEquals(Post.PopularityType.Controversial, rp.getPopularityType());
        assertEquals(Post.PopularityType.Controversial, fp1.getPopularityType());
        assertEquals(Post.PopularityType.Controversial, fp2.getPopularityType());
    }
}
