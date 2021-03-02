import './Chat.css';
import { FaUserAlt, FaElementor } from 'react-icons/fa';
import { Link } from 'react-router-dom';

const Chat = () => {
    return (
        <div className="chatContainer">
            <ul>
                <li>
                    <FaUserAlt className="chatIcon" /> 
                </li>
                <li>
                    <FaUserAlt className="chatIcon" />  
                </li>
                <li>
                    <Link to="/chat"> 
                        <FaElementor className="chatIcon" />  
                    </Link>
                </li>
            </ul>
        </div>
    )
}

export default Chat
