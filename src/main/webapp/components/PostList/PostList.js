import Post from "../Post/Post"
import './PostList.css';


const PostList = ({posts}) => {

    return (
        <div className="PostListContainer">
           {posts.map(post => <Post key={post.id} body={post.body} liked={post.liked} />)}
        </div>
    )
}

export default PostList
