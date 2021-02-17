import './SendMessage.css';
import { FaCaretRight } from 'react-icons/fa';

const SendMessage = () => {
    return (
        <div className="sendMessageContainer">
            <div className="sendMessageFields">
                <textarea className="sendMessageInput" name="w3review" rows="1" cols="50"  placeholder="Start typing..."></textarea>
                <div className="sendMessageSubmit">
                    <FaCaretRight className="sendMessageCaret" />
                </div>
            </div>
        </div>
    )
}

export default SendMessage
