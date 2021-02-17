import './Chat.css';
import { FaUserAlt, FaElementor } from 'react-icons/fa';

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
                    <FaElementor className="chatIcon" />  
                </li>
            </ul>
        </div>
    )
}

export default Chat
