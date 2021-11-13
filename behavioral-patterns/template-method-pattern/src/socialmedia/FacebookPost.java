package socialmedia;

import java.util.ArrayList;
import java.util.List;

/**
 * A Facebook post consisting of 5 reactions and comments.
 */
class FacebookPost extends Post {

    private List<FacebookReaction> reactions = new ArrayList<>();
    private List<FacebookComment> comments = new ArrayList<>();

    public FacebookPost(String username) {
        super(username);
    }

    public List<FacebookReaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<FacebookReaction> reactions) {
        this.reactions = reactions;
    }

    public List<FacebookComment> getComments() {
        return comments;
    }

    public void setComments(List<FacebookComment> comments) {
        this.comments = comments;
    }

    @Override
    protected int getCommentCount() {
        int count = 0;
        for (FacebookComment c : this.getComments()) {
            count++;
            for (String r: c.getReplies())
                count++;
        }
        return count;
    }

    @Override
    protected int getVoteCount() {
        int count = 0;
        for (FacebookReaction r : this.getReactions()) {
            // Angry reaction is interpreted as downvote.
            if (r.type == FacebookReaction.Reactiontype.Angry)
                count--;
            else
                count++;
        }
        return count;
    }

    /**
     * A Facebook reaction that can be of type: like, haha, sad, love or angry.
     */
    static class FacebookReaction {
        public enum Reactiontype {Like, Haha, Sad, Love, Angry};

        private Reactiontype type;

        public Reactiontype getType() {
            return type;
        }

        public void setType(Reactiontype type) {
            this.type = type;
        }

        public FacebookReaction(Reactiontype type) {
            this.type = type;
        }
    }

    /**
     * A facebook comment, which can have only one level threading, called reply.
     */
    static class FacebookComment {
        private String content;
        private List<String> replies = new ArrayList<>();

        public FacebookComment(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<String> getReplies() {
            return replies;
        }

        public void setReplies(List<String> replies) {
            this.replies = replies;
        }
    }
}