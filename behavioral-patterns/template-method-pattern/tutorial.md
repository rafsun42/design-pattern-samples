# Template Method Pattern

## Example: Social Media

The `Post` class represents a social media post. It is an abstract class
that defines the template method `getPopularityType`. This template
method uses two properties of a social media post (vote count and comment
count) in order to determine if the post `Hot` or  `Controversial`.

The `getVoteCount` and `getCommentCount` methods are defined abstract. They
are implemented in the concrete class `RedditPost` and `FacebookPost` because
these two social media has different voting and comment system.

### Use of the pattern
The `Post` class defines the algorithm for determining popularity type of 
a social media post. This algorithm is similar for all social media. However,
two properties used in this algorithm, which are vote count and comment count, 
are unique for each social media. That is why these two methods are defined
in the concrete classes `RedditPost` and `FacebookPost`.