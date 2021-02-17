import './ChatFriends.css';
import { FaUser } from 'react-icons/fa';

const ChatFriends = () => {
    return (
        <div className="outerChatFriends">
            <div className="innerChatFriends">
                <div className="chatFriendsTitle">
                    Your Friends
                </div>
                <ul className="chatFriendsList">
                    <li className="chatFriendsItem">
                        <div className="chatFriendsName">
                            <FaUser className="chatFriendsFaUser" />
                            Hiba
                        </div>
                    </li>
                    <li className="chatFriendsItem">
                        <div className="chatFriendsName">
                            <FaUser className="chatFriendsFaUser" />
                            Houda
                        </div>
                    </li>
                    <li className="chatFriendsItem">
                        <div className="chatFriendsName">
                            <FaUser className="chatFriendsFaUser" />
                            Adam
                        </div>
                    </li>
                    <li className="chatFriendsItem">
                        <div className="chatFriendsName">
                            <FaUser className="chatFriendsFaUser" />
                            Younes
                        </div>
                    </li>
                    <li className="chatFriendsItem">
                        <div className="chatFriendsName">
                            <FaUser className="chatFriendsFaUser" />
                            Leila
                        </div>
                    </li>
                    <li className="chatFriendsItem">
                        <div className="chatFriendsName">
                            <FaUser className="chatFriendsFaUser" />
                            Mouna
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    )
}

export default ChatFriends