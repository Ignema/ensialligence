import './CreatePost.css';
import { useState } from "react"
import { FaUserCircle } from 'react-icons/fa';

const CreatePost = ({posts, setPosts}) => {

    const [textareaValue, setTextareaValue] = useState("")

    function updateTextareaValue(event){
        setTextareaValue(event.target.value)
    }

    return (
        <div className="createContainer">
            <FaUserCircle className="profileIcon" />
            <div className="createCtrls">
                <textarea className="createInput" rows="4" cols="50"  placeholder="What discovery did you make today?" value={textareaValue} onChange={updateTextareaValue}></textarea>
                <div className="createBtns">
                    <input className="createBtn" type="button" value="Link"></input>
                    <input className="createBtn" type="button" value="Upload"></input>
                    <input className="createBtn createSubmit" type="button" value="Submit" onClick={() => { 
                            setPosts([{id: 0, body: textareaValue, liked: false, comments: []}, ...posts.map(post => ({id: post.id + 1, body: post.body, liked: post.liked, comments: post.comments}))])
                            setTextareaValue("")
                        }}></input>
                </div>
            </div>
        </div>
    )
}

export default CreatePost
