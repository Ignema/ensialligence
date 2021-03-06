import CreatePost from "../CreatePost/CreatePost"
import PostList from "../PostList/PostList"
import { useState } from "react"
import './Scrollview.css';

const Scrollview = () => {

    const [posts, setPosts] = useState([]);

    return (
        <div className="scrollviewContainer">
            <CreatePost posts={posts} setPosts={setPosts}/>
            <PostList posts={posts} setPosts={setPosts}/>
        </div>
    )
}

export default Scrollview
