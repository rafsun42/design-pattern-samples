package socialmedia;

import java.util.ArrayList;
import java.util.List;

/**
 * A Reddit post with upvote, downvote and threads.
 */
class RedditPost extends Post {
    private int countUpVote;
    private int countDownVote;
    private List<RedditComment> comments = new ArrayList<>();

    public RedditPost(String username) {
        super(username);
    }

    public int getCountUpVote() {
        return countUpVote;
    }

    public void setCountUpVote(int countUpVote) {
        this.countUpVote = countUpVote;
    }

    public int getCountDownVote() {
        return countDownVote;
    }

    public void setCountDownVote(int countDownVote) {
        this.countDownVote = countDownVote;
    }

    public List<RedditComment> getComments() {
        return comments;
    }

    public void setComments(List<RedditComment> comments) {
        this.comments = comments;
    }

    @Override
    protected int getCommentCount() {
        int count = 0;
        for (RedditComment comment: this.getComments()) {
            count += getCommentCountRecursively(comment);
        }
        return count;
    }

    /**
     * Counts comments from every level of threads under the parameter comment, including itself.
     */
    private int getCommentCountRecursively(RedditComment redditComment) {
        int count = 1;
        for (RedditComment threadedComment: redditComment.getComments()) {
            count += getCommentCountRecursively(threadedComment);
        }
        return count;
    }

    @Override
    protected int getVoteCount() {
        return this.getCountUpVote() - this.getCountDownVote();
    }

    /**
     * A reddit thread, where each thread allows subthread, and subthread allows more subthread.
     */
    static class RedditComment {
        private String content;
        private List<RedditComment> threadedComments = new ArrayList<>();

        public RedditComment(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<RedditComment> getComments() {
            return threadedComments;
        }

        public void setThreadedComments(List<RedditComment> threadedComments) {
            this.threadedComments = threadedComments;
        }
    }
}