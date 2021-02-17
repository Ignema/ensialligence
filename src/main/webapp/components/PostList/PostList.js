import Post from "../Post/Post"
import './PostList.css';


const PostList = ({posts}) => {
    return (
        <div className="PostListContainer">
           {posts.map(post => <Post />)}
        </div>
    )
}

export default PostList
