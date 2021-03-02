import Message from '../Message/Message';
import './MessageList.css';

const MessageList = ({messages, user}) => {
    return (
        <div className="messageListContainer">
            {messages.map(message => <Message key={message.id} message={message} position={user}/>)}
            {/* <Message position="left" />
            <Message position="right" />
            <Message position="right" />
            <Message position="left" />
            <Message position="right" />
            <Message position="left" />
            <Message position="right" />
            <Message position="left" />
            <Message position="left" /> */}
        </div>
    )
}

export default MessageList
