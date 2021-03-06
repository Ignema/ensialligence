import './Post.css';
import { useState } from "react"
import { FaHeart, FaCommentAlt, FaShareAlt } from 'react-icons/fa'; 

const Post = ({post, posts, setPosts}) => {

    const [likes, setLikes] = useState(post.nbjaimeart)
    const [commentSection, showCommentSection] = useState(false)
    const [commentValue, setCommentValue] = useState("")

    function updateCommentValue(event){
        setCommentValue(event.target.value)
    }
    
    const Comment = ({index, comment}) => {
        const [likes, setLikes] = useState(comment.nbJaimeCom)
        return (
            <div className="postComment">
                <span><span className="postCommentOwner">{comment.owner}</span> {comment.body}</span>
                <FaHeart className={"postIcon" + (likes > 0 ? " postHearted" : "")} onClick={() => {
                    posts[post.id].comments[index].nbJaimeCom = likes + 1
                    setPosts(posts)
                    setLikes(likes+1)
                }}>
                    {(likes > 0 )? <p>likes</p> : <p>0</p>} 
                </FaHeart>
            </div>
        )
    }

    return (
        <>
            <div className="postContainer">
                <div className="postBody">
                    {post.video !== "" ? post.video : "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque varius tortor id aliquet condimentum. Nam euismod nunc quis nibh viverra feugiat. Nam eget laoreet neque. Aliquam interdum condimentum augue id faucibus. Aenean faucibus, quam et iaculis porttitor, leo arcu feugiat lacus, vitae posuere nulla libero sit amet dolor. Phasellus malesuada libero et eros consectetur, eget faucibus libero lacinia. Sed venenatis suscipit ante sit amet malesuada. Suspendisse convallis diam quam, sit amet bibendum risus sodales in. Nunc congue erat vitae turpis consequat, ut placerat ex viverra. Etiam maximus aliquet sagittis."  } 
                </div>
                <div className="postMeta">
                    <div className="posterProfile"></div>
                    <div className="postPoster">
                        <p className="posterName">{localStorage.getItem('username')}</p>
                        <p className="posterAction">posted an {post.categorie}</p>
                        <p className="postDate">{new Date().toLocaleString()}</p>
                    </div>
                    <div className="postIcons">
                        <FaHeart className={"postIcon" + (likes > 0 ? " postHearted" : "")} onClick={() => {
                            posts[post.id].nbjaimeart = likes + 1
                            setPosts(posts)
                            setLikes(likes + 1)
                        }}>
                            {(likes > 0 )? <p>likes</p> : <p>0</p>}
                        </FaHeart>
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
                            posts[post.id].comments.push({"owner": localStorage.getItem('username'),"comment": commentValue, "nbJaimeCom": 0})
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
