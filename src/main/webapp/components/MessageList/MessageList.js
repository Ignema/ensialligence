import Message from '../Message/Message';
import './MessageList.css';

const MessageList = () => {
    return (
        <div className="messageListContainer">
            <Message position="left" />
            <Message position="right" />
            <Message position="right" />
            <Message position="left" />
            <Message position="right" />
            <Message position="left" />
            <Message position="right" />
            <Message position="left" />
            <Message position="left" />
        </div>
    )
}

export default MessageList
