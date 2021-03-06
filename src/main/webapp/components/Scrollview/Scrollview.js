import CreatePost from "../CreatePost/CreatePost"
import PostList from "../PostList/PostList"
import { useState, useEffect } from "react"
import './Scrollview.css';

const Scrollview = () => {

    const [posts, setPosts] = useState([]);

    useEffect(() => {
        fetch("/arts").then(articles => articles.json()).then(articles => {
            articles.map(article => fetch("/articles/"+ article.idarticle +"/comments").then(comments => ({...article, comments: comments})))
            console.log(articles)
            setPosts([articles, ...posts])
        });
    }, [posts])

    function addPost(_post){
        fetch("/save", {method: "POST", body: _post}).then((new_post)=>{
            setPosts([new_post, ...posts])
        }).catch(err => console.log(err));
    }

    return (
        <div className="scrollviewContainer">
            <CreatePost setPosts={addPost}/>
            <PostList posts={posts} setPosts={addPost}/>
        </div>
    )
}

export default Scrollview
