import ChatFriends from '../ChatFriends/ChatFriends';
import ChatPanel from '../ChatPanel/ChatPanel';
import Conversation from '../Conversation/Conversation';
import './ChatPage.css';

const ChatPage = () => {
    return (
        <div className="chatPageContainer">
            <ChatFriends />
            <Conversation />
            <ChatPanel />
        </div>
    )
}

export default ChatPage
