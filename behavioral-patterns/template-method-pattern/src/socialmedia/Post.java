package socialmedia;

/**
 * A social media post consisting of content, votes and comments.
 */
abstract class Post {
    public static int HotThreshold = 1000;

    /**
     * Normal: Average number of votes.
     * Controversial: negative votes, or too much comments than votes.
     * Hot: Number of votes and comments are quite high.
     */
    public enum PopularityType {Normal, Controversial, Hot};

    private String username;
    private String content;

    protected Post() {
    }

    protected Post(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Returns the popularity type of the post. Available types can
     * be found in the PopularityType enum.
     *
     * @return socialmedia.Post.PopularityType
     */
    public PopularityType getPopularityType() {
        int voteCount = getVoteCount();
        int commentCount = getCommentCount();

        // To avoid division by zero.
        if (commentCount == 0)
            commentCount = 1;

        double vcRatio = voteCount / commentCount;

        // Controversial: Negative vote or twice more comment than votes.
        if (vcRatio < 0 || vcRatio < 0.5)
            return PopularityType.Controversial;

        // Hot: voteCount reached threshold for hot.
        if (voteCount > HotThreshold)
            return PopularityType.Hot;

        // Normal
        return PopularityType.Normal;
    }

    /**
     * Returns number of comments in the post.
     *
     * It includes threaded comments or replies as well.
     */
    protected abstract int getCommentCount();

    /**
     * Returns number of votes, reactions or likes in the post.
     *
     * The count can be negative if downvotes are a feature.
     */
    protected abstract int getVoteCount();
}
