import './PostHistory.css';
import { FaFile } from 'react-icons/fa';

const PostHistory = () => {
    return (
        <div className="postHistoryContainer">
            <p className="postHistoryTitle">Posts by Hiba</p>
            <ul className="postHistoryList">
                <li className="postHistoryItem">
                    <FaFile className="postHistoryFaFile" />
                    <p className="postHistoryName">TCP is actually more complexe than you’d think...</p>
                </li>
                <li className="postHistoryItem">
                    <FaFile className="postHistoryFaFile" />
                    <p className="postHistoryName">TCP is actually more complexe than you’d think...</p>
                </li>
                <li className="postHistoryItem">
                    <FaFile className="postHistoryFaFile" />
                    <p className="postHistoryName">TCP is actually more complexe than you’d think...</p>
                </li>
                <li className="postHistoryItem">
                    <FaFile className="postHistoryFaFile" />
                    <p className="postHistoryName">TCP is actually more complexe than you’d think...</p>
                </li>
            </ul>
        </div>
    )
}

export default PostHistory
