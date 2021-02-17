import Ad from "../Ad/Ad"
import PostHistory from "../PostHistory/PostHistory"
import './ChatPanel.css'

const ChatPanel = () => {
    return (
        <div className="outerChatPanel">
            <div className="innerChatPanel">
                <Ad />
                <PostHistory />
            </div>
        </div>
    )
}

export default ChatPanel
