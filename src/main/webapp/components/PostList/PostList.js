import Post from "../Post/Post"
import './PostList.css';


const PostList = ({posts, setPosts}) => {

    return (
        <div className="PostListContainer">
           {posts.map(post => <Post key={post.id} post={post} posts={posts} setPosts={setPosts} />)}
        </div>
    )
}

export default PostList
