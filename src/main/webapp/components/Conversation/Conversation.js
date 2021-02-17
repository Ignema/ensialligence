import MessageList from '../MessageList/MessageList';
import SendMessage from '../SendMessage/SendMessage';
import './Conversation.css';

const Conversation = () => {
    return (
        <div className="conversationContainer">
            <MessageList />
            <SendMessage />
        </div>
    )
}

export default Conversation
