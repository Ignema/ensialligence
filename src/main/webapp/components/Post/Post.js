import './Post.css';
import { useState } from "react"
import { FaHeart, FaCommentAlt, FaShareAlt } from 'react-icons/fa'; 

const Post = ({post, posts, setPosts}) => {

    const [like, setLike] = useState(post.liked)
    const [commentSection, showCommentSection] = useState(false)
    const [commentValue, setCommentValue] = useState("")

    function updateCommentValue(event){
        setCommentValue(event.target.value)
    }
    
    const Comment = ({index, comment}) => {
        const [like, setLike] = useState(comment.liked)
        return (
            <div className="postComment">
                <span><span className="postCommentOwner">{comment.owner}</span> {comment.body}</span>
                <FaHeart className={"postIcon" + (like ? " postHearted" : "")} onClick={() => {
                    posts[post.id].comments[index].liked = !comment.liked
                    setPosts(posts)
                    setLike(!like)
                }}/>
            </div>
        )
    }

    return (
        <>
            <div className="postContainer">
                <div className="postBody">
                    {post.body !== "" ? post.body : "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque varius tortor id aliquet condimentum. Nam euismod nunc quis nibh viverra feugiat. Nam eget laoreet neque. Aliquam interdum condimentum augue id faucibus. Aenean faucibus, quam et iaculis porttitor, leo arcu feugiat lacus, vitae posuere nulla libero sit amet dolor. Phasellus malesuada libero et eros consectetur, eget faucibus libero lacinia. Sed venenatis suscipit ante sit amet malesuada. Suspendisse convallis diam quam, sit amet bibendum risus sodales in. Nunc congue erat vitae turpis consequat, ut placerat ex viverra. Etiam maximus aliquet sagittis."  } 
                </div>
                <div className="postMeta">
                    <div className="posterProfile"></div>
                    <div className="postPoster">
                        <p className="posterName">Houda</p>
                        <p className="posterAction">posted an article</p>
                        <p className="postDate">{new Date().toLocaleString()}</p>
                    </div>
                    <div className="postIcons">
                        <FaHeart className={"postIcon" + (like ? " postHearted" : "")} onClick={() => {
                            posts[post.id].liked = !post.liked
                            setPosts(posts)
                            setLike(!like)
                        }}/>
                        <FaCommentAlt className="postIcon" onClick={() => showCommentSection(!commentSection)}/>
                        <FaShareAlt className="postIcon" />
                    </div>
                </div>
            </div>
            <div className="postCommentSection" style={{display: commentSection ? "block" : "none"}}>
                <div className="postCommentInsert">
                    <input type="text" value={commentValue} onChange={updateCommentValue}/>
                    <input type="submit" onClick={() => {
                        if(commentValue !== ""){
                            posts[post.id].comments.push({"owner": "Houda","body": commentValue, "liked": false})
                            setPosts(posts)
                            setCommentValue("")
                        }
                    }}/>
                </div>
                {post.comments.map((comment, index) => <Comment key={index} index={index} comment={comment}/>)}
            </div>
        </>
    )
}

export default Post
