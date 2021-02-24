import MessageList from '../MessageList/MessageList';
import SendMessage from '../SendMessage/SendMessage';
import { useState } from 'react';
import './Conversation.css';

const Conversation = () => {
    const [messages, setMessages] = useState([])

    return (
        <div className="conversationContainer">
            <MessageList messages={messages} user="right"/>
            <SendMessage messages={messages} setMessages={setMessages} />
        </div>
    )
}

export default Conversation
