import './CreatePost.css';
import { FaUserCircle } from 'react-icons/fa';

const CreatePost = ({posts, setPosts}) => {
    return (
        <div className="createContainer">
            <FaUserCircle className="profileIcon" />
            <div className="createCtrls">
                <textarea className="createInput" rows="4" cols="50"  placeholder="What discovery did you make today?"></textarea>
                <div className="createBtns">
                    <input className="createBtn" type="button" value="Link"></input>
                    <input className="createBtn" type="button" value="Upload"></input>
                    <input className="createBtn createSubmit" type="button" value="Submit" onClick={() => { setPosts([...posts, 0])}}></input>
                </div>
            </div>
        </div>
    )
}

export default CreatePost
