import './Post.css';
import { useState } from "react"
import { FaHeart, FaCommentAlt, FaShareAlt } from 'react-icons/fa'; 

const Post = ({body, liked}) => {

    const [like, setLike] = useState(liked)

    return (
        <div className="postContainer">
            <div className="postBody">
                {body !== "" ? body : "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque varius tortor id aliquet condimentum. Nam euismod nunc quis nibh viverra feugiat. Nam eget laoreet neque. Aliquam interdum condimentum augue id faucibus. Aenean faucibus, quam et iaculis porttitor, leo arcu feugiat lacus, vitae posuere nulla libero sit amet dolor. Phasellus malesuada libero et eros consectetur, eget faucibus libero lacinia. Sed venenatis suscipit ante sit amet malesuada. Suspendisse convallis diam quam, sit amet bibendum risus sodales in. Nunc congue erat vitae turpis consequat, ut placerat ex viverra. Etiam maximus aliquet sagittis."  } 
            </div>
            <div className="postMeta">
                <div className="posterProfile"></div>
                <div className="postPoster">
                    <p className="posterName">Houda</p>
                    <p className="posterAction">posted an article</p>
                    <p className="postDate">{new Date().toLocaleString()}</p>
                </div>
                <div className="postIcons">
                    <FaHeart className={"postIcon" + (like ? " postHearted" : "")} onClick={() => setLike(!like)}/>
                    <FaCommentAlt className="postIcon" />
                    <FaShareAlt className="postIcon" />
                </div>
            </div>
        </div>
    )
}

export default Post
