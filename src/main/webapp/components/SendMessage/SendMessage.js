import './SendMessage.css';
import { useState } from "react"
import { FaCaretRight } from 'react-icons/fa';

const SendMessage = ({messages, setMessages}) => {

    const [textareaValue, setTextareaValue] = useState("")

    function updateTextareaValue(event){
        setTextareaValue(event.target.value)
    }

    return (
        <div className="sendMessageContainer">
            <div className="sendMessageFields">
                <textarea className="sendMessageInput" name="w3review" rows="1" cols="50"  placeholder="Start typing..." value={textareaValue} onChange={updateTextareaValue}></textarea>
                <div className="sendMessageSubmit" onClick={() => {
                        setMessages([...messages, {id: messages.length, body: textareaValue, date: (new Date()).toLocaleTimeString()}])
                        setTextareaValue("")
                    }}>
                    <FaCaretRight className="sendMessageCaret" />
                </div>
            </div>
        </div>
    )
}

export default SendMessage
