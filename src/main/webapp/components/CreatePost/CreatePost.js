import './CreatePost.css';
import { useState } from "react"
import { FaUserCircle } from 'react-icons/fa';

const CreatePost = ({addPost}) => {

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
                            addPost({
                                titre: "title",
                                categorie: "article", 
                                nbjaimeart: 20,
                                video: textareaValue
                            })
                            setTextareaValue("")
                        }}></input>
                </div>
            </div>
        </div>
    )
}

export default CreatePost
